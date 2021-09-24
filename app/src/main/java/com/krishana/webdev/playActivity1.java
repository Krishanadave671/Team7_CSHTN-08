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

public class playActivity1 extends AppCompatActivity {

    private TextView questiontv, questionnumbertv,QuitQuiz;
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
        QuitQuiz = findViewById(R.id.textView4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        QuitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(playActivity1.this,QuizMainActivity.class));
            }
        });

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    Toast.makeText(playActivity1.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;
                    // TRY TO CHANGE COLOR HERE    option1Btn.setBackground(@drawable/correctbun);
                }
                else{
                    Toast.makeText(playActivity1.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(playActivity1.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity1.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(playActivity1.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity1.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(playActivity1.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                    currentScore++;

                }
                else{
                    Toast.makeText(playActivity1.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }

                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(playActivity1.this);
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
                startActivity(new Intent(playActivity1.this,QuizMainActivity.class));
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
        quizModelArrayList.add(new QuizModel("Which of the following property specifies the distance between a marker and the text in the list?", "marker-offset", "list-style-position", "list-style-image", "list-style", "marker-offset"));
        quizModelArrayList.add(new QuizModel("Which of the following is correct about CSS?","CSS is used to control the style of a web document in a simple and easy way."," CSS is the acronym for \"Cascading Style Sheet\"."," You can write CSS once and then reuse same sheet in multiple HTML pages."," All of the above."," All of the above."));
        quizModelArrayList.add(new QuizModel("Which of the following defines a relative measurement for the height of a font in em spaces?","%","cm","em","ex","em"));
        quizModelArrayList.add(new QuizModel(" Which of the following defines a measurement in points?","in","mm","pc","pt","pt"));
        quizModelArrayList.add(new QuizModel("Which of the following property is used to create a small-caps effect?","font-family","font-style","font-variant","font-weight","font-variant"));
        quizModelArrayList.add(new QuizModel("Which of the following property is used to add or subtract space between the words of a sentence?","text-indent","text-align","text-decoration","text-transform","text-indent"));
        quizModelArrayList.add(new QuizModel("Which of the following property is used to set the opacity of an image?","border","height","width","-moz-opacity","-moz-opacity"));
        quizModelArrayList.add(new QuizModel("Which of the following property of a anchor element signifies an element on which the user is currently clicking?",":link",":visited",":hover",":active",":active"));
        quizModelArrayList.add(new QuizModel("Which of the following property changes the width of left border?"," :border-bottom-width",": border-top-width"," :border-left-width"," :border-right-width"," :border-left-width"));
        quizModelArrayList.add(new QuizModel("Which of the following property specifies a shorthand property for setting the margin properties in one declaration?",":margin",":margin-bottom",":margin-top","margin-left",":margin"));
        quizModelArrayList.add(new QuizModel("Which of these are valid CSS3 transformation statements.","modify()","simulate()","skip()","matrix()","matrix()"));
        quizModelArrayList.add(new QuizModel("How can you created rounded corners using CSS3?","border[round]: 30px;","corner-effect: round;","border-radius: 30px;","alpha-effect: round-corner;","border-radius: 30px;"));
        quizModelArrayList.add(new QuizModel("How do you add shadow to elements in CSS3?","box-shadow: 10px 10px 5px grey;","shadow-right: 10px shadow-bottom: 10px;","shadow-color: grey;","alpha-effect[shadow]: 10px 10px 5px grey;","box-shadow: 10px 10px 5px grey;"));
        quizModelArrayList.add(new QuizModel(" How to you modify a border image using CSS3?","border: url(image.png);"," border-variable: image url(image.png);","border-image: url(border.png) 30 30 round;","none","border-image: url(border.png) 30 30 round;"));
        quizModelArrayList.add(new QuizModel("Look at the code. What piece of code is missing when make a text shadow? #basicTextShadow p{ text-shadow: 1px 1px 3px; }","the color","the element","the id name","the text shadow height","the id name"));
        quizModelArrayList.add(new QuizModel("What does RGBa mean?"," Review Get assistance Back-up your information acquire proof","Red Green Blue alpha","Red Gray Brown alpha "," Red Gold Black alpha","Red Gray Brown alpha "));
        quizModelArrayList.add(new QuizModel("What are the first three values of text-shadow in order?","vertical, blur, horizontal","blur, vertical, horizontal"," vertical, horizontal, blur","horizontal, vertical, blur ","horizontal, vertical, blur "));
        quizModelArrayList.add(new QuizModel("How to create transition effects using CSS3?","transition: width 2s;","transition-duration: 2s; transition-effect: width;","alpha-effect: transition (width,2s);","none","transition: width 2s;"));
        quizModelArrayList.add(new QuizModel("How to force a word wrap using CSS3?","word-wrap: break-word;","words-wrap: break-word;","text-wrap: break-word;","text-width: word-wrap;","word-wrap: break-word;"));
        quizModelArrayList.add(new QuizModel("How to rotate objects using CSS3?","object-rotation: 30deg;","transform: rotate(30deg);","rotate-object: 30deg;","transform: rotate-30deg-clockwise;","transform: rotate(30deg);"));
    }
}