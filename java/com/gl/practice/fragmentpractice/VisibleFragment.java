package com.gl.practice.fragmentpractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class VisibleFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_visible, container, false);

        Button button = view.findViewById(R.id.showfragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFragment();

            }
        });
        return view;
    }

    private void viewFragment(){
        HiddenFragment hiddenFragment = new HiddenFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.hidden,hiddenFragment);
        ft.addToBackStack(null);
        ft.commit();
    }


}
