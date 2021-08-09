package com.example.mypager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class myPicsAdapter extends RecyclerView.Adapter<myPicsAdapter.myPicsHolder> {
    Context ctx;
    ArrayList<File> data;
    ValueAnimator xsize;

    public myPicsAdapter(Context c, ArrayList<File> d){
        ctx = c;
        data = d;
    }
    @NonNull
    @Override
    public myPicsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater in = LayoutInflater.from(ctx);
        View myView = in.inflate(R.layout.recycler_pics, parent, false);

        return new myPicsHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull myPicsHolder holder, int position) {
       Bitmap myBitmap = BitmapFactory.decodeFile(data.get(position).getAbsolutePath());
        holder.img.setImageBitmap(myBitmap);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myPicsHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public myPicsHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  img.setScaleX(200);
                  //  img.setScaleY(200);
                    Toast.makeText(ctx,"abcd",Toast.LENGTH_SHORT).show();
                    img.setMinimumHeight(200);
                    img.setMinimumWidth(200);

                }
            });
        }
    }
}
