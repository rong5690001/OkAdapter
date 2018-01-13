package com.ok.library;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by chen.huarong on 2017/12/26.
 */

public class OkViewHold extends RecyclerView.ViewHolder {

    private SparseArray<View> views = new SparseArray<>();

    public OkViewHold(View itemView) {
        super(itemView);
    }

    @Nullable
    public <T> T findViewById(@IdRes int id) {
        View view = views.get(id, null);
        if (view == null) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    public void setText(@IdRes int id, @StringRes int resId) {
        ((TextView) findViewById(id)).setText(resId);
    }

    public void setText(@IdRes int id, String res) {
        ((TextView) findViewById(id)).setText(res);
    }

}
