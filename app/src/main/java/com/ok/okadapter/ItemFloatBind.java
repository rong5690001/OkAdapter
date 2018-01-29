package com.ok.okadapter;

import android.view.ViewGroup;

import com.ok.library.IItemViewBind;
import com.ok.library.ItemViewBind;
import com.ok.library.OkViewHold;

import java.util.List;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemFloatBind extends ItemViewBind<Float> {

    @Override
    public void onBind(OkViewHold holder, int position, Float item) {
        holder.setText(R.id.text, "Float:" + (item instanceof Float));
    }

    @Override
    public void onBind(OkViewHold holder, int position, List data) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_float;
    }
}
