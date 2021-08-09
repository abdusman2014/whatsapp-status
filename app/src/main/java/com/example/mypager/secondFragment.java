package com.example.mypager;

import android.os.Bundle;
import android.os.FileObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class secondFragment extends Fragment {
    // Store instance variables
  //  private String title;
  //  private int page;
    static ArrayList<File> data;
    RecyclerView r;
    myVideoAdapter ap;


    // newInstance constructor for creating fragment with arguments
    public static secondFragment newInstance(ArrayList<File> d) {
        secondFragment secondFragment = new secondFragment();
        Bundle args = new Bundle();
       // args.putInt("someInt", page);
       // args.putString("someTitle", title);
        data = d;
        secondFragment.setArguments(args);
        return secondFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // page = getArguments().getInt("someInt", 0);
       // title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
     //   TextView tvLabel = (TextView) view.findViewById(R.id.textView2);
     //   tvLabel.setText(page + " -- " + title);
        r = view.findViewById(R.id.recyclerVideo);
        // data = getListFiles(new File(Environment.getExternalStorageDirectory() + File.separator  + WHATSAPP_STATUSES_LOCATION));
        ap = new myVideoAdapter(view.getContext(),data);
        r.setAdapter(ap);
        r.setLayoutManager(new GridLayoutManager(view.getContext(),4));
        return view;
    }
}
