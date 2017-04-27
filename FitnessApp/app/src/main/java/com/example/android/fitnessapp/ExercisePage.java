package com.example.android.fitnessapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;

import com.example.android.fitnessapp.database.ExerciseContract.ExerciseTable;

public class ExercisePage extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXERCISE_LOADER = 0;

    ExerciseCursorAdapter mExerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_page);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisePage.this,ExercisePageEditor.class);
                startActivity(intent);

            }
        });
        ListView ExerciseList = (ListView) findViewById(R.id.ExerciseCatalog);


        mExerciseAdapter = new ExerciseCursorAdapter(this,null);
        ExerciseList.setAdapter(mExerciseAdapter);
        getSupportLoaderManager().initLoader(EXERCISE_LOADER, null, this);

    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                ExerciseTable._ID,
                ExerciseTable.COLUMN_EXERCISE_NAME,
                ExerciseTable.COLUMN_EXERCISE_TYPE
        };
        return new CursorLoader(this,
                ExerciseTable.EXCONTENT_URI,
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
