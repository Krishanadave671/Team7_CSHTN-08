package com.krishana.webdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class login_page_activity extends AppCompatActivity {
    ImageView backbtn_main;
    Button login_log;
    TextView createsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        backbtn_main = findViewById(R.id.backbtn_main);
        login_log = findViewById(R.id.login_log);
        createsignup = findViewById(R.id.createsignup);
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
//        login_log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(login_page_activity.this,));
//            }
//        });
    }
}