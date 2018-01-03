package com.ok.okadapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ok.HeaderView;
import com.ok.OkAdapter;
import com.ok.OkViewHold;

/**
 * Created by Administrator on 2018/1/3/003.
 */

public class MainAdapter extends OkAdapter implements HeaderView {

    public MainAdapter(Context mContext) {
        super(mContext, R.layout.item_main);
    }

    @Override
    public View createHeaderView(RecyclerView parent) {
        return inflate(R.layout.headerview, parent, false);
    }

    @Override
    public int getHeaderId(RecyclerView.ViewHolder childViewHolder) {
        return childViewHolder.getAdapterPosition() % 2;
    }

    @Override
    public void bindHeaderView(View view, int position) {
        ((TextView) view.findViewById(R.id.textView)).setText(String.valueOf(position % 2));
    }

    @Override
    public void onBindViewHolder(OkViewHold holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
