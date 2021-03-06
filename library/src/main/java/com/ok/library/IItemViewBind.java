package com.ok.library;

import android.support.annotation.LayoutRes;

import java.util.List;

/**
 * Created by chen.huarong on 2018/1/10.
 * Data binding interface
 */

public interface IItemViewBind<T> {

    void onBind(OkViewHold holder, int position, T item);

    void onBind(OkViewHold holder, int position, List data);

    @LayoutRes
    int getLayoutId(int viewType);

}
