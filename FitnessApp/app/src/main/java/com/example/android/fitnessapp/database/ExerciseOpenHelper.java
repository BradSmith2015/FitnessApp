package com.example.android.fitnessapp.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.fitnessapp.database.ExerciseContract.ExerciseTable;

/**
 * Created by Brad Smith on 4/9/2017.
 */

public class ExerciseOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "exerciseDb.db";



    public ExerciseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_EXERCISES_TABLE="CREATE TABLE " + ExerciseTable.TABLE_NAME + "( "
                + ExerciseTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ExerciseTable.COLUMN_EXERCISE_NAME + " TEXT NOT NULL, "
                + ExerciseTable.COLUMN_EXERCISE_TYPE + " INTEGER NOT NULL DEFAULT 0, "
                + ExerciseTable.COLUMN_EXERCISE_BODYPART + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_EXERCISES_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
