package com.ok.okadapter;

import com.ok.library.ItemViewBind;
import com.ok.library.OkViewHold;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemStringBind extends ItemViewBind<String> {

    @Override
    public void onBind(OkViewHold holder, int position, String item) {
        holder.setText(R.id.text, "String:" + (item instanceof String));
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_string;
    }
}
