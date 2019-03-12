package com.shantanu.example.recyclerexample;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyMultipleAdapter extends RecyclerView.Adapter {

    private ArrayList<Food> dataSet;
    Context mContext;
    int total_types;
    private boolean fabStateVolume = false;

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {
        TextView txtType;

        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.textView22);
                   }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.imageView3);
        }
    }

    public static class TextImage extends RecyclerView.ViewHolder {

        TextView textView_m1;
        TextView textView_m2;
        ImageView imageView_iv;

        public TextImage(View itemView) {
            super(itemView);

            this.imageView_iv=(ImageView)itemView.findViewById(R.id.imageView);
            this.textView_m1 = (TextView) itemView.findViewById(R.id.textView);
            this.textView_m1 = (TextView) itemView.findViewById(R.id.textView2);

        }
    }

    public MyMultipleAdapter(ArrayList<Food> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new TextTypeViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_text, parent, false);
                return new ImageTypeViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_image, parent, false);
                return new TextTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).getType()) {
            case 0:
                return Food.TEXT_TYPE;
            case 1:
                return Food.IMAGE_TYPE;
            case 2:
                return Food.AUDIO_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        Food object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.getType()) {
                case Food.TEXT_TYPE:
                    ((TextImage) holder).textView_m1.setText(object.getName());


                    break;
                case Food.IMAGE_TYPE:
                    //((ImageTypeViewHolder) holder).image.setImageResource(object.setImgId(R.drawable.mypic));
                    break;
                case Food.AUDIO_TYPE:

                    ((TextTypeViewHolder) holder).txtType.setText(object.getName());

                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
