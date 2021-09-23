package com.krishana.webdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class welcomePage extends AppCompatActivity {
    Button loginbtn,signinbtn, skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        loginbtn = findViewById(R.id.login_btn);
        signinbtn= findViewById(R.id.signup_btn);
        skip = findViewById(R.id.welcome_skip);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(welcomePage.this,login_page_activity.class));
                finish();
            }
        });
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(welcomePage.this,register_page.class));
                finish();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(welcomePage.this,MainActivity.class));
            }
        });


    }
    @Override
    protected void onStart(){
            super.onStart();
            if(FirebaseAuth.getInstance().getCurrentUser() != null){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

    }
}