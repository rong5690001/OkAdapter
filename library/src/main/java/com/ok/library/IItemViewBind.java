package com.ok.library;

import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chen.huarong on 2018/1/10.
 * 数据绑定接口
 */

public interface IItemViewBind<T> {

    void onBind(OkViewHold holder, int position, T item);

    void onBind(OkViewHold holder, int position, List data);

    int getLayout(ViewGroup parent);

}
