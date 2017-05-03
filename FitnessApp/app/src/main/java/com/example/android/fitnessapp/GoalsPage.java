package com.example.android.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GoalsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_page);
        TextView textView = (TextView) findViewById(R.id.practice_edit);
        String data = null;
        try {
            FileInputStream fis = openFileInput("dates");
            byte dataArray[] =  new byte[fis.available()];
            while (fis.read(dataArray) != -1){
                data = new String(dataArray);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }finally {
            try {
                FileInputStream fii = openFileInput(data);
                byte workoutarray[] = new byte[fii.available()];
                String workouts = null;
                while(fii.read(workoutarray) != -1){
                    workouts = new String( workoutarray);
                }
                textView.setText(workouts);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
