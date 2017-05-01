package com.example.android.fitnessapp.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Brad Smith on 4/30/2017.
 */

public class WorkoutContract {

    public static final String EXCONTENT_AUTHORITY = "com.example.android.FitnessApp";

    public static final Uri WKBASE_CONTENT_URI = Uri.parse("content://" + EXCONTENT_AUTHORITY);

    public static final String PATH_DAY = "workoutday";

    public static final String PATH_WORKEXS = "workoutexercises";

    public static final String PATH_GROUP = "workoutgroups";




    public static final class Workoutsday implements BaseColumns{

        //URI FOR DAY
        public static final String DAY_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_DAY;
        //setting up MIME type for Item
        public  static final String DAY_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_DAY;


        public static final Uri DAYCONTENT_URI = Uri.withAppendedPath(WKBASE_CONTENT_URI, PATH_DAY);
        //URI FOR DAY


        //URI FOR WORKOUT EXERCISES
        public static final String WORKEXS_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_WORKEXS;
        //setting up MIME type for Item
        public  static final String WORKEXS_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_WORKEXS;


        public static final Uri WORKEXSCONTENT_URI = Uri.withAppendedPath(WKBASE_CONTENT_URI, PATH_WORKEXS);
        //URI FOR WORKOUT EXERCISE


        //URI FOR GROUPING
        public static final String GROUP_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_GROUP;
        //setting up MIME type for Item
        public  static final String GROUP_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + EXCONTENT_AUTHORITY + "/" + PATH_GROUP;


        public static final Uri GROUPCONTENT_URI = Uri.withAppendedPath(WKBASE_CONTENT_URI, PATH_GROUP);
        //URI FOR GROUPING






        //Setting up database for the Workouts table
        public final static String TABLE_DAY = "workoutday";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DAY_DATE = "date";
    }
    public static final class WorkoutExercise implements BaseColumns{
        public final static String TABLE_WORKEXS = "workoutexercises";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_WORKEXS_NAME = "name";
        public final static String COLUMN_WORKEXS_SETS  = "sets";
        public final static String COLUMN_WORKEXS_WEIGHTS = "weights";
        public final static String COLUMN_WORKEXS_REPS = "reps";
    }
    public final static class WorkoutGroups {
        public final static String TABLE_GROUPS = "workoutgroups";
        public final static String _ID =BaseColumns._ID;
        public final static String COLUMN_GROUPS_DAYID = "DAY_ID";
        public final static String COLUMN_GROUPS_WORKID = "WORKEXS_ID";
    }
}
