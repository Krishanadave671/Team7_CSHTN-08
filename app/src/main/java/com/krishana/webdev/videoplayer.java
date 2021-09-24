package com.krishana.webdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.ArrayList;
import java.util.List;

public class videoplayer extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Uri videoUri;
    TextView text_video_selected;
    String Videocategory;
    String Videotitle;
    String CurrentUid;
    StorageReference mStorageRef;
    StorageTask muploadsTask;
    DatabaseReference referencevideos;
    EditText videoDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        text_video_selected = findViewById(R.id.textvideoselect);
        videoDescription = findViewById(R.id.moviedescription);
        referencevideos = FirebaseDatabase.getInstance().getReference().child("videos");
        mStorageRef = FirebaseStorage.getInstance().getReference().child("videos");
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        List<String> categories = new ArrayList<>();
        categories.add("Action");
        categories.add("Adventure");
        categories.add("Sports");
        categories.add("Romantic");
        categories.add("Comedy");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Videocategory = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(videoplayer.this, "selected: " + Videocategory, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void openvideofiles(){
        Intent in = new Intent(Intent.ACTION_GET_CONTENT);
        in.setType("video/*");
        startActivityForResult(in,101);
        
    }
}