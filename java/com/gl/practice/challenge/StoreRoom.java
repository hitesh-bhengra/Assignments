package com.gl.practice.challenge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class StoreRoom extends Fragment {

    private Spinner mStoreRoomSpinner;
    private String[] mStoreroomItems= {"Ladder", "Burner","Cardboard Boxes",
            "Books","Decor","Baby Clothes"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_room, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getContext(),"StoreRoom clicked",Toast.LENGTH_SHORT).show();
        mStoreRoomSpinner = getView().findViewById(R.id.storeroom_spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,mStoreroomItems);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStoreRoomSpinner.setAdapter(spinnerAdapter);
    }
}
