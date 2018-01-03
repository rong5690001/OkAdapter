package com.ok.okadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ok.HeaderViewItemDecoration;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainAdapter = new MainAdapter(this);
        mRecyclerView.setAdapter(mMainAdapter);
        mRecyclerView.addItemDecoration(new HeaderViewItemDecoration());
    }

}
