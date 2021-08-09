package com.example.mypager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

   // List<File> videoList = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    FragmentPagerAdapter AdapterViewPager;
    static ArrayList<File> pics;
    static ArrayList<File> video;
    String WHATSAPP_STATUSES_LOCATION;


    //"Android/media/com.whatsapp/WhatsApp/Media/.Statuses"
    boolean flag = false;

    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        while (ContextCompat.checkSelfPermission(MainActivity.this, PERMISSIONS[0]) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS, PERMISSION_ALL);
            flag = true;
            Toast.makeText(this,"Press Allow",Toast.LENGTH_SHORT).show();
        }

        if (android.os.Build.VERSION.SDK_INT < 30){
            WHATSAPP_STATUSES_LOCATION = "/WhatsApp/Media";
        }
        else{
            WHATSAPP_STATUSES_LOCATION = "Android/media/com.whatsapp/WhatsApp/Media";
        }

        if (flag == false) {
            getListFiles(new File(Environment.getExternalStorageDirectory() + File.separator + WHATSAPP_STATUSES_LOCATION));
        }
        ViewPager vpPager = (ViewPager)  findViewById(R.id.myPager);
        AdapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(AdapterViewPager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vpPager);

    }

    private void getListFiles(File parentDir) {
        //  txt.setText(parentDir.getAbsolutePath());
        // Bitmap myBitmap = BitmapFactory.decodeFile(parentDir.getAbsoluteFile().getAbsolutePath());
        // img.setImageBitmap(myBitmap);
       // ArrayList<File> inFiles = new ArrayList<>();
        pics = new ArrayList<File>();
        video = new ArrayList<File>();
        File[] files = parentDir.listFiles();
        File[] actualFiles;

        if (files == null){
            // Toast.makeText(this,"abcde",Toast.LENGTH_SHORT).show();
        }

        if (files != null) {
            for (File file : files) {
                Log.e("check", file.getName());
                if(file.getName().contains(".Statuses")  ){

                   // Toast.makeText(this,"access",Toast.LENGTH_SHORT).show();
                    file.setReadable(true);
                    actualFiles = file.listFiles();
                    if (actualFiles != null){
                        Log.e("path", actualFiles.length + ": " + file.getAbsolutePath());
                       // Toast.makeText(this,actualFiles.length,Toast.LENGTH_SHORT).show();
                        for (int i=0;i<actualFiles.length;++i){
                            Toast.makeText(this,"access",Toast.LENGTH_SHORT).show();
                            if (actualFiles[i].getName().endsWith(".jpg") ){

                                if (!pics.contains(actualFiles[i]))
                                    pics.add(actualFiles[i]);
                            }
                            else if (actualFiles[i].getName().endsWith(".mp4") ){
                                if (!video.contains(actualFiles[i]))
                                    video.add(actualFiles[i]);
                            }
                        }
                    }
                    return;
                }

            }
        }
        String a = String.valueOf(123);


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);


        if (requestCode == PERMISSION_ALL) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Toast.makeText(MainActivity.this, "Call Permission Granted", Toast.LENGTH_SHORT).show();
                getListFiles(new File(Environment.getExternalStorageDirectory() + File.separator  + WHATSAPP_STATUSES_LOCATION));
            }
            else {
                //Toast.makeText(MainActivity.this, "Call Permission Denied", Toast.LENGTH_SHORT).show();
                // finish();
                // System.exit(0);

            }
        }


        // String req = String.valueOf(requestCode);
        // Toast.makeText(MainActivity.this, req, Toast.LENGTH_SHORT).show();
    }



    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show firstFragment
                    return fristFragment.newInstance(pics);
                case 1: // Fragment # 1 - This will show secondFragment different title
                    return secondFragment.newInstance(video);
                case 2: // Fragment # 2 - This will show thirdFragment
                    return thirdFragment.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0){
                return "Pictures";
            }
            else if (position == 1){
                return "Vedios";
            }
            else{
                return "GIF";
            }
        }

    }






}