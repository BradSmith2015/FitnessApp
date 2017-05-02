package com.example.android.fitnessapp;

import android.app.Activity;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brad Smith on 5/1/2017.
 */

public class WorkoutLayoutOperation {

    public static void add( final Activity activity,String name){

        final LinearLayout linearLayoutform = (LinearLayout) activity.findViewById(R.id.LinearWorkoutLayout);
        final LinearLayout newView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.workout_box_layout,null);
        newView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView nameView=(TextView) newView.findViewById(R.id.workoutname);
        nameView.setText(name);
        linearLayoutform.addView(newView);

        ImageButton btnadd = (ImageButton) newView.findViewById(R.id.addanotherset);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final RelativeLayout repeatView = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.workout_box_repeat,null);
                repeatView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayoutform.addView(repeatView);




            }

        });




    }

    public static void dispaly(final Activity activity){
        LinearLayout scrollViewLinearLayout = (LinearLayout) activity.findViewById(R.id.LinearWorkoutLayout);
        java.util.ArrayList<LinearLayout> layouts = new ArrayList<LinearLayout>();
        for(int i = 0; i < scrollViewLinearLayout.getChildCount(); i++){
            LinearLayout innerLayout = (LinearLayout) scrollViewLinearLayout.getChildAt(i);
            LinearLayout linearLayout = (LinearLayout) innerLayout.findViewById(R.id.workoutbox);
            layouts.add(i,linearLayout);
        }



    }










}
