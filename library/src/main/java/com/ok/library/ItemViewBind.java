package com.ok.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by chen.huarong on 2018/1/13.
 * All ItemViewBind needs to continue this class or implement IItemViewBind.
 */

public abstract class ItemViewBind<T> implements IItemViewBind<T> {

    private WeakReference<OkAdapter> mOkAdapter;

    @Override
    public void onBind(OkViewHold holder, int position, T item) {

    }

    @Override
    public void onBind(OkViewHold holder, int position, List data) {

    }

    @Override
    public int getLayoutId(int viewType) {
        return 0;
    }

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
        if (checkAdapter()) {
            return mOkAdapter.get().getRecyclerView();
        }
        throw new NullPointerException("mOkAdapter is null, attachAdapter first");
    }

    public OkAdapter getOkAdapter() {
        if (checkAdapter()) {
            return mOkAdapter.get();
        }
        throw new NullPointerException("mOkAdapter is null, attachAdapter first");
    }

    public Context getContext() {
        if (checkAdapter()) {
            return mOkAdapter.get().mContext;
        }
        throw new NullPointerException("mOkAdapter is null, attachAdapter first");
    }

    public boolean checkNotNull(Object object) {
        return object != null;
    }

    /**
     * check adapter is not null
     *
     * @return
     */
    protected boolean checkAdapter() {
        return checkNotNull(mOkAdapter) && checkNotNull(mOkAdapter.get());
    }

}
