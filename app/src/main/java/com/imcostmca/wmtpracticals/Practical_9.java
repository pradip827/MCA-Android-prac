package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

public class Practical_9 extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshEmployee;
    FloatingActionButton btnAdd;
    ListView lstEmployees;
    MyDBHelper myDBHelper;
    List<Employee> lstAllEmployees = new ArrayList<Employee>();
    List<String> lstEmployeeNames = new ArrayList<String>();
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9);

        btnAdd = findViewById(R.id.btnAdd);
        lstEmployees = findViewById(R.id.lstEmployees);
        myDBHelper = new MyDBHelper(getApplicationContext());
        swipeRefreshEmployee = findViewById(R.id.swipeRefreshEmployee);

        getEmployees();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_9_1.class));
            }
        });

        swipeRefreshEmployee.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getEmployees();
                swipeRefreshEmployee.setRefreshing(false);
            }
        });

        lstEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Practical_9_2.class);
                intent.putExtra("sEmployeeName",lstEmployeeNames.get(position));
                startActivity(intent);
            }
        });
    }

    private void getEmployees() {
        lstAllEmployees.clear();
        lstEmployeeNames.clear();
        lstAllEmployees = myDBHelper.getAllEmployee();
        for (Employee e : lstAllEmployees) {
            lstEmployeeNames.add(e.sEmployeeName);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lstEmployeeNames);
        Log.d("DBCount-Page", lstEmployeeNames.size() + " Items");
        lstEmployees.setAdapter(adapter);
    }
}