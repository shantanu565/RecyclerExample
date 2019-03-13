package com.shantanu.example.recyclerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ArrayList <Food2> list2 = new ArrayList<Food2>();
        list2.add(new Food2(Food2.ItemType.IMAGE_TYPE,"","noida"));
        list2.add(new Food2(Food2.ItemType.TEXT_TYPE,"Ice cream2","noida"));
        list2.add(new Food2(Food2.ItemType.IMAGE_TYPE,"","noida"));
        list2.add(new Food2(Food2.ItemType.TEXTIMAGE_TYPE,"Ice cream4","noida"));
        list2.add(new Food2(Food2.ItemType.IMAGE_TYPE,"","noida"));
        list2.add(new Food2(Food2.ItemType.TEXT_TYPE,"Ice cream1","noida"));


        MyMultipleAdapter itemArrayAdapter = new MyMultipleAdapter(list2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemArrayAdapter);




    }
}
