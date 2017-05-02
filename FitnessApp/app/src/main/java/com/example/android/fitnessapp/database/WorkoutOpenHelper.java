/*package com.example.android.fitnessapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.fitnessapp.database.WorkoutContract.Workoutsday;
import com.example.android.fitnessapp.database.WorkoutContract.WorkoutExercise;
import com.example.android.fitnessapp.database.WorkoutContract.WorkoutGroups;*/
/**
 * Created by Brad Smith on 4/30/2017.
 */

//public class WorkoutOpenHelper extends SQLiteOpenHelper {
   /* private static final int VERSION = 1;
    private static final String DATABASE_NAME = "workoutsDb.db";

    public WorkoutOpenHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    String SQL_CREATE_DAY_TABLE = "CREATE TABLE " + Workoutsday.TABLE_DAY + "( "
            + Workoutsday._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Workoutsday.COLUMN_DAY_DATE +  " TEXT NOT NULL); ";
    String  SQL_CREATE_WORKEXS_TABLE = " CREATE TABLE " + WorkoutExercise.TABLE_WORKEXS + "( "
            + WorkoutExercise._ID + " INTEGER PRIMARY KEY AUTO INCREMENT, "
            + WorkoutExercise.COLUMN_WORKEXS_NAME + " TEXT NOT NULL, "
            + WorkoutExercise.COLUMN_WORKEXS_SETS + " INTEGER NOT NULL, "
            + WorkoutExercise.COLUMN_WORKEXS_WEIGHTS + " TEXT NOT NULL, "
            + WorkoutExercise.COLUMN_WORKEXS_REPS + " TEXT NOT NULL);";
    String SQL_CREATE_GROUPS_TABLE = " CREATE TABLE " + WorkoutGroups.TABLE_GROUPS + "( "
            + WorkoutGroups._ID + "INTEGER PRIMARY KEY AUTO INCREMENT, "
            + WorkoutGroups.COLUMN_GROUPS_DAYID +" INTEGER NOT NULL, "
            + WorkoutGroups.COLUMN_GROUPS_WORKID + " INTEGER NOT NULL, "
            + " FOREIGN KEY (DAY_ID) REFERENCES " + Workoutsday._ID
            + " FOREIGN KEY (WORKEXS_ID) REFERENCES " + WorkoutExercise._ID + ");";

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_DAY_TABLE);
        db.execSQL(SQL_CREATE_WORKEXS_TABLE);
        db.execSQL(SQL_CREATE_GROUPS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}*/
