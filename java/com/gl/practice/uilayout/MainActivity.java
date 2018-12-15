package com.gl.practice.uilayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBut1;
    private Button mBut2;
    private Button mBut3;
    private Button mBut4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBut1 = (Button) findViewById(R.id.button1);
        mBut2 = (Button) findViewById(R.id.button2);
        mBut3 = (Button) findViewById(R.id.button3);
        mBut4 = (Button) findViewById(R.id.button4);

        mBut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity1.class);
                startActivity(intent);
            }
        });

        mBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });

        mBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity3.class);
                startActivity(intent);
            }
        });

        mBut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Activity4.class);
                startActivity(intent);
            }
        });
    }
}
