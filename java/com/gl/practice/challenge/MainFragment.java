package com.gl.practice.challenge;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainFragment extends Fragment {

    private TextView mBedroomText;
    private TextView mKitchenText;
    private TextView mStoreroomText;
    private TextView mHallText;
    private TextView mPetName;
    private EditText mEnterName;
    private AlertDialog.Builder mAlertDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBedroomText = getView().findViewById(R.id.text_bedroom);
        mKitchenText = getView().findViewById(R.id.text_kitchen);
        mStoreroomText = getView().findViewById(R.id.text_store);
        mHallText = getView().findViewById(R.id.text_hall);
        mPetName = getView().findViewById(R.id.text_pet);


        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        mBedroomText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                transaction.replace(R.id.main_frame_layout,new Bedroom());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        mKitchenText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.main_frame_layout,new Kitchen());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        mStoreroomText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.main_frame_layout,new StoreRoom());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        mHallText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Hall clicked", Toast.LENGTH_SHORT).show();
                mEnterName = new EditText(getContext());
                mAlertDialog = new AlertDialog.Builder(getContext());
                mAlertDialog.setTitle("Alert Dialog");
                mAlertDialog.setMessage("Enter Pet Name : ");
                mAlertDialog.setView(mEnterName);
                mEnterName.setInputType(InputType.TYPE_CLASS_TEXT);
                mAlertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mPetName.setText(mEnterName.getText().toString());
                        Toast.makeText(getContext(),"Pet Name Set",Toast.LENGTH_SHORT).show();
                    }
                });
                mAlertDialog.show();
            }
        });
    }
}
