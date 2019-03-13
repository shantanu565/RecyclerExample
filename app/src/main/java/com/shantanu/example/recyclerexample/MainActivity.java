package com.shantanu.example.recyclerexample;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean isScrolling = false;
    MyListAdapter adapter;
    ArrayList<Food> list;
    LinearLayoutManager linearLayoutManager;
    Button button;
    boolean itShouldLoadMore = true;
    boolean isLoading = true;
    int visibleThreshold = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.ques3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
        list = new ArrayList();
        list.add(new Food(0, "sandwich", "noida"));
        list.add(new Food(0, "sandwich", "noida"));
        list.add(new Food(0, "sandwich", "noida"));
        list.add(new Food(0, "sandwich", "noida"));
        list.add(new Food(0, "sandwich", "noida"));
        list.add(new Food(0, "sandwich", "noida"));
        list.add(new Food(0, "sandwich", "noida"));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyListAdapter(list,recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                if (pastVisiblesItems + visibleItemCount == totalItemCount) {
                    loadMore();
                }
            }
        });


    }

    public void loadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                list.add(new Food(0, "new sandwich", "noida"));
                list.add(new Food(1, "sandwich", "noida"));
                list.add(new Food(2, " latest sandwich", "noida"));

                adapter.notifyDataSetChanged();


            }
        }, 1000);
    }


}
