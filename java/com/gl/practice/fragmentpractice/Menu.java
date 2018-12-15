package com.gl.practice.fragmentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button instance = findViewById(R.id.instanceexample);
        Button frag1 = findViewById(R.id.fragmentexample1);
        Button frag2 = findViewById(R.id.fragmentexample2);

        instance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this,MainActivity.class);
                startActivity(intent);


            }
        });

        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu = new Intent(Menu.this,Fragments.class);
                startActivity(menu);

            }
        });

        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu = new Intent(Menu.this,HideFragments.class);
                startActivity(menu);

            }
        });

    }
}
