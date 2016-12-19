package com.riddhik.myapps.myprojectrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

/**
 * Created by rkakadia on 6/22/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    String[] movie_names = {"The Martian", "Captain America", "WarCraft", "Batman v Superman",
            "X-man: Apocalypse", "The Conjuring 2", "Finding Dory", "Deadpool", "The Jungle Book", "The Independence Day 2"};
    int[] movie_images = {R.drawable.the_martian, R.drawable.captain_america, R.drawable.warcraft, R.drawable.batman_vs_superman,
            R.drawable.x_man, R.drawable.conjuring_2, R.drawable.finding_dory, R.drawable.deadpool,
            R.drawable.jungle_book, R.drawable.independence_day};

    int lastPosition = -1;

    Context context;
    LayoutInflater inflater;

    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.single_card_view, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.movie_name.setText(movie_names[position]);
        //holder.movie_poster.setImageResource(movie_images[position]);

        //Cannot use Glide here as setTag cannot be used with Glide.
        //Glide.with(context)
        //.load(movie_images[position])
        //.centerCrop()
        //.crossFade()
        //.diskCacheStrategy(DiskCacheStrategy.ALL)
        //.into(holder.movie_poster);

        Picasso.with(context)
                .load(movie_images[position])
                .noFade()
                //.fit()
                .resize(500, 600)
                .centerCrop()
                .into(holder.movie_poster);

        holder.movie_poster.setOnClickListener(clickListener);
        holder.movie_poster.setTag(holder);

        // Here you apply the animation when the view is bound
        setAnimation(holder.cardview, position);
    }

    @Override
    public int getItemCount() {
        return movie_names.length;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder vh = (RecyclerViewHolder) v.getTag();
            int position = vh.getPosition();

            Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("MovieImage", movie_images[position]);
            context.startActivity(intent);

        }
    };

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
