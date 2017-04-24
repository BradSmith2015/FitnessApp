package com.example.android.fitnessapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.android.fitnessapp.database.ExerciseContract.ExerciseTable;
import com.example.android.fitnessapp.database.ExerciseOpenHelper;
import com.example.android.fitnessapp.database.ExerciseProvider;

public class ExercisePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisePage.this,ExercisePageEditor.class);
                startActivity(intent);

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        DisplayExercise();
    }

    private void DisplayExercise(){
        //opens the database to be read

        String[] projection = {
                ExerciseTable._ID,
                ExerciseTable.COLUMN_EXERCISE_NAME,
                ExerciseTable.COLUMN_EXERCISE_BODYPART,
                ExerciseTable.COLUMN_EXERCISE_TYPE,
                };


        Cursor cursor = getContentResolver().query(ExerciseTable.EXCONTENT_URI,projection,null,null,null);
        TextView displayView = (TextView) findViewById(R.id.ExerciseCatalog);

        try{

            displayView.setText("Exercise Table Contains.\n\n");
            displayView.append(ExerciseTable._ID + " - " +
            ExerciseTable.COLUMN_EXERCISE_NAME + " - " +
            ExerciseTable.COLUMN_EXERCISE_BODYPART + " - " +
            ExerciseTable.COLUMN_EXERCISE_TYPE + "\n");

            int idColumnIndex = cursor.getColumnIndex(ExerciseTable._ID);
            int nameColumnIndex = cursor.getColumnIndex(ExerciseTable.COLUMN_EXERCISE_NAME);
            int bodypartColumnIndex = cursor.getColumnIndex(ExerciseTable.COLUMN_EXERCISE_BODYPART);
            int typeColumnIndex = cursor.getColumnIndex(ExerciseTable.COLUMN_EXERCISE_TYPE);

            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentBodypart = cursor.getString(bodypartColumnIndex);
                int currentType = cursor.getInt(typeColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentBodypart + " - " +
                        currentType));
            }

        }finally {
            cursor.close();

        }


    }

}
