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


    private void insertdefualt() {

        ContentValues values = new ContentValues();
        values.put(ExerciseTable.COLUMN_EXERCISE_NAME, "Squat");
        values.put(ExerciseTable.COLUMN_EXERCISE_TYPE, ExerciseTable.TYPE_BARBELL);
        values.put(ExerciseTable.COLUMN_EXERCISE_BODYPART, ExerciseTable.BODYPART_QUADRICEPS);
        Uri uri1=getContentResolver().insert(ExerciseTable.EXCONTENT_URI, values);

        ContentValues values2 = new ContentValues();
        values2.put(ExerciseTable.COLUMN_EXERCISE_NAME, "Bench Press");
        values2.put(ExerciseTable.COLUMN_EXERCISE_TYPE, ExerciseTable.TYPE_BARBELL);
        values2.put(ExerciseTable.COLUMN_EXERCISE_BODYPART, ExerciseTable.BODYPART_CHEST);
        Uri uri2=getContentResolver().insert(ExerciseTable.EXCONTENT_URI, values2);

        ContentValues values1 = new ContentValues();
        values1.put(ExerciseTable.COLUMN_EXERCISE_NAME, "Deadlift");
        values1.put(ExerciseTable.COLUMN_EXERCISE_TYPE, ExerciseTable.TYPE_BARBELL);
        values1.put(ExerciseTable.COLUMN_EXERCISE_BODYPART, ExerciseTable.BODYPART_HAMSTRINGS);
        Uri uri3 = getContentResolver().insert(ExerciseTable.EXCONTENT_URI, values1);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //creates the menu
        getMenuInflater().inflate(R.menu.exercisemenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Default:

                return true;

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

