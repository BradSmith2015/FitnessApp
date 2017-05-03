package com.example.android.fitnessapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ListView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;

import com.example.android.fitnessapp.database.ExerciseContract.ExerciseTable;
import com.example.android.fitnessapp.database.ExerciseOpenHelper;

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
                Intent intent = new Intent(ExercisePage.this, ExercisePageEditor.class);
                startActivity(intent);

            }
        });
        ListView ExerciseList = (ListView) findViewById(R.id.ExerciseCatalog);

        ExerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sets the intent to the editor page
                Intent intent = new Intent(ExercisePage.this, ExercisePageEditor.class);
                //gets the uri of the exercise that was selected
                Uri currentExercise = ContentUris.withAppendedId(ExerciseTable.EXCONTENT_URI, id);
                //set the Uri on the data field of the intent
                intent.setData(currentExercise);
                //opens the editor activity
                startActivity(intent);
            }
        });

        mExerciseAdapter = new ExerciseCursorAdapter(this, null);
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

