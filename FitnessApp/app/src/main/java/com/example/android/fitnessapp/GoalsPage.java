package com.example.android.fitnessapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GoalsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        //Use the shared prefences to store the data for the goals
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_page);
        EditText Dliftgoal = (EditText) findViewById(R.id.deadliftgoal);
        EditText Benchgoal = (EditText) findViewById(R.id.benchgoal);
        EditText Squatgoal = (EditText) findViewById(R.id.squatgoal);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int DeadGoal = sharedPref.getInt("DeadLift",0);
        int BenGoal = sharedPref.getInt("BenchPress",0);
        int SqGoal = sharedPref.getInt("Squat",0);
        if(DeadGoal != 0) {
            Squatgoal.setText(Integer.toString(SqGoal));
            Benchgoal.setText(Integer.toString(BenGoal));
            Dliftgoal.setText(Integer.toString(DeadGoal));
        }





    }


    public void getGoals(){
        //Gets the data form edit text views in the goals page to be stored in the shared prefrences page

        EditText Dliftgoal = (EditText) findViewById(R.id.deadliftgoal);
        EditText Benchgoal = (EditText) findViewById(R.id.benchgoal);
        EditText Squatgoal = (EditText) findViewById(R.id.squatgoal);

        int deadgoal = Integer.parseInt(String.valueOf(Dliftgoal.getText()));
        int Bengoal = Integer.parseInt(String.valueOf(Benchgoal.getText()));
        int Sqgoal = Integer.parseInt(String.valueOf(Squatgoal.getText()));

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("BenchPress", Bengoal);
        editor.putInt("Squat", Sqgoal);
        editor.putInt("DeadLift", deadgoal);
        editor.commit();










    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //creates the menu
        getMenuInflater().inflate(R.menu.exercisemenu,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.SaveGoals:
                getGoals();
                finish();

                return true;

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}