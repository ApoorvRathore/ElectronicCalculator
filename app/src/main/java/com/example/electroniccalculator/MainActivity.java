package com.example.electroniccalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView displayText;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button button_sqr_root, button_exponent, button_dot;
    Button button_clear, button_backspace;
    Button button_equal;
    Button button_plus, button_minus, button_product, button_div;
    LinearLayout linearLayout;
    double first_number;
    double second_number;
    double number;
    String operator;

    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.etTextArea);
        button_clear = findViewById(R.id.button_clear);
        button_plus = findViewById(R.id.btn_plus);
        button_minus = findViewById(R.id.btn_minus);
        button_product = findViewById(R.id.btn_product);
        button_div = findViewById(R.id.btn_div);
        button_equal = findViewById(R.id.btn_equal);
        linearLayout = findViewById(R.id.linear_layout1);
        button_exponent = findViewById(R.id.btn_exponent);
        button_sqr_root = findViewById(R.id.btn_sqr_root);
        button_backspace = findViewById(R.id.btn_backspace);
        b0 = findViewById(R.id.btn0);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        button_dot = findViewById(R.id.btn_dot);
//        perform click listener on number
        try {
            b0.setOnClickListener(view -> displayText.append("0"));
            b1.setOnClickListener(view -> displayText.append("1"));
            b2.setOnClickListener(view -> displayText.append("2"));
            b3.setOnClickListener(view -> displayText.append("3"));
            b4.setOnClickListener(view -> displayText.append("4"));
            b5.setOnClickListener(view -> displayText.append("5"));
            b6.setOnClickListener(view -> displayText.append("6"));
            b7.setOnClickListener(view -> displayText.append("7"));
            b8.setOnClickListener(view -> displayText.append("8"));
            b9.setOnClickListener(view -> displayText.append("9"));

            button_dot.setOnClickListener(view -> displayText.append("."));

//        Perform click listener on clear button
            button_clear.setOnClickListener(view -> clear());
            button_backspace.setOnClickListener(view -> removeLastCharacter());
        } catch (Exception e) {
            displayText.setText((CharSequence) e);
        }
//      Perform click listener on operator
        try {
            button_plus.setOnClickListener(view -> add());
            button_minus.setOnClickListener(view -> subtract());
            button_product.setOnClickListener(view -> multiply());
            button_div.setOnClickListener(view -> division());
            button_sqr_root.setOnClickListener(view -> square_root());
            button_exponent.setOnClickListener(view -> exponent());
            button_equal.setOnClickListener(view -> equal());
        } catch (ArithmeticException exception) {
            displayText.setText((CharSequence) exception);
        }
    }

    private void clear() {
        displayText.setText("");
    }

    void equal() {
        second_number = Double.parseDouble(displayText.getText().toString());
        result = 0;
        switch (operator) {
            case "+":
                result = first_number + second_number;
                break;
            case "-":
                result = first_number - second_number;
                break;
            case "*":
                result = first_number * second_number;
                break;
            case "/":
                try {
                    result = first_number / second_number;
                    break;
                } catch (ArithmeticException exception) {
                    displayText.setText((CharSequence) exception);
                }
            case "^":
                result = Math.pow(first_number, second_number);
                break;
        }
        displayText.setText(String.valueOf(result));
    }

    void add() {
        first_number = Double.parseDouble(displayText.getText().toString());
        displayText.setText("");
        operator = "+";
    }

    void subtract() {
        first_number = Double.parseDouble(displayText.getText().toString());
        displayText.setText("");
        operator = "-";
    }

    void multiply() {
        first_number = Double.parseDouble(displayText.getText().toString());
        displayText.setText("");
        operator = "*";
    }

    void division() {
        first_number = Double.parseDouble(displayText.getText().toString());
        displayText.setText("");
        operator = "/";
    }

    void square_root() {
        number = Double.parseDouble(displayText.getText().toString());
        double result = Math.sqrt(number);
        displayText.setText(String.valueOf(result));
    }

    void exponent() {
        first_number = Double.parseDouble(displayText.getText().toString());
        displayText.setText("");
        operator = "^";
    }

    void removeLastCharacter() {
        String text = displayText.getText().toString();
        if (!text.isEmpty()) {
            text = text.substring(0, text.length() - 1);
            displayText.setText(text);
        }
    }
}





