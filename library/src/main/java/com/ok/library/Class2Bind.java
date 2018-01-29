package com.ok.library;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen.huarong on 2018/1/29.
 */

public class Class2Bind implements IClass2Bind {

    @NonNull
    private List<Class> mClasses;
    @NonNull
    private List<ItemViewBind> mItemViewBinds;

    Class2Bind() {
        mClasses = new ArrayList<>();
        mItemViewBinds = new ArrayList<>();
    }

    public ItemViewBind getBind(@NonNull Class clazz) {
        return mItemViewBinds.get(mClasses.indexOf(clazz));
    }

    @Override
    public ItemViewBind getBind(int viewType) {
        return mItemViewBinds.get(viewType);
    }

    @Override
    public int indexOfViewBind(@NonNull Class clazz) {
        return mClasses.indexOf(clazz);
    }

    @Override
    public void register(@NonNull Class clazz, @NonNull ItemViewBind itemViewBind) {
        mClasses.add(clazz);
        mItemViewBinds.add(itemViewBind);
    }

    public void remove(@NonNull Class clazz) {
        mItemViewBinds.remove(mClasses.indexOf(clazz));
        mClasses.remove(clazz);
    }

    public void clear() {
        mClasses.clear();
        mItemViewBinds.clear();
    }
}
