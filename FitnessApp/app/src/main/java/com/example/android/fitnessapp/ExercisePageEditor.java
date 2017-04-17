package com.example.android.fitnessapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.fitnessapp.database.ExerciseContract.ExerciseTable;
import com.example.android.fitnessapp.database.ExerciseOpenHelper;

public class ExercisePageEditor extends AppCompatActivity {
    private Spinner mTypeSpinner;
    private Spinner mBodyPartSpinner;
    private EditText mEditTextView;
    private int mtype = ExerciseTable.TYPE_BARBELL;
    private int mbodypart = ExerciseTable.BODYPART_CHEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_page_editor);
        mTypeSpinner = (Spinner) findViewById(R.id.spinner_type);
        mBodyPartSpinner = (Spinner) findViewById(R.id.spinner_bodypart);
        mEditTextView = (EditText) findViewById(R.id.edit_name);
        setupTypeSpinner();
        setupBodyPartSpinner();

    }


public void setupTypeSpinner(){
    ArrayAdapter typeSpinnerAdapter = ArrayAdapter.createFromResource(this,
            R.array.array_type_options, android.R.layout.simple_spinner_item);
    typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

    mTypeSpinner.setAdapter(typeSpinnerAdapter);

    mTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
            String selection = ((String) parent.getItemAtPosition(position));
            if(!TextUtils.isEmpty(selection)){
                if (selection.equals(getString(R.string.type_barbell))){
                    mtype = ExerciseTable.TYPE_BARBELL;

                }else if(selection.equals(getString(R.string.type_dumbbell))){
                    mtype = ExerciseTable.TYPE_DUMBBELL;
                }else if(selection.equals(getString(R.string.type_bodyweight))){
                    mtype = ExerciseTable.TYPE_BODYWEIGHT;
                }else{
                    mtype = ExerciseTable.TYPE_MACHINCE;
                }
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent){
            mtype = ExerciseTable.TYPE_BARBELL;
        }
    });


}
    public void setupBodyPartSpinner(){
        ArrayAdapter typeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_bodypart_options, android.R.layout.simple_spinner_item);
        typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mBodyPartSpinner.setAdapter(typeSpinnerAdapter);

        mBodyPartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String selection = ((String) parent.getItemAtPosition(position));
                if(!TextUtils.isEmpty(selection)){
                    if (selection.equals(getString(R.string.bodypart_chest))){
                        mbodypart = ExerciseTable.BODYPART_CHEST;

                    }else if(selection.equals(getString(R.string.bodypart_quadriceps))){
                        mbodypart = ExerciseTable.BODYPART_QUADRICEPS;
                    }else if(selection.equals(getString(R.string.bodypart_hamstrings))){
                        mbodypart = ExerciseTable.BODYPART_HAMSTRINGS;
                    }else if(selection.equals(getString(R.string.bodypart_calves))){
                        mbodypart = ExerciseTable.BODYPART_CALVES;
                    }else if(selection.equals(getString(R.string.bodypart_biceps))){
                        mbodypart = ExerciseTable.BODYPART_BICEPS;
                    }else if(selection.equals(getString(R.string.bodypart_triceps))){
                        mbodypart = ExerciseTable.BODYPART_TRICEPS;
                    }else if(selection.equals(getString(R.string.bodypart_shoulders))){
                        mbodypart = ExerciseTable.BODYPART_SHOULDERS;
                    }else if(selection.equals(getString(R.string.bodypart_back))){
                        mbodypart = ExerciseTable.BODYPART_BACK;
                    }else if(selection.equals(getString(R.string.bodypart_abs))) {
                        mbodypart = ExerciseTable.BODYPART_ABS;
                    }
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
                mbodypart = ExerciseTable.BODYPART_CHEST;
            }
        });


    }


    private void InsertExercise(){
        //gets the text of the edittext view and trim removes the white space
        String name = mEditTextView.getText().toString().trim();

        ExerciseOpenHelper mDbhelper = new ExerciseOpenHelper(this);

        SQLiteDatabase db = mDbhelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ExerciseTable.COLUMN_EXERCISE_NAME,name);
        values.put(ExerciseTable.COLUMN_EXERCISE_TYPE,mtype);
        values.put(ExerciseTable.COLUMN_EXERCISE_BODYPART,mbodypart);

        long newRowId = db.insert(ExerciseTable.TABLE_NAME,null,values);

        if(newRowId == -1 ){
            Toast.makeText(this, "Error with saving Exercise", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Exercise saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //creates the menu
        getMenuInflater().inflate(R.menu.editormeni,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                InsertExercise();
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}




