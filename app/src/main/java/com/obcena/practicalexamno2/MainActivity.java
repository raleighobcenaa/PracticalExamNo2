package com.obcena.practicalexamno2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText comment1;
    CheckBox subject1,subject2,subject3,subject4,subject5,subject6,
    subject7,subject8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comment1 = findViewById(R.id.comment1);
        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subject2);
        subject3 = findViewById(R.id.subject3);
        subject4 = findViewById(R.id.subject4);
        subject5 = findViewById(R.id.subject5);
        subject6 = findViewById(R.id.subject6);
        subject7 = findViewById(R.id.subject7);
        subject8 = findViewById(R.id.subject8);

    }

    public void writeData (View v) {
        String comment1data = comment1.getText().toString();
        //String subject1Data = subject1.getText().toString();
        //String subject2Data = subject2.getText().toString();
        //String subject3Data = subject3.getText().toString();
        //String subject4Data = subject4.getText().toString();
        //String subject5Data = subject5.getText().toString();
        //String subject6Data = subject6.getText().toString();
        //String subject7Data = subject7.getText().toString();
        //String subject8Data = subject8.getText().toString();

        String subjects = "";
        if (subject1.isChecked()) {
            subjects = " " + subjects + subject1.getText().toString();
        }
        if (subject2.isChecked()) {
            subjects = " " + subjects +  subject2.getText().toString();
        }
        if (subject3.isChecked()) {
            subjects = " " + subjects + " " + subject3.getText().toString();
        }
        if (subject4.isChecked()) {
            subjects = " " + subjects + " " + subject4.getText().toString();
        }
        if (subject5.isChecked()) {
            subjects = " " + subjects + " " + subject5.getText().toString();
        }
        if (subject6.isChecked()) {
            subjects = " " + subjects + " " + subject6.getText().toString();
        }
        if (subject7.isChecked()) {
            subjects = " " + subjects + " " + subject7.getText().toString();
        }
        if (subject8.isChecked()) {
            subjects = " " + subjects + " " + subject8.getText().toString();
        }



        FileOutputStream writer = null;
        FileOutputStream writer1 = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer1 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer1.write(subjects.getBytes());
            writer.write(comment1data.getBytes());
        } catch(FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        } finally {
            try {
                writer.close();
                writer1.close();
            } catch (IOException e) {
                Log.d("Error", "File not found.");
            }
        }
        Toast.makeText(this, "Data is saved.", Toast.LENGTH_LONG).show();
    }


    public void next(View v){
        Intent i = new Intent(this, Service.class);
        startActivity(i);
    }
}
