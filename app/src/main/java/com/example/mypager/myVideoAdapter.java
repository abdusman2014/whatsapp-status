package com.example.mypager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class myVideoAdapter extends RecyclerView.Adapter<myVideoAdapter.myVideoHolder> {
    Context ctx;
    ArrayList<File> data;
    public myVideoAdapter(Context c, ArrayList<File> d){
        ctx = c;
        data = d;

    }
    @NonNull
    @Override
    public myVideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater in = LayoutInflater.from(ctx);
        View myView = in.inflate(R.layout.recycler_video, parent, false);
        return new myVideoAdapter.myVideoHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull myVideoHolder holder, int position) {
        holder.video.setVideoPath(data.get(position).getAbsolutePath());
        holder.video.seekTo(2000);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myVideoHolder extends RecyclerView.ViewHolder {
        VideoView video;
        public myVideoHolder(@NonNull final View itemView) {
            super(itemView);

            video = itemView.findViewById(R.id.videoView);

            video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // video.seekTo(2000);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(data.get(getAdapterPosition()).getAbsolutePath()), "video/mp4");
                    ctx.startActivity(intent);


                }
            });


        }

    }
}
