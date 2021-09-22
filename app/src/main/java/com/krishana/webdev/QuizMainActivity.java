package com.krishana.webdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizMainActivity extends AppCompatActivity {
    Button gohtmlbtn,gocssbtn,gojavascriptbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);
        gohtmlbtn = findViewById(R.id.gohtmlBtn);
        gocssbtn = findViewById(R.id.gocssBtn);
        gojavascriptbtn = findViewById(R.id.gojavascriptBtn);

        gohtmlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMainActivity.this,playActivity.class));
                finish();
            }
        });

        gocssbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMainActivity.this,playActivity1.class));
                finish();
            }
        });

        gojavascriptbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMainActivity.this,playActivity2.class));
                finish();
            }
        });
    }
}