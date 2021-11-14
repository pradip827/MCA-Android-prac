package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sdsmdg.tastytoast.TastyToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Practical_14_1 extends AppCompatActivity {

    EditText txtFirstName, txtLastName, txtUserName, txtPassword, txtConfPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical141);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfPassword = findViewById(R.id.txtConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtFirstName.getText())) {
                    TastyToast.makeText(getApplicationContext(), "First Name Required", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else if (TextUtils.isEmpty(txtLastName.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Last Name Required", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else if (TextUtils.isEmpty(txtUserName.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Email ID Required", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else if (TextUtils.isEmpty(txtPassword.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Password Required", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else if (TextUtils.isEmpty(txtConfPassword.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Confirm Password Required", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else {
                    if (txtConfPassword.getText().toString().equals(txtPassword.getText().toString())) {
                        registerUser(txtFirstName.getText().toString().trim(), txtLastName.getText().toString().trim(), txtUserName.getText().toString().trim(), txtConfPassword.getText().toString().trim());
                    } else {
                        TastyToast.makeText(getApplicationContext(), "Passwords are not same", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }
                }
            }
        });
    }

    private void registerUser(String firstname, String lastname, String username, String password) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://18.224.170.148/IMCOSTMCA/Account/RegisterUser",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("firstname", firstname);
                params.put("lastname", lastname);
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}