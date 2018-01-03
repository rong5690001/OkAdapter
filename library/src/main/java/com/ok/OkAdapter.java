package com.ok;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ok.library.R;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by chen.huarong on 2017/12/26.
 */

public abstract class OkAdapter extends RecyclerView.Adapter<OkViewHold> {

    protected Context mContext;
    @LayoutRes
    private int layoutId;

    public OkAdapter(Context mContext, @LayoutRes int id) {
        this.mContext = mContext;
        layoutId = id;
    }

    @Override
    public OkViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OkViewHold(inflate(layoutId, parent, false));
    }

    public <T> void addType(List<T> datas) {

    }

    protected View inflate(@LayoutRes int id, ViewGroup parent, boolean attachToRoot) {
        return LayoutInflater.from(mContext).inflate(id, parent, attachToRoot);
    }

}
