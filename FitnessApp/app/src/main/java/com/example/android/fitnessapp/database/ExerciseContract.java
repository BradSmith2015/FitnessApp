package com.example.android.fitnessapp.database;


import android.provider.BaseColumns;

/**
 * Created by Brad Smith on 4/9/2017.
 */

public final class ExerciseContract {
    private ExerciseContract(){}
    public static final class ExerciseTable implements BaseColumns{
        public final static String TABLE_NAME = "exercises";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_EXERCISE_NAME = "name";
        public final static String COLUMN_EXERCISE_TYPE="type";
        public final static String COLUMN_EXERCISE_BODYPART="bodypart";

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