package com.ok.okadapter;

import android.content.Context;

import com.ok.library.IMultiType;
import com.ok.library.OkAdapter;
import com.ok.library.OkViewHold;

import java.util.List;

/**
 * Created by chen.huarong on 2018/1/10.
 */

public class MainAdapter extends OkAdapter {

    public MainAdapter(Context context, List datas, int layoutId) {
        super(context, datas, layoutId);
    }

    public MainAdapter(Context context, List datas, IMultiType mulitType) {
        super(context, datas, mulitType);
    }

    @Override
    public void onBindViewHolder(OkViewHold holder, int position) {
        super.onBindViewHolder(holder, position);
    }

}
