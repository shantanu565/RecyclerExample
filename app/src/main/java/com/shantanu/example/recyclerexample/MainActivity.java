package com.shantanu.example.recyclerexample;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean isScrolling=false;
    MyListAdapter listAdapter;
    ArrayList<Food> list;
    LinearLayoutManager linearLayoutManager;
    Button button;
    boolean itShouldLoadMore=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button=(Button)findViewById(R.id.ques3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
        list= new ArrayList();
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));
        list.add(new Food(0,"sandwich","noida"));


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
                /*
                int totalItems=linearLayoutManager.getItemCount();
                int visibleItems=linearLayoutManager.getChildCount();
                int scrolledOutItems=linearLayoutManager.findFirstVisibleItemPosition();
                if (isScrolling && visibleItems+ scrolledOutItems==totalItems){
                    isScrolling=false;
                    fetchData();
                }
            }
        });
        */

                if (dy > 0) {
                    if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        if (itShouldLoadMore) {
                            loadMore();
                        }
                    }

                }
            }});


    }
    public void loadMore(){
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
        },1000);
    }

}
