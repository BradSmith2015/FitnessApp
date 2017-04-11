package com.example.android.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void sendtoExercise(View view) {//use Exercise Button to move to exercise page
        Intent intent = new Intent(this, ExercisePage.class);
        startActivity(intent);
    }

    public void sendtoWorkouts(View view) {//use the workouts button to move to workouts page

        Intent intent = new Intent(this, WorkoutsPage.class);
        startActivity(intent);
    }
    public void sendtoGoals(View view){//use the goals button to move to goals page
        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }
    public void sendtoProgress(View view){//use the Progress button to move to the Progress
        Intent intent = new Intent(this, ProgressPage.class);
        startActivity(intent);
    }

}
