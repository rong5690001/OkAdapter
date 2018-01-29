package com.ok.library;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by chen.huarong on 2017/12/26.
 */

public class OkAdapter extends RecyclerView.Adapter<OkViewHold> {

    @NonNull
    private
    List mDatas;
    @NonNull
    Context mContext;
    private WeakReference<RecyclerView> mRecyclerView;
    @NonNull
    private IClass2Bind mClass2Bind;

    public OkAdapter(Context context, List datas) {
        this(context, datas, new Class2Bind());
    }

    public OkAdapter(@NonNull Context context
            , @NonNull List datas
            , @NonNull IClass2Bind iClass2Bind) {
        this.mContext = context;
        this.mDatas = datas;
        this.mClass2Bind = iClass2Bind;
    }

    @Override
    public final OkViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflate(parent, this.mClass2Bind.getBind(viewType).getLayoutId());
        return new OkViewHold(view);
    }

    @Override
    public void onBindViewHolder(OkViewHold holder, int position) {
        throw new IllegalAccessError("use onBindViewHolder(OkViewHold holder, int position, List datas) instead.");
    }

    @Override
    public void onBindViewHolder(OkViewHold holder, int position, List datas) {
        getItemViewBind(position).onBind(holder, position, datas);
        getItemViewBind(position).onBind(holder, position, getItem(position));
    }

    @Override
    public final int getItemViewType(int position) {
        return mClass2Bind.indexOfViewBind(getItem(position).getClass());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = new WeakReference<>(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (mRecyclerView != null) {
            mRecyclerView.clear();
            mRecyclerView = null;
        }
    }

    /**
     * 注册类型
     *
     * @param clazz
     * @param itemViewBind
     */
    public void register(Class clazz, ItemViewBind itemViewBind) {
        itemViewBind.attachAdapter(this);
        mClass2Bind.register(clazz, itemViewBind);
    }

    public <T> T getItem(int position) {
        if (position < mDatas.size()) {
            return (T) mDatas.get(position);
        } else {
            throw new IndexOutOfBoundsException(String.format("IndexOutOfBounds, position:%d", position));
        }
    }

    RecyclerView getRecyclerView() {
        if (mRecyclerView == null) {
            throw new NullPointerException("recyclerView is null, adapter need set to recyclerView first!");
        }
        return mRecyclerView.get();
    }

    private ItemViewBind getItemViewBind(int position) {
        return mClass2Bind.getBind(getItem(position).getClass());
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @NonNull
    public IClass2Bind getClass2Bind() {
        return mClass2Bind;
    }

    public List getDatas() {
        return mDatas;
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

    private View inflate(ViewGroup parent, @LayoutRes int layoutId) {
        return LayoutInflater.from(mContext).inflate(layoutId, parent, false);
    }
}
