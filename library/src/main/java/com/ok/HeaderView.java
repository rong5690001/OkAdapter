package com.ok;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/1/3/003.
 */

public interface HeaderView {

    View createHeaderView(RecyclerView parent);

    int getHeaderId(RecyclerView.ViewHolder childViewHolder);

    void bindHeaderView(View view, int position);
}
