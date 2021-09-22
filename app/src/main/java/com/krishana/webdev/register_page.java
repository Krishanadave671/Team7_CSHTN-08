package com.krishana.webdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class register_page extends AppCompatActivity {
    ImageView sign_up_back;
    Button btn_Register;
    EditText signinPassword,signinEmail,signin_username,githubProfile,fullName;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        sign_up_back = findViewById(R.id.sign_up_back);
        btn_Register = findViewById(R.id.btn_Register);
        signinPassword = findViewById(R.id.signinPassword);
        signinEmail = findViewById(R.id.signinEmail);
        signin_username = findViewById(R.id.signin_username);
        githubProfile = findViewById(R.id.githubProfile);
        fullName = findViewById(R.id.fullName);
        mAuth = FirebaseAuth.getInstance();
        sign_up_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register_page.this,welcomePage.class));
            }
        });
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signinEmail.getEditableText().toString();
                String password = signinPassword.getEditableText().toString();

            }
        });

    }
}