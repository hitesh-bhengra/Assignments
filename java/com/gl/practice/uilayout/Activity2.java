package com.gl.practice.uilayout;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private ListView list;
    private String[] names = {"David de Gea","Marcus Rashford",
            "Jesse Lingard","Luke Shaw",
            "Anthony Martial","Eric Bailly",
            "Phil Jones","Juan Mata"};
    private String[] numbers = {"1","10","13","23","11","3","4","8"};
    private int[] images = {R.drawable.droid,R.drawable.droid,
            R.drawable.droid,R.drawable.droid,
            R.drawable.droid,R.drawable.droid,
            R.drawable.droid,R.drawable.droid};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        list = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        list.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.list_item,null);
            ImageView img = view.findViewById(R.id.imageview);
            TextView name = view.findViewById(R.id.textView1);
            TextView number = view.findViewById(R.id.textView2);

            img.setImageResource(images[position]);
            name.setText(names[position]);
            number.setText(numbers[position]);

            return view;
        }
    }
}
