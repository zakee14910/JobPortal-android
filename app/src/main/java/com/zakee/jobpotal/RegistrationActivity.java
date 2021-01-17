package com.zakee.jobpotal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email;
    private  EditText password;

    private Button login;
    private Button registration;

    //firebase auth
    private FirebaseAuth mAuth;
    //Progress dialog
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
        Registration();
    }

    private void  Registration(){
        email = findViewById(R.id.etEmailRegistration);
        password = findViewById(R.id.etPasswordRegistration);

        login = findViewById(R.id.btnLogin_reg);
        registration = findViewById(R.id.btnRegistration_reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = email.getText().toString().trim();
                String strPassword = email.getText().toString().trim();

                if(TextUtils.isEmpty(strEmail)){
                    email.setError("Required field..");
                    return;
                }
                if(TextUtils.isEmpty(strPassword)){
                    password.setError("Required field..");
                    return;
                }
                mDialog.setMessage("Processing");
                mDialog.show();

                mAuth.createUserWithEmailAndPassword(strEmail,strPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            mDialog.dismiss();
                        }else {
                            Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}