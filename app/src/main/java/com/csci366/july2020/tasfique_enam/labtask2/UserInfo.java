package com.csci366.july2020.tasfique_enam.labtask2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            //List<String> list;

            try {
//
                System.out.println("Testing start");

                BufferedReader bufReader = new BufferedReader(new FileReader("/data/user/0/com.csci366.july2020.tasfique_enam.labtask2/files/file"));
                ArrayList<String> listOfLines = new ArrayList<>();
                String line = bufReader.readLine();
                while (line != null) {
                    listOfLines.add(line);
                    line = bufReader.readLine();
                }
                bufReader.close();

                if (listOfLines.size() < 1) {
                    lastLogin.setText("Last Login ----\n");
                } else {
                    int size = listOfLines.size() - 2 ;
                    lastLogin.setText("Last Login \n" + listOfLines.get(size));
                }

            } catch (Exception e) {
                System.out.println("Failed");
                e.printStackTrace();
            }
        }

        if (userNaming.matches("delta") && fileName.matches("file2")) {

            userName.setText("Hi " + userNaming);

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.bg_grey);
            requestOptions.error(R.drawable.bg_grey);

            Glide.with(UserInfo.this)
                    .load("https://i.pinimg.com/originals/39/0a/62/390a62d1aafd2f068b9ffde5d933da35.jpg")
                    .apply(requestOptions)
                    .into(imageView);

            email.setText("Email: delta@web.com");

            //List<String> list;

            try {
//
                System.out.println("Testing start");

                BufferedReader bufReader = new BufferedReader(new FileReader("/data/user/0/com.csci366.july2020.tasfique_enam.labtask2/files/file2"));
                ArrayList<String> listOfLines2 = new ArrayList<>();
                String line = bufReader.readLine();
                while (line != null) {
                    listOfLines2.add(line);
                    line = bufReader.readLine();
                }
                bufReader.close();

                if (listOfLines2.isEmpty()) {
                    lastLogin.setText("Last Login ----\n");
                } else {
                    int size = listOfLines2.size() - 2 ;
                    lastLogin.setText("Last Login \n" + listOfLines2.get(size));
                }

            } catch (Exception e) {
                System.out.println("Failed");
                e.printStackTrace();
            }
        }

        if (userNaming.matches("admin") && fileName.matches("file3")) {

            userName.setText("Hi " + userNaming);

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.bg_grey);
            requestOptions.error(R.drawable.bg_grey);

            Glide.with(UserInfo.this)
                    .load("https://png.pngtree.com/png-vector/20190223/ourlarge/pngtree-admin-rolls-glyph-black-icon-png-image_691507.jpg")
                    .apply(requestOptions)
                    .into(imageView);

            email.setText("Email: admin@web.com");

            //List<String> list;

            try {
//
                System.out.println("Testing start");

                BufferedReader bufReader = new BufferedReader(new FileReader("/data/user/0/com.csci366.july2020.tasfique_enam.labtask2/files/file3"));
                ArrayList<String> listOfLines3 = new ArrayList<>();
                String line = bufReader.readLine();
                while (line != null) {
                    listOfLines3.add(line);
                    line = bufReader.readLine();
                }
                bufReader.close();

                if (listOfLines3.isEmpty()) {
                    lastLogin.setText("Last Login ----\n");
                } else {
                    int size = listOfLines3.size() - 2 ;
                    lastLogin.setText("Last Login \n" + listOfLines3.get(size));
                }

            } catch (Exception e) {
                System.out.println("Failed");
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UserInfo.this, MainActivity.class));
    }
}
