package com.example.sagarsharma4.retaildemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static List<Data> data;
    public static List<Data> cart = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent2=getIntent();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        data = fill_data();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new HomeAdapter(this, data));

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        Button cartHomeBtn = (Button) findViewById(R.id.cartBtnHome);

        cartHomeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(HomePage.this, CartView.class);
                startActivity(intent);
            }
        });


    }

    private List<Data> fill_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data(R.drawable.a, "Phone 1", "1", "Best Phone"));
        data.add(new Data(R.drawable.b, "Phone 2", "1", "Best Phone"));
        data.add(new Data(R.drawable.c, "Phone 3", "1", "Best Phone"));
        data.add(new Data(R.drawable.d, "Phone 4", "1", "Best Phone"));
        data.add(new Data(R.drawable.e, "Phone 5", "1", "Best Phone"));
        data.add(new Data(R.drawable.f, "Phone 6", "1", "Best Phone"));
        data.add(new Data(R.drawable.g, "Phone 7", "1", "Best Phone"));
        data.add(new Data(R.drawable.h, "Phone 8", "1", "Best Phone"));
        data.add(new Data(R.drawable.i, "Phone 9", "1", "Best Phone"));
        data.add(new Data(R.drawable.j, "Phone 10", "1", "Best Phone"));
        data.add(new Data(R.drawable.k, "Phone 11", "1", "Best Phone"));
        data.add(new Data(R.drawable.l, "Phone 12", "1", "Best Phone"));
        data.add(new Data(R.drawable.m, "Phone 13", "1", "Best Phone"));
        data.add(new Data(R.drawable.n, "Phone 14", "1", "Best Phone"));
        data.add(new Data(R.drawable.o, "Phone 15", "1", "Best Phone"));
        data.add(new Data(R.drawable.p, "Phone 16", "1", "Best Phone"));
        data.add(new Data(R.drawable.q, "Phone 17", "1", "Best Phone"));
        data.add(new Data(R.drawable.r, "Phone 18", "1", "Best Phone"));
        data.add(new Data(R.drawable.s, "Phone 19", "1", "Best Phone"));
        data.add(new Data(R.drawable.t, "Phone 20", "1", "Best Phone"));

        return data;
    }


}

