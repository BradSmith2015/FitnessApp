package com.example.android.fitnessapp;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.android.fitnessapp.database.ExerciseContract;

import org.xmlpull.v1.XmlPullParser;

import static com.example.android.fitnessapp.R.layout.workout_box_layout;

public class WorkoutsPage extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    Uri currentUriEx;
    Cursor currentcursor;
    int currentposition;
    String currentName;
;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        Intent intent = getIntent();
        if(intent != null){
            currentUriEx = intent.getData();
            if(currentUriEx !=  null) {
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
                String[] projection={
                        ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME
                };

                getSupportLoaderManager().initLoader(0,null,this);
                View child =inflater.inflate(R.layout.workout_box_layout, (ViewGroup) findViewById(R.id.workoutbox));
                ll.addView(child);
            }

        }

        this.setContentView(sv);


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
                Intent intent = new Intent(WorkoutsPage.this, WorkoutExercisePage.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                ExerciseContract.ExerciseTable._ID,
                ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME
        };
        return new CursorLoader(this,currentUriEx,projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
       if( data.moveToFirst()) {
           currentposition = data.getColumnIndex(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME);
           currentName = data.getString(currentposition);
           TextView name = (TextView) findViewById(R.id.workoutname);
           name.setText(currentName);
       }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {



    }
}
