package com.ok.library;

/**
 * Created by chen.huarong on 2018/1/10.
 */

public interface IMultiType {

    int getItemViewType(Object object, int position);

    IItemViewBind getItemViewBind(int viewType);
}