package com.example.android.fitnessapp;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.fitnessapp.database.ExerciseContract;


public class WorkoutsPage extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    String name;
    Intent WorkoutData;
    String[] projection = {
            ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME
    };

    @Override
    public void onCreate(Bundle SaveInstanceState) {
    super.onCreate(SaveInstanceState);
    setContentView(R.layout.activity_workouts_page);
        WorkoutLayoutOperation.dispaly(this);



    }



    //this is the request for the intent to return the data for the exercise
    public void onClick(View view){
        //gets intent at the Workout Exercise Page and then starts activity
        Intent i = new Intent(this,WorkoutExercisePage.class);
        startActivityForResult(i,REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if(resultcode == RESULT_OK && requestCode == REQUEST_CODE){
            WorkoutData = data;
            Uri currentExercise = WorkoutData.getData();

            Cursor cursor=getContentResolver().query(currentExercise,null,null,null,null);
            if(cursor.moveToFirst()) {
                name = cursor.getString(cursor.getColumnIndex(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME));
            }
            cursor.close();
            WorkoutLayoutOperation.add(this,name);


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //creates the menu
        getMenuInflater().inflate(R.menu.workoutmenu, menu);
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                onClick(findViewById(R.id.add));

                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }









}

