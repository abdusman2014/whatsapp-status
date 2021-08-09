package com.example.mypager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class thirdFragment extends Fragment {
    // Store instance variables
   // private String title;
   // private int page;


    // newInstance constructor for creating fragment with arguments
    public static thirdFragment newInstance() {
        thirdFragment thirdFragment = new thirdFragment();
        Bundle args = new Bundle();
      //  args.putInt("someInt", page);
      //  args.putString("someTitle", title);
        thirdFragment.setArguments(args);
        return thirdFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  page = getArguments().getInt("someInt", 0);
      //  title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
      //  TextView tvLabel = (TextView) view.findViewById(R.id.textView3);
      //  tvLabel.setText(page + " -- " + title);
        return view;
    }
}
