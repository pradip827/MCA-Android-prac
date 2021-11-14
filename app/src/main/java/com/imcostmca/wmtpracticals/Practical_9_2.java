package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_9_2 extends AppCompatActivity {

    EditText txtEmployee;
    Button btnEdit, btnDelete;
    Intent intent;
    MyDBHelper myDBHelper;
    Employee e = new Employee();
    Employee employee;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical92);

        intent = getIntent();

        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        txtEmployee = findViewById(R.id.txtEmpName);

        myDBHelper = new MyDBHelper(getApplicationContext());

        TastyToast.makeText(getApplicationContext(), intent.getStringExtra("sEmployeeName"), TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
        txtEmployee.setText(intent.getStringExtra("sEmployeeName"));
        employee = new Employee();
        e = myDBHelper.getEmployee(txtEmployee.getText().toString());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e.getsEmployeeName().toString().equals(txtEmployee.getText().toString())) {
                    TastyToast.makeText(getApplicationContext(), "Value is same", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else {
                    e.setsEmployeeName(txtEmployee.getText().toString());
                    if (myDBHelper.isEdit(e)) {

                        TastyToast.makeText(getApplicationContext(), "Record Updated Successfully", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                    } else {
                        TastyToast.makeText(getApplicationContext(), "Failed To Update", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Do You Want To Delete This Record?")
                        .setCancelable(false)
                        .setTitle(R.string.app_name)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (myDBHelper.isDelete(e)) {
                                    TastyToast.makeText(getApplicationContext(), "Record Deleted Successfully", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                                }
                                else{
                                    TastyToast.makeText(getApplicationContext(), "Failed To Delete Record", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
