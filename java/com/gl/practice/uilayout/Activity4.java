package com.gl.practice.uilayout;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    private TextView mXCoordinate;
    private TextView mYCoordinate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        mXCoordinate = (TextView) findViewById(R.id.xcoord);
        mYCoordinate = (TextView) findViewById(R.id.ycoord);

    }




    public boolean onTouchEvent(MotionEvent event) {
        float x,y;
        if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){

            x=event.getX();
            y=event.getY();
            Log.d("Touch Event, (X,Y) : ","("+Float.toString(x)+Float.toString(y)+")");
            mXCoordinate.setText(Float.toString(x));
            mYCoordinate.setText(Float.toString(y));
        }
        return super.onTouchEvent(event);
    }
}