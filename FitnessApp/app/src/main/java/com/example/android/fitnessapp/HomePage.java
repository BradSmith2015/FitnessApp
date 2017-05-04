package com.example.android.fitnessapp;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.fitnessapp.database.ExerciseContract;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Sets the defualt valeues entered into the Exercises page
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
        ContentValues values = new ContentValues();
        values.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME, "Squat");
        values.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_TYPE, ExerciseContract.ExerciseTable.TYPE_BARBELL);
        values.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_BODYPART, ExerciseContract.ExerciseTable.BODYPART_QUADRICEPS);
        Uri uri1=getContentResolver().insert(ExerciseContract.ExerciseTable.EXCONTENT_URI, values);

        ContentValues values2 = new ContentValues();
        values2.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME, "Bench Press");
        values2.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_TYPE, ExerciseContract.ExerciseTable.TYPE_BARBELL);
        values2.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_BODYPART, ExerciseContract.ExerciseTable.BODYPART_CHEST);
        Uri uri2=getContentResolver().insert(ExerciseContract.ExerciseTable.EXCONTENT_URI, values2);

        ContentValues values1 = new ContentValues();
        values1.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME, "Deadlift");
        values1.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_TYPE, ExerciseContract.ExerciseTable.TYPE_BARBELL);
        values1.put(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_BODYPART, ExerciseContract.ExerciseTable.BODYPART_HAMSTRINGS);
        Uri uri3 = getContentResolver().insert(ExerciseContract.ExerciseTable.EXCONTENT_URI, values1);}

            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
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
