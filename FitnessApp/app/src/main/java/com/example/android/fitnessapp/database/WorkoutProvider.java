package com.example.android.fitnessapp.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.fitnessapp.database.ExerciseProvider;

/**
 * Created by Brad Smith on 4/30/2017.
 */

public class WorkoutProvider extends ContentProvider {

    private static final int Workouts = 200;
    private static final int Workouts_ID = 201;
    private static final int Groups = 300;
    private static final int Groups_ID = 301;
    private static final int WorkoutEx = 400;
    private static final int WorkoutEx_ID = 401;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{


        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,Workouts);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",Workouts_ID);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,Groups);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",Groups_ID);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,WorkoutEx);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",WorkoutEx_ID);



    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
