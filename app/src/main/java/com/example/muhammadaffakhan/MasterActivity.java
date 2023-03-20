package com.example.muhammadaffakhan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.muhammadaffakhan.fragments.AchievementsFragment;
import com.example.muhammadaffakhan.fragments.EducationFragment;
import com.example.muhammadaffakhan.fragments.SkillsFragment;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class MasterActivity extends AppCompatActivity {
    AppCompatButton nextBtn, previousBtn, homeBtn;
    String screen;
    String tempScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        nextBtn = findViewById(R.id.next_btn);
        previousBtn = findViewById(R.id.previous_btn);
        homeBtn = findViewById(R.id.home_btn);

        if (getIntent() != null && getIntent().hasExtra("SCREEN")) {
            screen = getIntent().getStringExtra("SCREEN");
            tempScreen = screen;
        }


        if (Objects.equals(screen, "education")) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_caontainer, new EducationFragment(), "education").commit();
            previousBtn.setVisibility(View.INVISIBLE);
            nextBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            tempScreen = "education";
        } else if (Objects.equals(screen, "skills")) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_caontainer, new SkillsFragment(), "skills").commit();
            previousBtn.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            tempScreen = "skills";
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_caontainer, new AchievementsFragment(), "achievements").commit();
            previousBtn.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.INVISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            tempScreen = "achievements";
        }

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.equals(tempScreen, "achievements")){
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_caontainer, new SkillsFragment(), "skills").commit();
                    previousBtn.setVisibility(View.VISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);
                    homeBtn.setVisibility(View.VISIBLE);
                    tempScreen = "skills";
                }
                else if (Objects.equals(tempScreen, "skills")){
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_caontainer, new EducationFragment(), "education").commit();
                    previousBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);
                    homeBtn.setVisibility(View.VISIBLE);
                    tempScreen = "education";
                }
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (Objects.equals(tempScreen, "education")){
                  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_caontainer, new SkillsFragment(), "skills").commit();
                  previousBtn.setVisibility(View.VISIBLE);
                  nextBtn.setVisibility(View.VISIBLE);
                  homeBtn.setVisibility(View.VISIBLE);
                  tempScreen = "skills";
              }
              else if (Objects.equals(tempScreen, "skills")){
                  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_caontainer, new AchievementsFragment(), "achievements").commit();
                  previousBtn.setVisibility(View.VISIBLE);
                  nextBtn.setVisibility(View.INVISIBLE);
                  homeBtn.setVisibility(View.VISIBLE);
                  tempScreen = "achievements";
              }
            }
        });
    }
}