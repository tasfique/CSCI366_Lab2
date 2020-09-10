package com.csci366.july2020.tasfique_enam.labtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import  java.util.Date;


public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button button;
    private String file = "file"; //check here for the file type.
    private String file2 = "file2";
    private String file3 = "file3";
    private String fileContents = "hello";

    private TextView dateTimeDisplay;
    private Calendar mCalendar;
    private SimpleDateFormat mDateFormat;
    private String date;
    private boolean t = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.editTextUserID);
        password = findViewById(R.id.editTextPassword);
        button =  findViewById(R.id.button_login);
        dateTimeDisplay = findViewById(R.id.textViewDate);

        mCalendar = Calendar.getInstance();
        mDateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
        date = mDateFormat.format(mCalendar.getTime());
        //dateTimeDisplay.setText(date);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, UserInfo.class);

                String textUserName = userName.getText().toString();
                String textPassword = password.getText().toString();
                if (textUserName.matches("") || textPassword.matches("")) {
                    Toast.makeText(MainActivity.this, "User Name or Password is empty.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (textUserName.matches("spiderman") || textPassword.matches("man12spider")) {

                    try {

                        FileOutputStream fOut = openFileOutput(file, MODE_APPEND );
                        fOut.write(date.getBytes()); //filecontents is a string
                        fOut.write(System.getProperty("line.separator").getBytes());
                        fOut.close();
                        File fileDir = new File(getFilesDir(), file);
                        Toast.makeText(getBaseContext(), "File Saved" + fileDir, Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getBaseContext(), "Something went Wrong in writing.", Toast.LENGTH_LONG).show();
                    }

                    i.putExtra("username", textUserName);
                    i.putExtra("filename", file);
                    startActivity(i);

                } else if (textUserName.matches("delta") || textPassword.matches("tadel2")) {

                    try {

                        FileOutputStream fOut = openFileOutput(file2, MODE_APPEND );
                        fOut.write(date.getBytes()); //filecontents is a string
                        fOut.write(System.getProperty("line.separator").getBytes());
                        fOut.close();
                        File fileDir = new File(getFilesDir(), file2);
                        Toast.makeText(getBaseContext(), "File Saved" + fileDir, Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getBaseContext(), "Something went Wrong in writing.", Toast.LENGTH_LONG).show();
                    }

                    i.putExtra("username",textUserName);
                    i.putExtra("filename", file);
                    startActivity(i);

                } else if (textUserName.matches("admin") || textPassword.matches("nimda3")) {

                    try {
                        FileOutputStream fOut = openFileOutput(file3, MODE_PRIVATE);
                        fOut.write(date.getBytes()); //filecontents is a string
                        fOut.write(System.getProperty("line.separator").getBytes());
                        fOut.close();
                        File fileDir = new File(getFilesDir(), file3);
                        Toast.makeText(getBaseContext(), "File Saved" + fileDir, Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getBaseContext(), "Something went Wrong in writing.", Toast.LENGTH_LONG).show();
                    }

                    i.putExtra("username",textUserName);
                    startActivity(i);

                } else {
                    Toast.makeText(MainActivity.this, "Wrong User Name or Password", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}