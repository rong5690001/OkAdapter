package com.ok.library;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;

/**
 * Created by chen.huarong on 2018/1/29.
 * key:Class.hashCode
 * value:ItemViewBind
 */

public class Class2Bind implements IClass2Bind {

    @Nullable
    private SparseArray<ItemViewBind> mClazz;

    public Class2Bind() {
        mClazz = new SparseArray<>();
    }

    public ItemViewBind getBind(@NonNull Class clazz) {
        checkNotNull();
        return mClazz.get(clazz.hashCode());
    }

    @Override
    public ItemViewBind getBind(int viewType) {
        checkNotNull();
        return mClazz.valueAt(viewType);
    }

    @Override
    public int indexOfViewBind(@NonNull Class clazz) {
        checkNotNull();
        return mClazz.indexOfKey(clazz.hashCode());
    }

    @Override
    public void register(@NonNull Class clazz, @NonNull ItemViewBind itemViewBind) {
        checkNotNull();
        mClazz.put(clazz.hashCode(), itemViewBind);
    }

    public void remove(@NonNull Class clazz) {
        checkNotNull();
        mClazz.remove(clazz.hashCode());
    }

    public void clear() {
        checkNotNull();
        mClazz.clear();
    }

    private void checkNotNull() {
        if (mClazz == null) {
            throw new NullPointerException("Class2Bind mClazz field is null");
        }
    }
}
