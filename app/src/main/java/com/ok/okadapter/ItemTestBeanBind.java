package com.ok.okadapter;

import android.view.ViewGroup;

import com.ok.library.IItemViewBind;
import com.ok.library.ItemViewBind;
import com.ok.library.OkViewHold;

import java.util.List;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemTestBeanBind extends ItemViewBind<TestBean> {

    @Override
    public void onBind(OkViewHold holder, int position, TestBean item) {
        holder.setText(R.id.text, "TestBean:" + (item instanceof TestBean));
    }

    @Override
    public void onBind(OkViewHold holder, int position, List data) {

    }

    @Override
    public int getLayout(ViewGroup parent) {
        return R.layout.item_float;
    }
}
