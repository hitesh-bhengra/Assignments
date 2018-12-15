package com.gl.practice.uilayout;

import android.content.DialogInterface;
import android.icu.lang.UCharacterEnums;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * User input of first name.
     */
    private EditText mNameFirst;
    private EditText mNameLast;
    private Spinner mDiagnoseSpinner;
    private Spinner mDateSpinner;
    private Button mSubmitButton;
    private AlertDialog.Builder builder;
    private String mDiagnose;
    private EditText mDiagnoseValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mNameFirst = (EditText) findViewById(R.id.firstname);
        mNameLast =  (EditText) findViewById(R.id.lastname);
        mDiagnoseSpinner = (Spinner) findViewById(R.id.spinner_diag);
        mDateSpinner = (Spinner) findViewById(R.id.dob);
        mSubmitButton = (Button) findViewById(R.id.button_submit);
        mDiagnoseValue = (EditText) findViewById(R.id.value);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.options,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDiagnoseSpinner.setAdapter(arrayAdapter);
        mDiagnoseSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> array = ArrayAdapter.createFromResource(this,R.array.date,android.R.layout.simple_spinner_item);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDateSpinner.setAdapter(array);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if("Other".equals(mDiagnoseSpinner.getSelectedItem().toString()))
                    mDiagnose = mDiagnoseValue.getText().toString();
                else
                    mDiagnose = mDiagnoseSpinner.getSelectedItem().toString();

                builder = new AlertDialog.Builder(Activity3.this);
                String message = "First Name : "+mNameFirst.getText().toString()+"\nLast Name : "+mNameLast.getText().toString()
                                    +"\nDiagnosed : "+mDiagnose+"\nDate of Birth : "+mDateSpinner.getSelectedItem().toString();
                builder.setTitle("Submit Details").
                        setMessage(message).
                        setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Activity3.this,"Submitted",Toast.LENGTH_SHORT).show();
                                mNameFirst.setText("");
                                mNameLast.setText("");

                            }
                        }).setNegativeButton("Back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mNameFirst.setText("");
                                mNameLast.setText("");

                            }
                }).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        if("Other".equals(text)){
            findViewById(R.id.value).setVisibility(View.VISIBLE);
        }
        else
        {
            findViewById(R.id.value).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
