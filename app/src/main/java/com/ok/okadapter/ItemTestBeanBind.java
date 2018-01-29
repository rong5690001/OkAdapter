package com.ok.okadapter;

import com.ok.library.ItemViewBind;
import com.ok.library.OkViewHold;

/**
 * Created by chen.huarong on 2018/1/13.
 */

public class ItemTestBeanBind extends ItemViewBind<TestBean> {

    @Override
    public void onBind(OkViewHold holder, int position, TestBean item) {
        holder.setText(R.id.text, "TestBean:" + (item instanceof TestBean));
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_float;
    }
}
