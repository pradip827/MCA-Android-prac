package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Practical_2_2 extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDec, btnAdd, btnSubtract, btnMultiply, btnDivide, btnEqualTo;
    EditText txtInput;
    String txtIP = "";
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical22);
        txtInput = findViewById(R.id.txtInput);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDec = findViewById(R.id.btnDec);
        btnAdd = findViewById(R.id.btnAddition);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiplication);
        btnEqualTo = findViewById(R.id.btnEqual);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDec.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEqualTo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                txtInput.setText(txtInput.getText() + "0");
                break;
            case R.id.btn1:
                txtInput.setText(txtInput.getText() + "1");
                break;
            case R.id.btn2:
                txtInput.setText(txtInput.getText() + "2");
                break;
            case R.id.btn3:
                txtInput.setText(txtInput.getText() + "3");
                break;
            case R.id.btn4:
                txtInput.setText(txtInput.getText() + "4");
                break;
            case R.id.btn5:
                txtInput.setText(txtInput.getText() + "5");
                break;
            case R.id.btn6:
                txtInput.setText(txtInput.getText() + "6");
                break;
            case R.id.btn7:
                txtInput.setText(txtInput.getText() + "7");
                break;
            case R.id.btn8:
                txtInput.setText(txtInput.getText() + "8");
                break;
            case R.id.btn9:
                txtInput.setText(txtInput.getText() + "9");
                break;
            case R.id.btnEqual:
                Expression expression = new ExpressionBuilder(txtInput.getText().toString()).build();
                double op = expression.evaluate();
                txtInput.setText(op + "");
                break;
            case R.id.btnDec:
                if (counter == 1) {
                    TastyToast.makeText(getApplicationContext(), "Not Allowed", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else {
                    txtInput.setText(txtInput.getText() + ".");
                    counter++;
                }
                break;
            case R.id.btnAddition:
                counter = 0;
                txtInput.setText(txtInput.getText() + "+");
                break;
            case R.id.btnSubtract:
                counter = 0;
                txtInput.setText(txtInput.getText() + "-");
                break;
            case R.id.btnMultiplication:
                counter = 0;
                txtInput.setText(txtInput.getText() + "*");
                break;
            case R.id.btnDivide:
                counter = 0;
                txtInput.setText(txtInput.getText() + "/");
                break;

        }
    }
}