package com.ok;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/1/3/003.
 * header悬停
 */

public class HeaderViewItemDecoration extends RecyclerView.ItemDecoration {

    private int lastHeaderId = Integer.MIN_VALUE;//上一个item的headerId
    private int currentHeaderId = Integer.MAX_VALUE;//当前item的headerId
    private int currentPosition = 0;
    private View headerView;
    private HeaderView adapter;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (!(parent.getAdapter() instanceof HeaderView)) {
            throw new IllegalStateException("adapter need implements HeaderView!");
        }
        adapter = (HeaderView) parent.getAdapter();
        currentPosition = parent.getChildAdapterPosition(view);
        if (adapter != null) {
            int headerId = adapter.getHeaderId(parent.getChildViewHolder(view));
            if (headerId == Integer.MIN_VALUE) {
                throw new IllegalStateException("headerId can't be Integer.MIN_VALUE");
            }
            if (headerId == Integer.MAX_VALUE) {
                throw new IllegalStateException("headerId can't be Integer.MAX_VALUE");
            }
            //headerId不一样，即出现了不同分组需要留空间给headerView
            if (adapter.getHeaderId(parent.getChildViewHolder(view)) != lastHeaderId) {
                currentHeaderId = adapter.getHeaderId(parent.getChildViewHolder(view));
                if (headerView == null) {
                    headerView = adapter.createHeaderView(parent);
                }
                outRect.set(0, 0, parent.getWidth(), headerView.getHeight());
            }

        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (lastHeaderId != currentHeaderId) {
            if (adapter == null) {
                throw new NullPointerException("adapter is null");
            }
            if (headerView == null) {
                throw new NullPointerException("headerView is null");
            }
            adapter.bindHeaderView(headerView, currentPosition);
            headerView.draw(c);
        }
    }

}
