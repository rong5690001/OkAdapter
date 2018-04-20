package com.ok.okadapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.ok.library.ItemViewBind;
import com.ok.library.OkAdapter;
import com.ok.library.OkViewHold;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemStringBind extends ItemViewBind<String> {

    @Override
    public void onBind(OkViewHold holder, int position, String item) {
        holder.setText(R.id.text, "String:" + (item != null));
        RecyclerView recyclerView = holder.findViewById(R.id.recyclerView);
        OkAdapter adapter = new OkAdapter(getContext(), getData());
        adapter.register(Integer.class, new ItemIntegerBind());
        if (recyclerView != null) {
            final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    LinearLayoutManager pLayoutManager = ((LinearLayoutManager) getRecyclerView()
                            .getLayoutManager());
                    if (layoutManager.findLastVisibleItemPosition() == getData().size() - 1) {
                        int scrollToPosition = pLayoutManager.findFirstVisibleItemPosition() + 1;
                        scrollToPosition = Math.min(scrollToPosition, getOkAdapter().getItemCount() - 1);
                        recyclerView.scrollTo(getScreenHeight(), 0);
//                        pLayoutManager.setStackFromEnd(true);
                    } else if (layoutManager.findFirstVisibleItemPosition() == 0) {
                        int scrollToPosition = pLayoutManager.findFirstVisibleItemPosition() - 1;
                        scrollToPosition = Math.max(scrollToPosition, 0);
                        pLayoutManager.scrollToPositionWithOffset(scrollToPosition, 0);
                    }
                }
            });
        }
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_string;
    }

    public static List<Integer> getData() {
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        return datas;
    }

    private int getScreenHeight() {
        DisplayMetrics display = getContext().getResources()
                .getDisplayMetrics();
        return display.heightPixels;
    }
}
