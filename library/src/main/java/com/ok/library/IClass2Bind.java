package com.ok.library;

import android.support.annotation.NonNull;

/**
 * Created by chen.huarong on 2018/1/29.
 * class map ItemViewBind
 */

public interface IClass2Bind {

    ItemViewBind getBind(@NonNull Class clazz);

    ItemViewBind getBind(int viewType);

    int indexOfViewBind(@NonNull Class clazz);

    void register(Class clazz, ItemViewBind itemViewBind);
}
