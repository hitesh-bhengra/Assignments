package com.gl.practice.challenge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class Bedroom extends Fragment {

    private String[] mBedroomItems = {"Bed","Lamp","Pillow","Chair","Dressing Table",
            "Drapes","Alarm Clock","Mirror"};
    private ListView mBedroomListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bedroom, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getContext(),"Bedroom clicked",Toast.LENGTH_SHORT).show();
        mBedroomListView = getView().findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter();
        mBedroomListView.setAdapter(listViewAdapter);
    }

    class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mBedroomItems.length;
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

            View view = getLayoutInflater().inflate(R.layout.list_item, null);
            TextView text = view.findViewById(R.id.list_text);

            text.setText(mBedroomItems[position]);

            return view;
        }
    }
}
