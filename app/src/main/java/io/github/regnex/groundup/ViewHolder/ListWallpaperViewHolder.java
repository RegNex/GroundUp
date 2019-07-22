package io.github.regnex.groundup.ViewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import io.github.regnex.groundup.Interface.ItemClickListener;
import io.github.regnex.groundup.R;

import static androidx.recyclerview.widget.RecyclerView.*;

/**
 * Created by HP on 19/02/2018.
 */

public class ListWallpaperViewHolder extends ViewHolder implements View.OnClickListener {
ItemClickListener itemClickListener;
public ImageView wallpaper;


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ListWallpaperViewHolder(View itemView) {
        super(itemView);
        wallpaper = itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
itemClickListener.onClick(v,getAdapterPosition());
    }
}
