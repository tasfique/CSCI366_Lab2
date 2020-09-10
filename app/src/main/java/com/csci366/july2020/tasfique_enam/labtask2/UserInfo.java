package com.csci366.july2020.tasfique_enam.labtask2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfo extends AppCompatActivity {
    private TextView userName;
    private TextView email;
    private TextView lastLogin;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userName = findViewById(R.id.textView_userName);
        email = findViewById(R.id.textView_email);
        lastLogin = findViewById(R.id.textView_login);

        i = getIntent();

        String userNaming = i.getStringExtra("username");
        String fileName = i.getStringExtra("filename");

        if (userNaming.matches("spiderman") && fileName.matches("file")) {

            userName.setText("Hi " + userNaming);

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.bg_grey);
            requestOptions.error(R.drawable.bg_grey);

            Glide.with(UserInfo.this)
                    .load("https://avatarfiles.alphacoders.com/149/thumb-149117.jpg")
                    .apply(requestOptions)
                    .into(imageView);

            email.setText("Email: spiderman@web.com");

            List<String> list;

            try{
                FileInputStream fIn = openFileInput(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fIn));
                int c;
                String temp = reader.readLine();
                list = new ArrayList<String>();

//                while ((c = fIn.read()) != -1) {
//                    temp = temp + Character.toString((char)c);
//                    list.add(temp);
//                }

                while (temp != null) {
                    list.add(temp);
                    temp = reader.readLine();
                    lastLogin.setText("Last Login \n" + list.get(3));
                }

//                lastLogin.setText("Last Login \n" + list.get(3));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
