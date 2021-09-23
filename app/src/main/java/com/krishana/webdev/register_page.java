package com.krishana.webdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register_page extends AppCompatActivity {
    ImageView sign_up_back;
    Button btn_Register;
    TextInputLayout signinPassword,signinEmail,signin_username,githubProfile,fullName;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
    String Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        sign_up_back = findViewById(R.id.sign_up_back);
        btn_Register = findViewById(R.id.btn_Register);
       signinPassword = findViewById(R.id.Password_log);
        signinEmail = findViewById(R.id.Email_log);
        signin_username = findViewById(R.id.signin_username);
        githubProfile = findViewById(R.id.Github);
        fullName = findViewById(R.id.fullname);
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        sign_up_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register_page.this,welcomePage.class));
            }
        });
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fullname = fullName.getEditText().getText().toString().trim();
                String password = signinPassword.getEditText().getText().toString().trim();
                String Username = signin_username.getEditText().getText().toString().trim();
                String Email = signinEmail.getEditText().getText().toString().trim();
                if (!Validatefullname() | !ValidateUsername() | !validateEmail() | !validatePassword()) {
                    return;
                }
//        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register_page.this, "sucessfully authenticated", Toast.LENGTH_SHORT).show();
                            Userid = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("Users").document(Userid);
                            Map<String , Object> user = new HashMap<>();
                            user.put("FullName", Fullname);
                            user.put("Username", Username);
                            user.put("Email" , Email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(register_page.this, "User profile is created", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else{
                            Toast.makeText(register_page.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }
    private boolean validatePassword() {
        String val = signinPassword.getEditText().getText().toString().trim();

        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            signinPassword.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            signinPassword.setError("Password should contain 4 characters!");
            return false;
        } else {
            signinPassword.setError(null);
           signinPassword.setErrorEnabled(false);
            return true;
        }
    }
    private boolean Validatefullname(){
        String  val = fullName.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            fullName.setError("Field cannot be empty");
            return false;
        }
        else{
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean ValidateUsername(){
        String  val = signin_username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";
        if(val.isEmpty()){
            signin_username.setError("Field cannot be empty");
            return false;
        }
        else if (val.length() > 20) {
            signin_username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            signin_username.setError("No White spaces are allowed!");
            return false;
        } else {
            signin_username.setError(null);
            signin_username.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEmail() {
        String val = signinEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            signinEmail.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
           signinEmail.setError("Invalid Email!");
            return false;
        } else {
            signinEmail.setError(null);
            signinEmail.setErrorEnabled(false);
            return true;
        }
    }

}
