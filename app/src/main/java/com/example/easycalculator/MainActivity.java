package com.example.easycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTV, solutionTv;
    MaterialButton buttonC,button0,buttonEquals,buttonAdd,button1,button2,button3,buttonSub,button4,button5,button6,buttonMult,button7,button8,button9,buttonDiv;
    String operation="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignID(buttonC, R.id.button_clear);
        assignID(buttonEquals, R.id.button_equals);
        assignID(buttonAdd, R.id.button_add);
        assignID(buttonMult, R.id.button_multiply);
        assignID(buttonSub, R.id.button_subtract);
        assignID(buttonDiv, R.id.button_divide);

        assignID(button0, R.id.button0);
        assignID(button1, R.id.button1);
        assignID(button2, R.id.button2);
        assignID(button3, R.id.button3);
        assignID(button4, R.id.button4);
        assignID(button5, R.id.button5);
        assignID(button6, R.id.button6);
        assignID(button7, R.id.button7);
        assignID(button8, R.id.button8);
        assignID(button9, R.id.button9);

    }

    void assignID(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();
        String calculate = solutionTv.getText().toString();
        int num1,num2;

        switch (buttonText) {
            case "C":
                solutionTv.setText("");
                resultTV.setText("");
                break;
            case "+":
                if (!resultTV.equals("")) {
                    num1 = Integer.parseInt(solutionTv.getText().toString());
                    operation = "+";
                    String val = String.valueOf(num1);
                    resultTV.setText(val);
                    solutionTv.setText("");
                }
                break;
            case "-":
                if (!resultTV.equals("")) {
                    num1 = Integer.parseInt(solutionTv.getText().toString());
                    operation = "-";
                    String val = String.valueOf(num1);
                    resultTV.setText(val);
                    solutionTv.setText("");
                }
                break;
            case "*":
                if (!resultTV.equals("")) {
                    num1 = Integer.parseInt(solutionTv.getText().toString());
                    operation = "*";
                    String val = String.valueOf(num1);
                    resultTV.setText(val);
                    solutionTv.setText("");
                }
                break;
            case "/":
                if (!resultTV.equals("")) {
                    num1 = Integer.parseInt(solutionTv.getText().toString());
                    operation = "/";
                    String val = String.valueOf(num1);
                    resultTV.setText(val);
                    solutionTv.setText("");
                }
                break;
            case "=":
                num1 = Integer.parseInt(resultTV.getText().toString());
                num2 = Integer.parseInt(solutionTv.getText().toString());
                resultTV.setText(calculateNumbers(num1, num2, operation));
                solutionTv.setText("");
                break;
            default:
                calculate = calculate + buttonText;
                solutionTv.setText(calculate);
                break;
        }
    }
    static String calculateNumbers(int num1, int num2, String operation){
        int total;
        String val = "";
        if(operation.equals("+")){
            total = num1+num2;
            val = String.valueOf(total);
        }
        if(operation.equals("-")){
            total = num1-num2;
            val = String.valueOf(total);
        }
        if(operation.equals("*")){
            total = num1*num2;
            val = String.valueOf(total);
        }
        if(operation.equals("/")){
            total = num1/num2;
            val = String.valueOf(total);
        }
        return val;
    }
}