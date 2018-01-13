package com.ok.library;

import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;

/**
 * Created by chen.huarong on 2018/1/13.
 * 所有的ItemViewBind需要继续此类或者实现IItemViewBind
 */

public abstract class ItemViewBind<T> implements IItemViewBind<T> {

    private WeakReference<OkAdapter> mOkAdapter;

    public void attachAdapter(OkAdapter okAdapter) {
        this.mOkAdapter = new WeakReference<>(okAdapter);
    }

    public void detach() {
        if (mOkAdapter != null) {
            mOkAdapter.clear();
            mOkAdapter = null;
        }
    }

    public RecyclerView getRecyclerView() {
        if (mOkAdapter != null) {
            if (getOkAdapter() != null) {
                return getOkAdapter().getRecyclerView();
            }
        }
        return null;
    }

    public OkAdapter getOkAdapter() {
        if (mOkAdapter != null) {
            return mOkAdapter.get();
        }
        return null;
    }
}
