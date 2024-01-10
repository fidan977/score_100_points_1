package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Activity2 extends AppCompatActivity {


    Button button_null;
    public TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    

        //load_score(button_null);


    }



    public void setMainActivity1(View v){


        Intent intent= new Intent(this,MainActivity1.class);
        startActivity(intent);


    }

    public void setActivity3(View v){


        Intent intent= new Intent(this,Activity3.class);
        startActivity(intent);


    }


}