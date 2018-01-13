package com.ok.library;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen.huarong on 2017/12/26.
 */

public abstract class OkAdapter extends RecyclerView.Adapter<OkViewHold> {

    List mDatas;
    IMultiType mMulitType;
    Context mContext;
    @LayoutRes
    int layoutId;

    public OkAdapter(Context context, List datas, int layoutId) {
        mDatas = datas == null ? new ArrayList() : datas;
        mContext = context;
        this.layoutId = layoutId;
    }

    public OkAdapter(Context context, List datas, IMultiType mulitType) {
        mDatas = datas == null ? new ArrayList() : datas;
        mMulitType = mulitType;
        mContext = context;
    }

    @Override
    public final OkViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (mMulitType != null) {
            view = inflate(parent, mMulitType.getItemViewBind(viewType).getLayout(parent));
        } else {
            view = inflate(parent, layoutId);
        }
        return new OkViewHold(view);
    }

    @Override
    public void onBindViewHolder(OkViewHold holder, int position) {
        if (mMulitType != null) {
            IItemViewBind itemViewBind = mMulitType.getItemViewBind(getItemViewType(position));
            itemViewBind.onBind(holder, position, getItem(position));
        }
    }

    @Override
    public void onBindViewHolder(OkViewHold holder, int position, List datas) {
        if (mMulitType != null) {
            IItemViewBind itemViewBind = mMulitType.getItemViewBind(getItemViewType(position));
            itemViewBind.onBind(holder, position, getItem(position));
        }
    }

    @Override
    public final int getItemViewType(int position) {
        if (mMulitType != null) {
            return mMulitType.getItemViewType(getItem(position), position);
        }
        return super.getItemViewType(position);
    }

    public <T> T getItem(int position) {
        if (position < mDatas.size()) {
            return (T) mDatas.get(position);
        } else {
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public boolean add(Object item) {
        return mDatas.add(item);
    }

    public boolean addAll(List items) {
        return mDatas.addAll(items);
    }

    public boolean remove(Object item) {
        return mDatas.remove(item);
    }

    public boolean removeAll(List items) {
        return mDatas.removeAll(items);
    }

    public View inflate(ViewGroup parent, @LayoutRes int layoutId) {
        return LayoutInflater.from(mContext).inflate(layoutId, parent, false);
    }
}
