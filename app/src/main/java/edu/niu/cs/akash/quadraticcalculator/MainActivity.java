package edu.niu.cs.akash.quadraticcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    // instance variables
    EditText aET,bET,cET;
    TextView sol1TV,sol2TV;
    Double a,b,c,sol1,sol2,disc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Connecting the Edit Text fields on screen to inztance variables
        aET = (EditText) findViewById(R.id.aEditText);
        bET = (EditText) findViewById(R.id.bEditText);
        cET = (EditText) findViewById(R.id.cEditText);
        // Connecting the solution Texxtviews on screento TV variables
        sol1TV = (TextView)findViewById(R.id.sol1TextView);
        sol2TV = (TextView)findViewById(R.id.sol2TextView);
        //Create Button to connect to on screen button
        Button calcButton = (Button) findViewById(R.id.calcButton);
        // Set on click listener
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check to see if data exists
                if(aET.getText().toString().matches("") || bET.getText().toString().matches("") || cET.getText().toString().matches(""))
                {
                    Toast.makeText(v.getContext(),"No field can be left empty..!!", Toast.LENGTH_LONG).show();
                    return;
                }
                // Check to see if a is zero
                if(aET.getText().toString().matches("0"))
                {
                    Toast.makeText(v.getContext(),"Field for 'a' cannot be zero..!!", Toast.LENGTH_LONG).show();
                    return;
                }
                // parsing the values entered into double
                a = Double.parseDouble(aET.getText().toString());
                b = Double.parseDouble(bET.getText().toString());
                c = Double.parseDouble(cET.getText().toString());
                // Calculate discriminant
                disc = (b*b)- (4*a*c);
                // Check discrimant less than zeer. If yes print IMAGINARY as roots
                if(disc<0) {
                    sol1TV.setText("Imaginary");
                    sol2TV.setText("Imaginary");
                }
                //else calculate the solution
                else {
                    sol1 = ((-1 * b)+ Math.sqrt(disc))/(2*a);
                    sol2 = ((-1 * b)- Math.sqrt(disc))/(2*a);
                    // Create Decimal Format with format.
                    DecimalFormat s1 = new DecimalFormat("#.##");
                    DecimalFormat s2 = new DecimalFormat("#.##");
                    // Convert the soutions to Decimals
                    String solString1 = s1.format(sol1);
                    String solString2 = s2.format(sol2);
                    // Display solutions
                    sol1TV.setText(solString1);
                    sol2TV.setText(solString2);

                }

            }
        });

        // Clear Screen Button
        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aET.setText("");
                bET.setText("");
                cET.setText("");
                sol1TV.setText("");
                sol2TV.setText("");
            }
        });

    }
}
