package com.ok.okadapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ok.library.OkAdapter;

import me.kaelaela.verticalviewpager.transforms.DefaultTransformer;

public class VerticalViewPagerActivity extends AppCompatActivity {

    MyVerticalViewPager mViewPager;
    boolean isAtBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_view_pager);
        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setPageTransformer(false, new DefaultTransformer());
        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                isAtBottom = false;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setGestureListener(new MyVerticalViewPager.GestureListener() {
            @Override
            public void onDownMove() {
                if(!isAtBottom){
                    mViewPager.setNeedInterceptTouch(false);
                }
            }

            @Override
            public void onUpMove() {
                if (isAtBottom){
                    mViewPager.setNeedInterceptTouch(false);
                }
            }
        });
    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = LayoutInflater.from(VerticalViewPagerActivity.this).inflate(R.layout.item_string, null);
            RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
            OkAdapter adapter = new OkAdapter(VerticalViewPagerActivity.this, ItemStringBind.getData());
            adapter.register(Integer.class, new ItemIntegerBind());
            if (recyclerView != null) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(VerticalViewPagerActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        boolean isOk = dy < 0;
                        LinearLayoutManager layoutManager1 = (LinearLayoutManager) recyclerView.getLayoutManager();
                        if (layoutManager1.findLastVisibleItemPosition() == 99) {
                            View lastItemView = layoutManager1.findViewByPosition(99);
                            if (lastItemView.getBottom() - lastItemView.getTop() <= lastItemView.getHeight()
                                    && !isOk) {
                                isAtBottom = true;
                                mViewPager.setNeedInterceptTouch(true);
                            }
//                        pLayoutManager.setStackFromEnd(true);
                        } else if (layoutManager1.findFirstVisibleItemPosition() == 0
                                && isOk) {
                            View firstItem = layoutManager1.findViewByPosition(0);
                            if (firstItem.getTop() == 0) {
                                isAtBottom = false;
                                mViewPager.setNeedInterceptTouch(true);
                            }
                        }
                    }
                });

            }
            container.addView(view);
            return view;
        }
    }

}
