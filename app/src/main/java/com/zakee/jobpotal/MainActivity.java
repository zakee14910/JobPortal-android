package com.zakee.jobpotal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private  EditText password;

    private Button login;
    private Button registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFunction();
    }

    private void  LoginFunction(){
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        login = findViewById(R.id.btnLogin);
        registration = findViewById(R.id.btnRegistration);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

    }
}