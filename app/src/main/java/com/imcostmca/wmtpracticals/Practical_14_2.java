package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import java.util.HashMap;
import java.util.Map;

public class Practical_14_2 extends AppCompatActivity {

    Button btnLogin;
    EditText txtUserName,txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical142);

        txtUserName = findViewById(R.id.txtUserName);
        txtPassword=findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txtUserName.getText()) && TextUtils.isEmpty(txtPassword.getText())){
                    TastyToast.makeText(getApplicationContext(),"Enter Credentials",TastyToast.LENGTH_SHORT,TastyToast.ERROR);
                }else{
                    login(txtUserName.getText().toString().trim(),txtPassword.getText().toString().trim());
                }
            }
        });
    }
    protected  void login(String username,String password){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://18.224.170.148/IMCOSTMCA/Account/Login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Server_Response",response);
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
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}