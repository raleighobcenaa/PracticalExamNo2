package com.obcena.practicalexamno2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        FileInputStream reader = null;
        FileInputStream reader1 = null;
        String msg = "";
        String msg1 = "";
        try {
            int token;
            //StringBuffer buffer = new StringBuffer();
            reader = openFileInput("data1.txt");
            reader1 = openFileInput("data2.txt");
            while ((token = reader.read()) != -1){
                msg = msg +(char)token;
            }
            while((token = reader1.read()) != -1){
                msg1 = msg1 + (char)token;
            }
            reader.close();
            reader1.close();
            try {
                ((TextView) (findViewById(R.id.textViewSubjects))).setText(msg1);
                ((TextView) (findViewById(R.id.textViewComment))).setText(msg);
            } catch(Exception e){

            }

        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        }
        Toast.makeText(this, msg1.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();

    }

    public void send(View v){
        Toast.makeText(this, "Request Sent.", Toast.LENGTH_SHORT).show();
    }

    public void previous(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
