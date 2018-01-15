package com.ok.okadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ok.library.IItemViewBind;
import com.ok.library.IMultiType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private IMultiType mIMultiType = new IMultiType() {
        @Override
        public int getItemViewType(Object object, int position) {
            if (object instanceof String) {
                return 0;
            } else if (object instanceof Integer) {
                return 1;
            } else if (object instanceof Float) {
                return 2;
            } else {
                return 3;
            }
        }

        @Override
        public IItemViewBind getItemViewBind(int viewType) {
            switch (viewType) {
                case 0:
                    return new ItemStringBind();
                case 1:
                    return new ItemIntegerBind();
                case 2:
                    return new ItemFloatBind();
                case 3:
                    return new ItemTestBeanBind();
                default:
                    return new ItemStringBind();
            }
        }
    };

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
        mRecyclerView.setAdapter(new MainAdapter(this, data, mIMultiType));
    }


}
