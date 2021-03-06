package com.example.android.fitnessapp.database;


import android.content.ContentResolver;
import android.graphics.Path;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Brad Smith on 4/9/2017.
 */

public final class ExerciseContract {

    private ExerciseContract(

    ){}
    // setting up all the uris to be used

    public static final String EXCONTENT_AUTHORITY = "com.example.android.FitnessApp";

    public static final Uri EXBASE_CONTENT_URI = Uri.parse("content://" + EXCONTENT_AUTHORITY);

    public static final String PATH_EXERCISES = "exercises";


    public static final class ExerciseTable implements BaseColumns{

       //setting up MIME type for list
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_EXERCISES;
        //setting up MIME type for Item
        public  static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_EXERCISES;

        public static final Uri EXCONTENT_URI = Uri.withAppendedPath(EXBASE_CONTENT_URI, PATH_EXERCISES);

        /** Name of database table for  exercises*/
        public final static String TABLE_NAME = "exercises";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_EXERCISE_NAME = "name";
        public final static String COLUMN_EXERCISE_TYPE="type";
        public final static String COLUMN_EXERCISE_BODYPART="bodypart";
        //Values for the common types and Bodyparts to be used
        public static final int TYPE_BARBELL = 0;
        public static final int TYPE_DUMBBELL = 1;
        public static final int TYPE_BODYWEIGHT = 2;
        public static final int TYPE_MACHINCE = 3;

        public static final int BODYPART_CHEST = 0;
        public static final int BODYPART_QUADRICEPS =1;
        public static final int BODYPART_HAMSTRINGS = 2;
        public static final int BODYPART_CALVES = 3;
        public static final int BODYPART_BICEPS = 4;
        public static final int BODYPART_TRICEPS = 5;
        public static final int BODYPART_SHOULDERS = 6;
        public static final int BODYPART_BACK = 7;
        public static final int BODYPART_ABS = 8;

    }
}
