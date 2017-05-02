package com.example.android.fitnessapp;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.fitnessapp.database.ExerciseContract;

public class WorkoutExercisePage extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    ExerciseCursorAdapter mExerciseAdapter;
    private static final int EXERCISE_LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_exercise_page);


    ListView mExerciseWorkout = (ListView) findViewById(R.id.WorkoutExercise);
        mExerciseAdapter = new ExerciseCursorAdapter(this,null);
        mExerciseWorkout.setAdapter(mExerciseAdapter);
        getSupportLoaderManager().initLoader(EXERCISE_LOADER, null, this);

        mExerciseWorkout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sets the intent to the editor page
                //gets the uri of the exercise that was selected
                Uri currentExercise = ContentUris.withAppendedId(ExerciseContract.ExerciseTable.EXCONTENT_URI,id);

                //opens the editor activity
                finish(currentExercise);
            }
        });



    }
    //Gets the uri of the Exercise that was clicked on and sends in back to the Workouts Page
    public void finish(Uri currentExercise){
        Intent data = new Intent();
        data.setData(currentExercise);
        setResult(RESULT_OK,data);
        super.finish();

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                ExerciseContract.ExerciseTable._ID,
                ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME,
                ExerciseContract.ExerciseTable.COLUMN_EXERCISE_TYPE
        };
        return new CursorLoader(this,
                ExerciseContract.ExerciseTable.EXCONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mExerciseAdapter.swapCursor(data);


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mExerciseAdapter.swapCursor(null);

    }


}
