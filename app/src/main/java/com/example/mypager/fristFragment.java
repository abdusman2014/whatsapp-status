package com.example.mypager;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.util.ArrayList;

public class fristFragment extends Fragment {
    // Store instance variables
    //private String title;
    //private int page;
    RecyclerView r;
    myPicsAdapter ap;

   static ArrayList<File> data;
    //final String WHATSAPP_STATUSES_LOCATION = "WhatsApp/Media/.Statuses";



    ViewPager viewPager;


    // newInstance constructor for creating fragment with arguments
    public static fristFragment newInstance(ArrayList<File> d) {
        fristFragment fragmentFirst = new fristFragment();
        Bundle args = new Bundle();
       // args.putInt("someInt", page);
       // args.putString("someTitle", title);
            data = d;
        fragmentFirst.setArguments(args);
        return fragmentFirst;
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

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        r = view.findViewById(R.id.recycler_Pics);

       // data = getListFiles(new File(Environment.getExternalStorageDirectory() + File.separator  + WHATSAPP_STATUSES_LOCATION));
        ap = new myPicsAdapter(view.getContext(),data);
        r.setAdapter(ap);
        r.setLayoutManager(new GridLayoutManager(view.getContext(),3));
       // r.addItemDecoration(new DividerItemDecoration(view.getContext()));

        return view;
    }
    private ArrayList<File> getListFiles(File parentDir) {
        //  txt.setText(parentDir.getAbsolutePath());
        // Bitmap myBitmap = BitmapFactory.decodeFile(parentDir.getAbsoluteFile().getAbsolutePath());
        // img.setImageBitmap(myBitmap);
        ArrayList<File> inFiles = new ArrayList<>();
        File[] files = parentDir.listFiles();

        if (files == null){
           // Toast.makeText(this,"abcde",Toast.LENGTH_SHORT).show();
        }

        if (files != null) {
            for (File file : files) {
                Log.e("check", file.getName());
                if (file.getName().endsWith(".jpg") ){
                    if (!inFiles.contains(file))
                        inFiles.add(file);
                }
            }
        }
        String a = String.valueOf(123);

        return inFiles;
    }

}
