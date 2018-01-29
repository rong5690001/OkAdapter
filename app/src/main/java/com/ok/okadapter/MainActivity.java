package com.ok.okadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ok.library.IItemViewBind;
import com.ok.library.IMultiType;
import com.ok.library.ItemViewBind;
import com.ok.library.OkAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List data = new ArrayList();
        data.add("String");
        data.add(1);
        data.add(0.1f);
        data.add("String");
        data.add(1);
        data.add(0.1f);
        data.add("String");
        data.add(1);
        data.add(0.1f);
        data.add(new TestBean());
        OkAdapter okAdapter = new OkAdapter(this, data);
        okAdapter.register(String.class, new ItemStringBind());
        okAdapter.register(Integer.class, new ItemIntegerBind());
        okAdapter.register(Float.class, new ItemFloatBind());
        okAdapter.register(TestBean.class, new ItemTestBeanBind());
        mRecyclerView.setAdapter(okAdapter);
    }


}
