package com.ok.okadapter;

import com.ok.library.ItemViewBind;
import com.ok.library.OkViewHold;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemFloatBind extends ItemViewBind<Float> {

    @Override
    public void onBind(OkViewHold holder, int position, Float item) {
        holder.setText(R.id.text, "Float:" + (item instanceof Float));
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_float;
    }
}
