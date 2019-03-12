package com.shantanu.example.recyclerexample;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyMultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;

    private ArrayList<Food2> itemList;


    public MyMultipleAdapter(ArrayList<Food2> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Food2 food2 = itemList.get(position);
        if (food2.getType() == Food2.ItemType.TEXTIMAGE_TYPE) {
            return TYPE_ONE;
        } else if (food2.getType() == Food2.ItemType.TEXT_TYPE) {
            return TYPE_TWO;
        } else if (food2.getType() == Food2.ItemType.IMAGE_TYPE){

    }else {
            //return 1;
        }
        return 1;}

 @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_imagetext, parent, false);
            return new ViewHolderOne(view);
        } else if (viewType == TYPE_TWO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_text, parent, false);
            return new ViewHolderTwo(view);
        } else if (viewType==TYPE_THREE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_image, parent, false);
            return new ViewHolderTwo(view);
        }else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int listPosition) {
        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                initLayoutOne((ViewHolderOne)holder, listPosition);
                break;
            case TYPE_TWO:
                initLayoutTwo((ViewHolderTwo) holder, listPosition);
                break;
            case TYPE_THREE:
                initLayoutThree((ViewHolderThree)holder,listPosition);
                break;
            default:
                break;
        }
    }

    private void initLayoutOne(ViewHolderOne holder, int pos) {
        holder.imageView.setImageResource(R.drawable.mypic);
        holder.item.setText(itemList.get(pos).getName());
    }

    private void initLayoutTwo(ViewHolderTwo holder, int pos) {
        holder.tv2.setText(itemList.get(pos).getName());
}
    private void initLayoutThree(ViewHolderThree holder, int pos) {
        holder.imageView3.setImageResource(R.drawable.mypic);
    }


    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView item;
        public ImageView imageView;
        public ViewHolderOne(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.tv_it);
            imageView=(ImageView)itemView.findViewById(R.id.iv_ti);
        }
    }

    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        public TextView tv2;
        public ViewHolderTwo(View itemView) {
            super(itemView);
            tv2 = (TextView) itemView.findViewById(R.id.textView22);
        }
    }

   static class ViewHolderThree extends RecyclerView.ViewHolder {
    public ImageView imageView3;
    public ViewHolderThree(View itemView) {
        super(itemView);
        imageView3 = (ImageView) itemView.findViewById(R.id.imageView3);
    }
}

}
