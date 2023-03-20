package com.example.muhammadaffakhan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    AppCompatButton exitBtn,educationBtn,skillsBtn,achievementsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitBtn = findViewById(R.id.exit_btn);
        educationBtn = findViewById(R.id.education_btn);
        skillsBtn = findViewById(R.id.skills_btn);
        achievementsBtn = findViewById(R.id.achievements_btn);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        educationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MasterActivity.class);
                intent.putExtra("SCREEN","education");
                startActivity(intent);
            }
        });
        skillsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MasterActivity.class);
                intent.putExtra("SCREEN","skills");
                startActivity(intent);
            }
        });

        achievementsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MasterActivity.class);
                intent.putExtra("SCREEN","achievements");
                startActivity(intent);
            }
        });

    }
}