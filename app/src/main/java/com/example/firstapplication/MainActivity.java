package com.example.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private boolean firstHalf = true;
    private double firstNum=0.0;
    private double secondNum=0.0;
    private double resultNum = 0.0;
    private char operatorChar = ' ';
    private String output = "";
    private String firstNumString = "";
    private String secondNumString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Toast toast = Toast.makeText(getApplicationContext(), "Now choose an operand!", Toast.LENGTH_SHORT);

        final TextView resultBox = (TextView) findViewById(R.id.resultBox);


        final Button[] buttons = new Button[10];
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);
        buttons[9] = (Button) findViewById(R.id.button0);

        Button clearButton = (Button) findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultBox.setText("");
                firstNumString = "";
                secondNumString = "";
                firstNum = 0.0;
                secondNum = 0.0;
                output = "";
                firstHalf = true;
                operatorChar = ' ';
            }
        });

        final Button equalsButton = (Button) findViewById(R.id.buttonEquals);

        final Button[] operators = new Button[5];
        operators[0] = (Button) findViewById(R.id.buttonAdd);
        operators[1] = (Button) findViewById(R.id.buttonSubtract);
        operators[2] = (Button) findViewById(R.id.buttonMultiply);
        operators[3] = (Button) findViewById(R.id.buttonDivide);

        for (int i =0; i < 4; i++){ //This is for all the operators EXCEPT the equals (=) sign
            final int j = i;
            operators[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String temp = (String) operators[j].getText();

                    resultBox.append(operators[j].getText()); //Displaying the operators on the textbox
                    operatorChar = temp.charAt(0); //Operation character is the operator (+, -, /, *)

                    firstHalf = false;


                }
            });
        }

        equalsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                firstNumString += ".0";
                secondNumString += ".0";
                firstNum = Double.parseDouble(firstNumString);
                secondNum = Double.parseDouble(secondNumString);


                if (operatorChar == '+') {
                    resultNum = firstNum + secondNum;
                } else if (operatorChar == '-') {
                    resultNum = firstNum - secondNum;
                } else if (operatorChar == '*') {
                    resultNum = firstNum * secondNum;
                } else if (operatorChar == '/') {
                    resultNum = firstNum / secondNum;
                }

                resultBox.setText("");
                output = Double.toString(resultNum);
                resultBox.append(output);
            }

        });




        for (int i = 0; i < 10; i++){
            final int j = i;
            buttons[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resultBox.append(buttons[j].getText());
                    if (firstHalf){
                        firstNumString += buttons[j].getText().toString();
                    }
                    else if (firstHalf == false){
                        secondNumString += buttons[j].getText().toString();
                    }



                }
            });
        }



    }




}

