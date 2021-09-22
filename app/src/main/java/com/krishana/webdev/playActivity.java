package com.krishana.webdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class playActivity extends AppCompatActivity {
    private TextView questiontv, questionnumbertv;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore=0 , questionAttempted=1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        questiontv = findViewById(R.id.questionTV);
        questionnumbertv = findViewById(R.id.questionnumberTV);
        option1Btn = findViewById(R.id.btnoption1);
        option2Btn = findViewById(R.id.btnoption2);
        option3Btn = findViewById(R.id.btnoption3);
        option4Btn = findViewById(R.id.btnoption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    Toast.makeText(playActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;
                    // TRY TO CHANGE COLOR HERE    option1Btn.setBackground(@drawable/correctbun);
                }
                else{
                    Toast.makeText(playActivity.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }

                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }

        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    Toast.makeText(playActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }

                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);

            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    Toast.makeText(playActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }

                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    Toast.makeText(playActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }

                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(playActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.scaore_bottom_sheet,(LinearLayout)findViewById(R.id.LLscore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.TVscore);
        Button restartbtn = bottomSheetView.findViewById(R.id.restartbtn);
        Button exitbtn = bottomSheetView.findViewById(R.id.exitBtn);
        scoreTV.setText(currentScore+"/20");
        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(playActivity.this,QuizMainActivity.class));
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos){
        questionnumbertv.setText("Que: "+ questionAttempted + "/20");
        if(questionAttempted==20)
            showBottomSheet();
        else{
            questiontv.setText(quizModelArrayList.get(currentPos).getQuestion());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }



    }

    private void getQuizQuestion(ArrayList<QuizModel>quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("What does HTML stands for?", "Hypertext Machine language", "Hypertext and links markup language", "Hypertext Markup Language", "Hightext machine language", "Hypertext Markup Language"));
        quizModelArrayList.add(new QuizModel("How is document type initialized in HTML5.?", "</DOCTYPE HTML>", "</DOCTYPE>" ,"<!DOCTYPE HTML>", "</DOCTYPE html>", "<!DOCTYPE HTML>"));
        quizModelArrayList.add(new QuizModel("Which of the following HTML Elements is used for making any text bold ?", "<p>", "<i>", "<li>", "<b>", "<b>"));
        quizModelArrayList.add(new QuizModel("Which of the following HTML element is used for creating an unordered list?", "<ui>", "<i>", "<em>", "<ul>", "<ul>"));
        quizModelArrayList.add(new QuizModel("Which of the following characters indicate closing of a tag?",".","/","\\","!","/"));
        quizModelArrayList.add(new QuizModel("What is the font-size of the h1 heading tag?","3.5 em","2.17 em","2 em","1.5 em","2 em"));
        quizModelArrayList.add(new QuizModel("How many heading tags are there in HTML5?","2","3","5","6","6"));
        quizModelArrayList.add(new QuizModel("How many attributes are there in HTML5?","2","4","1","5","2"));
        quizModelArrayList.add(new QuizModel("Which of the following attributes is used to add link to any element?","link","ref","href","newref","href"));
        quizModelArrayList.add(new QuizModel("Which of the following is the correct way of creating an hyperlink in HTML?","<a>www.geeksforgeeks.org <Geeksforgeeks /a>","<a href=“www.geeksforgeeks.org” Geeksforgeeks /a>","<a href= “www.geeksforgeeks.org”>Geeksforgeeks</a>","<a link=“www.geeksforgeeks.org” Geeksforgeeks> </a>","<a href= “www.geeksforgeeks.org”>Geeksforgeeks</a>"));
        quizModelArrayList.add(new QuizModel("What is the purpose of using div tags in HTML?","For creating Different styles","For creating different sections","For adding headings","For adding titles","For creating different sections"));
        quizModelArrayList.add(new QuizModel("Which of the following tags is used to make a portion of text italic in HTML?","<italic>","<style= “i”>","<i>","<style=“italic”>","<i>"));
        quizModelArrayList.add(new QuizModel("Which of the following tags is used to add a line-break in HTML?","<br>","<break>","</break>","</br>","<br>"));
        quizModelArrayList.add(new QuizModel("Which of the following attributes is used to open an hyperlink in new tab?","tab","href","target","ref","target"));
        quizModelArrayList.add(new QuizModel("Which of the following is the correct way to add background color in HTML?","<body color = “green”>","<body bg-color = “green”>","<body style = “background-color=green”>","<body style = “background-color: green;”>","<body style = “background-color: green;”>"));
        quizModelArrayList.add(new QuizModel("Which among the following is correct HTML code for making a checkbox?","<checkbox>","<input type=\"checkbox\">","<check>","<input type=\"check\">","<input type=\"checkbox\">"));
        quizModelArrayList.add(new QuizModel("Which tag is used for creating a drop-down selection list?","<select>","<option>","<dropdown>","<list>","<option>"));
        quizModelArrayList.add(new QuizModel("Which tag is used to add an header in HTML5 table?","<theader>","<h1>","<th>","<header>","<th>"));
        quizModelArrayList.add(new QuizModel("Which of the following elements can be used in HTML to create a table?","<table> , <tbody> , <trow>","<table> , <tb> , <trow>","<table> , <tbody> , <tr>","All of the above","<table> , <tbody> , <tr>"));
        quizModelArrayList.add(new QuizModel("Which among the following is the correct way in HTML to insert an image?","<img url=“https://bit.ly/2FicgIx”>Geeksforgeeks</img>","<img href=“https://bit.ly/2FicgIx” alt= “Geeksforgeeks”></img>","<img src=“https://bit.ly/2FicgIx” alt=“Geeksforgeeks”>","<image src=“https://bit.ly/2FicgIx” alt=“Geeksforgeeks”></image>","<img src=“https://bit.ly/2FicgIx” alt=“Geeksforgeeks”>"));
    }
}