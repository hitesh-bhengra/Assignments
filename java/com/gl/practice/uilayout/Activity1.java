package com.gl.practice.uilayout;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.BitSet;
import java.util.Calendar;

import static com.gl.practice.uilayout.Activity2.*;

public class Activity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ListView list;
    private GridView mGrid;
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
    private ImageView mImageView;
    private ImageButton mImageButton;
    private CheckBox mCheckBox;
    private RadioGroup mRadioGroup;
    private Spinner mSpinner;
    private TextView mDatePicker;
    private int mDay,mMonth,mYear;

    public String[] names = {"David de Gea","Marcus Rashford",
            "Jesse Lingard","Luke Shaw",
            "Anthony Martial","Eric Bailly",
            "Phil Jones","Juan Mata"};
    public String[] numbers = {"1","10","13","23","11","3","4","8"};
    public int[] images = {R.drawable.droid,R.drawable.droid,
            R.drawable.droid,R.drawable.droid,
            R.drawable.droid,R.drawable.droid,
            R.drawable.droid,R.drawable.droid};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        list = (ListView) findViewById(R.id.listview1);
        ListAdapter customAdapter = new ListAdapter();
        list.setAdapter(customAdapter);

        mGrid = (GridView) findViewById(R.id.grid);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        mGrid.setAdapter(imageAdapter);

        mTextView = (TextView) findViewById(R.id.act1_TextView);
        mEditText = (EditText) findViewById(R.id.act1_EditText);
        mButton = (Button) findViewById(R.id.act1_Button);
        mImageView = (ImageView) findViewById(R.id.act1_ImageView);
        mImageButton = (ImageButton) findViewById(R.id.act1_ImageButton);
        mRadioGroup = (RadioGroup) findViewById(R.id.act1_radio);
        mSpinner = (Spinner) findViewById(R.id.act1_spinner);
        mDatePicker = (TextView) findViewById(R.id.act1_DatePicker);


        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Event Call : ","TextView was pressed");
            }
        });

        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Event Call : ","EditText was pressed");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Event Call : ","Button was pressed");
            }
        });

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Event Call : ","ImageView was pressed");
            }
        });

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Event Call : ","ImageButton was pressed");
            }
        });

        mRadioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Event Call : ","RadioButton was pressed");
            }
        });


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(Activity1.this,R.array.options,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(arrayAdapter);
        mSpinner.setOnItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Event Call : ","ListView was pressed");
            }
        });

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Event Call : ","GridView was pressed");
            }
        });

        mDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                Log.d("Event Call : ","DatePicker was pressed");
                DatePickerDialog datePickerDialog = new DatePickerDialog(Activity1.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                c.set(year,monthOfYear,dayOfMonth);
                                mDatePicker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }

    public void checkboxSelect(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        Log.d("Event Call : ","CheckBox was pressed");
        switch(view.getId()){
            case R.id.checkbox_bike:
                if(checked)
                    Toast.makeText(Activity1.this,"Bike Checked",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Activity1.this,"Bike Unchecked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkbox_car:
                if(checked)
                    Toast.makeText(Activity1.this,"Car Checked",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Activity1.this,"Car Unchecked",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void radioSelect(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        Log.d("Event Call : ","RadioButton was pressed");
        switch(view.getId()){
            case R.id.radio_bike :
                if(checked)
                    Toast.makeText(Activity1.this,"Bike Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.radio_car :
                if(checked)
                    Toast.makeText(Activity1.this,"Car Selected",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("Event Call : ","ListView was pressed");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class ListAdapter extends BaseAdapter {


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

    public class ImageAdapter extends BaseAdapter{

        private Context mContext;
        public ImageAdapter(Context c) {
            mContext = c;
        }

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
            ImageView imageView;

            if(convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(100,150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8,8,8,8);
            }
            else
            {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(images[position]);

            return imageView;
        }
    }
}
