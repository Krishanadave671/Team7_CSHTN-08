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

public class playActivity2 extends AppCompatActivity {
    private TextView questiontv, questionnumbertv;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore=0 , questionAttempted=1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play1);
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
                    Toast.makeText(playActivity2.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;
                    // TRY TO CHANGE COLOR HERE    option1Btn.setBackground(@drawable/correctbun);
                }
                else{
                    Toast.makeText(playActivity2.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(playActivity2.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity2.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(playActivity2.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity2.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(playActivity2.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity2.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }


                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(playActivity2.this);
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
                startActivity(new Intent(playActivity2.this,QuizMainActivity.class));
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
        quizModelArrayList.add(new QuizModel("Inside which HTML element do we put the JavaScript?","<scripting>","<script>","<javascript>","<js>","<script>"));
        quizModelArrayList.add(new QuizModel("What is the correct JavaScript syntax to change the content of the HTML element below?\n" +
                "\n" +
                "<p id=\"demo\">This is a demonstration.</p>","document.getElementById(\"demo\").innerHTML = \"Hello World!\";  ","document.getElementByName(\"p\").innerHTML = \"Hello World!\";","document.getElement(\"p\").innerHTML = \"Hello World!\";","#demo.innerHTML = \"Hello World!\";","document.getElementById(\"demo\").innerHTML = \"Hello World!\";  "));
        quizModelArrayList.add(new QuizModel("Where is the correct place to insert a JavaScript?","The <body> section","The <head> section","Both the <head> section and the <body> section are correct ","None","Both the <head> section and the <body> section are correct  "));
        quizModelArrayList.add(new QuizModel("What is the correct syntax for referring to an external script called \"xxx.js\"?","<script src=\"xxx.js\">  ","<script href=\"xxx.js\">","<script name=\"xxx.js\">","None","<script src=\"xxx.js\">  "));
        quizModelArrayList.add(new QuizModel("How do you write \"Hello World\" in an alert box?","alertBox(\"Hello World\");","msg(\"Hello World\");","alert(\"Hello World\");","msgBox(\"Hello World\");","alert(\"Hello World\");  "));
        quizModelArrayList.add(new QuizModel("How do you create a function in JavaScript?","function myFunction()","function = myFunction()","function:myFunction()","function = myFunction","function myFunction() "));
        quizModelArrayList.add(new QuizModel("How can you add a comment in a JavaScript?","<!--This is a comment-->","'This is a comment","//This is a comment ","/This is a comment ","//This is a comment "));
        quizModelArrayList.add(new QuizModel("Which of the following is true about variable naming conventions in JavaScript?","JavaScript variable names must begin with a letter or the underscore character.","JavaScript variable names are case sensitive."," Both of the above."," None of the above."," Both of the above."));
        quizModelArrayList.add(new QuizModel("Which of the following is correct about callbacks?","A callback is a plain JavaScript function passed to some method as an argument or option.","Some callbacks are just events, called to give the user a chance to react when a certain state is triggered.","Both of the above.","None of the above."," Both of the above."));
        quizModelArrayList.add(new QuizModel("Which built-in method returns the calling string value converted to lower case?","toLowerCase()","toLower()","changeCase(case)","None of the above.","toLowerCase()"));
        quizModelArrayList.add(new QuizModel("Which of the following function of Boolean object returns the primitive value of the Boolean object?","toSource()"," valueOf()","toString()"," None of the above.","valueOf()"));
        quizModelArrayList.add(new QuizModel("Which of the following function of String object returns the characters in a string between two indexes into the string?"," slice()","split()","substr()","substring()","substring()"));
        quizModelArrayList.add(new QuizModel("Which of the following function of String object creates a string to blink as if it were in a <blink> tag?","anchor()"," big()","blink()"," italics()","blink()"));
        quizModelArrayList.add(new QuizModel("Which of the following function of String object causes a string to be displayed in a small font, as if it were in a <small> tag?","link()","small()","sup()","sub()","small()"));
        quizModelArrayList.add(new QuizModel("Which of the following function of Array object joins all elements of an array into a string?","concat()","join()","pop()","map()","map()"));
        quizModelArrayList.add(new QuizModel("Which of the following function of Array object applies a function simultaneously against two values of the array (from right-to-left) as to reduce it to a single value?","pop()","push()","reduce()","reduceRight()","reduceRight()"));
        quizModelArrayList.add(new QuizModel(" What is the correct syntax for referring to an external script called “geek.js”?","<script src=”geek.js”>","<script href=”geek.js”>","<script ref=”geek.js”>","<script name=”geek.js”>","<script ref=”geek.js”>"));
        quizModelArrayList.add(new QuizModel(" Predict the output of the following JavaScript code.\n" +
                 "<script type=\"text/javascript\">\n" +
                "a = 8 + \"8\";\n" +
                "document.write(a);" +
                "</script>","16","Compilation Error","88","Run Time Error","88"));
        quizModelArrayList.add(new QuizModel("Predict the output of the following JavaScript code.\n" +
                "<script type=\"text/javascript\">\n" +
                "var a=\"GeeksforGeeks\";" +
                "var x=a.lastIndexOf(\"G\");\n" +
                "document.write(x);" +
                "</script>","8","0","9","Error","8"));
        quizModelArrayList.add(new QuizModel("Which of the following is not a reserved word in JavaScript?","interface","throws","program","short","program"));
    }
}