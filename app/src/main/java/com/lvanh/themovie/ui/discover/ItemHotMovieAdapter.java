package com.lvanh.themovie.ui.discover;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.lvanh.themovie.Helper;
import com.lvanh.themovie.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ItemHotMovieAdapter extends RecyclerView.Adapter<ItemHotMovieAdapter.ItemViewAdapter> {

    private List<String> urlItems;
    private ViewPager2 viewPager2;

    ItemHotMovieAdapter(List<String> urlItems, ViewPager2 viewPager2) {
        this.urlItems = urlItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ItemViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewAdapter(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.m_item_image_hot_movie,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewAdapter holder, int position) {
        holder.setImage(urlItems.get(position));
    }

    @Override
    public int getItemCount() {
        return urlItems.size();
    }

    class ItemViewAdapter extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        public ItemViewAdapter(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.img_item_hotmovie);
        }

        public void setImage(final String url) {
            new Helper.DownloadImageTask(imageView).execute(url);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("mylog",url);
                }
            });
        }
    }
}
