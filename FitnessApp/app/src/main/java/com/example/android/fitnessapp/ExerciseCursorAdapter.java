package com.example.android.fitnessapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Brad Smith on 4/25/2017.
 */

public class ExerciseCursorAdapter extends CursorAdapter {

    public ExerciseCursorAdapter(Context context, Cursor c){
        super(context,c,0);

    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.exercise_list_layout, parent, false);

    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nameView = (TextView) view.findViewById(R.id.nameofEx);
        TextView infoView = (TextView) view.findViewById(R.id.summary_Ex);

        String body = cursor.getString(cursor.getColumnIndex("name"));
        int type = cursor.getInt(cursor.getColumnIndex("type"));
        String Stype;
        switch (type){
            case 0:
                Stype = "Barbell";
                break;
            case 1:
                Stype = "Dumbbell";
                break;
            case 2:
                Stype = "Body-Weight";
                break;
            case 3:
                Stype = "Machine";
                break;
            default:
                Stype = "Barbell";

        }

        nameView.setText(body);
        infoView.setText(Stype);
    }
}
