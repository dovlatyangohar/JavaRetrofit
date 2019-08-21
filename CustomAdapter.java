package com.example.javaretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RetroMovies> dataList;
    private Context context;

    public CustomAdapter(List<RetroMovies> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        final View view;

        TextView txtTitle;
        ImageView coverImage;
        TextView txtRating;
        TextView txtReleaseYear;


        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            txtTitle = view.findViewById(R.id.tv_title);
            coverImage = view.findViewById(R.id.img_coverImage);
            txtRating = view.findViewById(R.id.tv_rating);
            txtReleaseYear = view.findViewById(R.id.tv_releaseYear);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View lView = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(lView);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

        holder.txtRating.setText("Rating  "+dataList.get(position).getRating());
        holder.txtReleaseYear.setText("Release year  "+dataList.get(position).getReleaseYear());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
