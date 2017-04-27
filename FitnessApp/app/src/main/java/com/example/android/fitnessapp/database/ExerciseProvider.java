package com.example.android.fitnessapp.database;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.android.fitnessapp.database.ExerciseContract.ExerciseTable;

/**
 * Created by Brad Smith on 4/17/2017.
 */

public class ExerciseProvider extends ContentProvider {

    //Sets the standard
    private static final int EXERCISES = 100;

    private static final int EXERCISES_ID = 101;


    //creates a URI matcher object
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {


        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES,EXERCISES);

        sUriMatcher.addURI(ExerciseContract.EXCONTENT_AUTHORITY,ExerciseContract.PATH_EXERCISES + "/#",EXERCISES_ID);





    }

    private ExerciseOpenHelper mDBhelper;


    /** Tag for the log messages */
        public static final String LOG_TAG = ExerciseProvider.class.getSimpleName();

        /**
         * Initialize the provider and the database helper object.
         */
        @Override
        public boolean onCreate() {
            mDBhelper = new ExerciseOpenHelper(getContext());
            // Make sure the variable is a global variable, so it can be referenced from other
            // ContentProvider methods.

            return true;
        }

        /**
         * Perform the query for the given URI..
         */
        @Override
        public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                            String sortOrder) {
            //gets the writeable databse
            SQLiteDatabase database = mDBhelper.getReadableDatabase();

            Cursor cursor;
            // gets the uri code of the Uri and sets that to match
            int match = sUriMatcher.match(uri);

            switch(match) {
                case EXERCISES:

                    cursor = database.query(ExerciseTable.TABLE_NAME, projection,selection, selectionArgs, null ,null ,sortOrder);


                    break;
                case EXERCISES_ID:
                    selection = ExerciseTable._ID + "=?";
                    //gets the number for the "?" for selection
                    selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri)) };
                    cursor = database.query(ExerciseTable.TABLE_NAME, projection,selection, selectionArgs, null ,null ,sortOrder);

                    break;
                default:

                    throw new IllegalArgumentException("can not query uri" + uri);
            }

            cursor.setNotificationUri(getContext().getContentResolver(), uri);

            return cursor;
         }





        /**
         * Insert new data into the provider with the given ContentValues.
         */
        @Override
        public Uri insert(Uri uri, ContentValues contentValues) {
            final int match = sUriMatcher.match(uri);

            switch(match){
                case EXERCISES:
                    return insertExercise(uri, contentValues);
                default:
                    throw new IllegalArgumentException("Insertion is not supported for URI" + uri);

            }
        }
        private Uri insertExercise(Uri uri, ContentValues contentValues){
            String name = contentValues.getAsString(ExerciseTable.COLUMN_EXERCISE_NAME);
            if(name==null){
                throw new IllegalArgumentException("Exercise requires a name");
            }
            //gets writable database
            SQLiteDatabase database = mDBhelper.getWritableDatabase();
            //inserts values into database
            long id = database.insert(ExerciseTable.TABLE_NAME,null,contentValues);

            if(id == -1){
                //if the id is not valid then throw an errror for insertion
                Log.e(LOG_TAG,"Failed to insert Row for" + uri);
                return null;
            }
            //notifys when the uri changes
            getContext().getContentResolver().notifyChange(uri,null);
            //creates the uri for the new row
            return ContentUris.withAppendedId(uri,id);


        }
        /**
         * Updates the data at the given selection and selection arguments, with the new ContentValues.
         */
        @Override
        public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
            final int match = sUriMatcher.match(uri);
            switch(match){
                case EXERCISES:
                    return updateExercise(uri,contentValues,selection,selectionArgs);
                case EXERCISES_ID:
                    selection = ExerciseTable._ID + "=?";
                    selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                    return updateExercise(uri,contentValues,selection,selectionArgs);
                default:
                    throw new IllegalArgumentException("Update does not support this uri" + uri);
            }
        }
        private int updateExercise(Uri uri, ContentValues values, String selection, String[] selectionArgs){
            String name = values.getAsString(ExerciseTable.COLUMN_EXERCISE_NAME);
            if(name==null){
                throw new IllegalArgumentException("Exercise requires a name");
            }
            if (values.size()== 0){
                return 0;
            }
            SQLiteDatabase database = mDBhelper.getWritableDatabase();
            return database.update(ExerciseTable.TABLE_NAME,values,selection,selectionArgs);


        }

        /**
         * Delete the data at the given selection and selection arguments.
         */
        @Override
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            SQLiteDatabase database = mDBhelper.getWritableDatabase();
            final int match = sUriMatcher.match(uri);
            switch (match){
                case EXERCISES:
                    return database.delete(ExerciseTable.TABLE_NAME,selection,selectionArgs);
                case EXERCISES_ID:
                    selection = ExerciseTable._ID + "=?";
                    selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                    return  database.delete(ExerciseTable.TABLE_NAME,selection,selectionArgs);
                default:
                    throw new IllegalArgumentException("Delete not supported for " + uri);
                }


        }

        /**
         * Returns the MIME type of data for the content URI.
         */
        @Override
        public String getType(Uri uri) {
            final int match = sUriMatcher.match(uri);
            switch (match){
                case EXERCISES:
                    return ExerciseTable.CONTENT_LIST_TYPE;

                case EXERCISES_ID:
                    return ExerciseTable.CONTENT_ITEM_TYPE;

                default:
                    throw new IllegalArgumentException("Unknow Uri " + uri + " For match type " + match);

            }
        }
}

