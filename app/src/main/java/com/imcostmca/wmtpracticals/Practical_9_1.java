package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_9_1 extends AppCompatActivity {

    EditText txtEmployeeName;
    Button btnAddEmployee, btnReset;
    Employee employee;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical91);

        txtEmployeeName = findViewById(R.id.txtEmpName);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        btnReset = findViewById(R.id.btnReset);
        employee = new Employee();
        myDBHelper = new MyDBHelper(getApplicationContext());

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEmployeeName.setText("");
            }
        });

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtEmployeeName.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Add Employee Name", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else {
                    employee.setnID(0);
                    employee.sEmployeeName=txtEmployeeName.getText().toString();
                    if(myDBHelper.insertRecord(employee)){
                        TastyToast.makeText(getApplicationContext(), "Employee Added Successfully", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                    }
                    else{
                        TastyToast.makeText(getApplicationContext(), "Failed To Add Employee", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }
                }
            }
        });
    }
}