package com.krishana.webdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class QuizMainActivity extends AppCompatActivity {
    Button gohtmlbtn,gocssbtn,gojavascriptbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);
        gohtmlbtn = findViewById(R.id.gohtmlBtn);
        gocssbtn = findViewById(R.id.gocssBtn);
        gojavascriptbtn = findViewById(R.id.gojavascriptBtn);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.quiz_nav);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.homeDrawer:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                    case R.id.assignmentDrawer:
                        startActivity(new Intent(getApplicationContext(),AssignmentSection.class));
                        return true;

                }
                return false;
            }
        });

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