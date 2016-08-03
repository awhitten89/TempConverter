package tempconverter.alan.com.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTemp;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editText);
        celButton = (Button) findViewById(R.id.celsius_button_id);
        fButton = (Button) findViewById(R.id.f_button_id);
        showTemp = (TextView) findViewById(R.id.textView);

        celButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else {

                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToCelsius(intEditText);

                    String Result = String.valueOf(round.format(convertedVal));

                    showTemp.setText(Result + " C ");
                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                } else {

                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(intEditText);

                    String Result = String.valueOf(round.format(convertedVal));

                    showTemp.setText(Result + " F ");
                }
            }
        });
    }

    public double convertToCelsius(double farValue){

        double resultCel;
        resultCel = (farValue - 32) * 5/9;

        return resultCel;
    }

    public double convertToFahrenheit(double celValue){

        double resultFar;
        resultFar = (celValue * 9/5) + 32;

        return resultFar;
    }
}
