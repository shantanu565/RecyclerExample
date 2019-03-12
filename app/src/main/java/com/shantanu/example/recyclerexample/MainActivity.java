package com.shantanu.example.recyclerexample;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean isScrolling=false;
    MyListAdapter listAdapter;
    ArrayList<Food> list;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list= new ArrayList();
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));



        Food[] myListData = new Food[] {
                new Food(0,"ice cream","jay hind"),
                new Food(1,"sandwich","jay hind"),
                new Food(2,"Samosa","jay hind"),
                new Food(1,"idly","jay hind"),
                new Food(0,"ice cream1","jay hind"),
                new Food(1,"ice cream2","jay hind"),
                new Food(2,"dosa","jay hind"),
                new Food(0,"cold drink","jay hind"),
                new Food(0,"coffee","jay hind"),

        };


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(list);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItems=linearLayoutManager.getItemCount();
                int visibleItems=linearLayoutManager.getChildCount();
                int scrolledOutItems=linearLayoutManager.findFirstVisibleItemPosition();
                if (isScrolling && visibleItems+ scrolledOutItems==totalItems){
                    isScrolling=false;
                    fetchData();
                }
            }
        });




        /*
       // MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list,this);
        MyMultipleAdapter myMultipleAdapter=new MyMultipleAdapter(list,this );
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myMultipleAdapter);
        */
    }
    public void fetchData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    list.add(new Food(0,"new sandwich","noida"));
                    list.add(new Food(1,"sandwich","noida"));
                    list.add(new Food(2," latest sandwich","noida"));


                    listAdapter.notifyDataSetChanged();
                }
            }
        },5000);
    }
}
