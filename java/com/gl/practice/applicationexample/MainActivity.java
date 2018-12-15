package com.gl.practice.applicationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = findViewById(R.id.text1);
        mTextView2 = findViewById(R.id.text2);
        mTextView3 = findViewById(R.id.text3);
        mTextView4 = findViewById(R.id.text4);
        mTextView5 = findViewById(R.id.text5);

        CustomApplication customApplication = new CustomApplication();

        mTextView1.setText(customApplication.mArrayList.get(0));
        mTextView2.setText(customApplication.mArrayList.get(1));
        mTextView3.setText(customApplication.mArrayList.get(2));
        mTextView4.setText(customApplication.mArrayList.get(3));
        mTextView5.setText(customApplication.mArrayList.get(4));



    }
}
