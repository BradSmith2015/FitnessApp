package com.example.android.fitnessapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Brad Smith on 4/30/2017.
 */

public class WorkoutCursorAdapter extends CursorAdapter {


    public WorkoutCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.workout_box_layout, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nameView = (TextView) view.findViewById(R.id.workoutname);
        String body = cursor.getString(cursor.getColumnIndex("name"));
        nameView.setText(body);



    }
}
