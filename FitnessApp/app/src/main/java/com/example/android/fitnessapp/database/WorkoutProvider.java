package com.example.android.fitnessapp.database;

/*(import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.fitnessapp.database.WorkoutContract.WorkoutGroups;
import com.example.android.fitnessapp.database.WorkoutContract.WorkoutExercise;
import com.example.android.fitnessapp.database.WorkoutContract.Workoutsday;*/
/**
 * Created by Brad Smith on 4/30/2017.
 */

/*public class WorkoutProvider extends ContentProvider {

    private static final int Workoutsday = 200;
    private static final int Workoutsday_ID = 201;
    private static final int Groups = 300;
    private static final int Groups_ID = 301;
    private static final int WorkoutEx = 400;
    private static final int WorkoutEx_ID = 401;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{


        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,Workoutsday);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",Workoutsday_ID);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,Groups);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",Groups_ID);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,WorkoutEx);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",WorkoutEx_ID);



    }

    private WorkoutOpenHelper mWDbhelper;

    public static final String LOG_TAGwk = WorkoutProvider.class.getSimpleName();

    @Override
    public boolean onCreate() {
        // intizlatizing the workoutopenhelper variable
        mWDbhelper = new WorkoutOpenHelper(getContext());


        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = mWDbhelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);

        switch(match) {

            case Workoutsday:

                cursor = database.query(WorkoutContract.Workoutsday.TABLE_DAY, projection, selection, selectionArgs, null, null, sortOrder);
                break;


            case Workoutsday_ID:
                selection = WorkoutContract.Workoutsday._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(WorkoutContract.Workoutsday.TABLE_DAY, projection, selection, selectionArgs, null, null, sortOrder);
                break;


            case WorkoutEx:

                cursor = database.query(WorkoutExercise.TABLE_WORKEXS, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case WorkoutEx_ID:
                selection = WorkoutContract.Workoutsday._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(WorkoutExercise.TABLE_WORKEXS, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case Groups:

                cursor = database.query(WorkoutGroups.TABLE_GROUPS, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case Groups_ID:
                selection = WorkoutContract.Workoutsday._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(WorkoutContract.Workoutsday.TABLE_DAY, projection, selection, selectionArgs, null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException("can not query uri" + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;

    }


    @Override
    public String getType( Uri uri) {
        return null;
    }

    @Override
    public Uri insert( Uri uri, ContentValues values) {
    return null;
    }

    private Uri insertWorkouttoDay(Uri uri,ContentValues contentValues){

        SQLiteDatabase database = mWDbhelper.getWritableDatabase();

        long id = database.insert(WorkoutExercise.TABLE_WORKEXS,null,contentValues);
        if(id == -1){

            Log.e(LOG_TAGwk,"Failed to insert Row for " + uri);
            return null;
        }

        getContext().getContentResolver().notifyChange(uri,null);




        return null;



    }

    @Override
    public int delete( Uri uri,String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}*/
