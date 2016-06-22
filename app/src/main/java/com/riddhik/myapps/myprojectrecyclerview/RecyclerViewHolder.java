package com.riddhik.myapps.myprojectrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rkakadia on 6/22/2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView movie_poster;
    TextView movie_name;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        movie_poster = (ImageView) itemView.findViewById(R.id.movie_poster);
        movie_name = (TextView) itemView.findViewById(R.id.movie_name);
    }
}
