package com.gl.practice.challenge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Kitchen extends Fragment {

    private String[] mKitchenItems = {"Knife","Spoons","Cups","Utensils","Bowls","Storage Containers"};
    private GridView mKitchenGridView;
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kitchen, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getContext(),"Kitchen clicked",Toast.LENGTH_SHORT).show();
        mKitchenGridView = getView().findViewById(R.id.kitchen_gridview);
        GridViewAdapter grid = new GridViewAdapter();
        mKitchenGridView.setAdapter(grid);
    }

    class GridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mKitchenItems.length;
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

            View view;
            if(convertView == null) {
                //view = new View(context);
                view = getLayoutInflater().inflate(R.layout.grid_item, null);
                mTextView = view.findViewById(R.id.gridview_text);
                mTextView.setText(mKitchenItems[position]);
            }
            else {
                view = convertView;
            }

            return view;
        }
    }
}
