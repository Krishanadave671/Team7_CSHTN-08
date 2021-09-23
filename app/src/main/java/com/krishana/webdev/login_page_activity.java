package com.krishana.webdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_page_activity extends AppCompatActivity {
    ImageView backbtn_main;
    Button login_log;
    TextView createsignup;
    private FirebaseAuth mAuth;
    TextInputLayout loginEmail,loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        backbtn_main = findViewById(R.id.backbtn_main);
        login_log = findViewById(R.id.login_log);
        createsignup = findViewById(R.id.createsignup);
        loginEmail = findViewById(R.id.Email_log);
        loginPassword = findViewById(R.id.Password_log);
        backbtn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_page_activity.this,welcomePage.class));
            }
        });
        createsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_page_activity.this,register_page.class));
            }
        });
        login_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Password = loginPassword.getEditText().getText().toString().trim();
                String Email = loginEmail.getEditText().getText().toString().trim();
                mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login_page_activity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login_page_activity.this,MainActivity.class));
                    }
                        else{
                            Toast.makeText(login_page_activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}