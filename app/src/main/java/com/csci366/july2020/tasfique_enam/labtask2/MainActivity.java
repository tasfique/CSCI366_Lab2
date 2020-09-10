package com.csci366.july2020.tasfique_enam.labtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.editTextUserID);
        password = findViewById(R.id.editTextPassword);
        button =  findViewById(R.id.button_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file = new File("test.txt");

                Intent i = new Intent(MainActivity.this, UserInfo.class);

                String textUserName = userName.getText().toString();
                String textPassword = password.getText().toString();
                if (textUserName.matches("") || textPassword.matches("")) {
                    Toast.makeText(MainActivity.this, "User Name or Password is empty.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (textUserName.matches("spiderman") || textPassword.matches("man12spider")) {
                    try {
                        PrintWriter output = new PrintWriter(file);
                        output.println("Taz");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    i.putExtra("username",textUserName);
                    startActivity(i);
                } else if (textUserName.matches("delta") || textPassword.matches("tadel2")) {
                    i.putExtra("username",textUserName);
                    startActivity(i);
                } else if (textUserName.matches("admin") || textPassword.matches("nimda3")) {
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