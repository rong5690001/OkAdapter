package com.ok.library;

/**
 * Created by chen.huarong on 2018/1/10.
 * 多类型接口
 */

public interface IMultiType {

    int getItemViewType(Object object, int position);

    ItemViewBind getItemViewBind(int viewType);
}