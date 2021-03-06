package com.ok.okadapter;

import com.ok.library.ItemViewBind;
import com.ok.library.OkViewHold;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemIntegerBind extends ItemViewBind<Integer> {

    @Override
    public void onBind(OkViewHold holder, int position, Integer item) {
        holder.setText(R.id.text, "Integer:" + (item instanceof Integer));
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_integer;
    }
}
