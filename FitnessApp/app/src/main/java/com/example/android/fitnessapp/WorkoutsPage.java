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

public class WorkoutsPage extends AppCompatActivity {


    Uri currentUriEx;
    Cursor currentcursor;
    int currentposition;
    String currentName;
;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XmlPullParser parser = getResources().getLayout(R.layout.workout_box_layout);
        AttributeSet attributes = Xml.asAttributeSet(parser);
        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        Intent intent = getIntent();
        if(intent != null){
            currentUriEx = intent.getData();
            if(currentUriEx !=  null) {
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View child =inflater.inflate(R.layout.workout_box_layout, (ViewGroup) findViewById(R.id.workoutbox));

                currentcursor = getContentResolver().query(currentUriEx, null, null, null, null);
                currentposition = currentcursor.getColumnIndex(ExerciseContract.ExerciseTable.COLUMN_EXERCISE_NAME);
                currentName = currentcursor.getString(currentposition);
                TextView name = (TextView) child.findViewById(R.id.workoutname);
                name.setText(currentName);
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


}
