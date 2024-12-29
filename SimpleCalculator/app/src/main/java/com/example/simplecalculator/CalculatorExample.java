package com.example.simplecalculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorExample extends Activity {
    EditText firstNumber, secondNumber;
    TextView result;
    Button btnAdd, btnClear;
    @Override
    protected  void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.simple_calculator);
        firstNumber = findViewById(R.id.editFirst);
        secondNumber = findViewById(R.id.editSecond);
        result = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first, second, sum;
                first = Integer.valueOf(firstNumber.getText().toString());
                second = Integer.valueOf(secondNumber.getText().toString());
                sum = first + second;
                result.setText(String.valueOf(sum));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
            }
        });
    }
}
