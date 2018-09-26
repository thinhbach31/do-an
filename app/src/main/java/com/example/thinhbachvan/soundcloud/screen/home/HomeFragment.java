package com.example.thinhbachvan.soundcloud.screen.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinhbachvan.soundcloud.R;

public class HomeFragment extends Fragment {

    private static final int OFF_SCREEN_LIMIT = 2;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(viewPagerAdapter);
        viewPagerAdapter.setupTab(mTabLayout, mViewPager);
        mViewPager.setOffscreenPageLimit(OFF_SCREEN_LIMIT);
    }

    private void initView(View view) {
        mTabLayout = view.findViewById(R.id.home_tabOption);
        mViewPager = view.findViewById(R.id.home_viewPager);
    }

}
