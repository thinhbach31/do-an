package com.example.thinhbachvan.soundcloud.screen.home;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.thinhbachvan.soundcloud.screen.genre.GenreFragment;
import com.example.thinhbachvan.soundcloud.screen.library.LibraryFragment;
import com.example.thinhbachvan.soundcloud.screen.stream.StreamFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_SIZE = 3;

    @interface Tabtype{
        int STREAM_FRAGMENT = 0;
        int GENRE_FRAGMENT = 1;
        int LIBRARY_FRAGMENT = 2;

        String STREAM = "Stream";
        String GENRE = "Genre";
        String LIBRARY = "Library";
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case Tabtype.STREAM_FRAGMENT:
                return new StreamFragment();
            case Tabtype.GENRE_FRAGMENT:
                return new GenreFragment();
            case Tabtype.LIBRARY_FRAGMENT:
                return new LibraryFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case Tabtype.STREAM_FRAGMENT:
                return "";
            case Tabtype.GENRE_FRAGMENT:
                return "";
            case Tabtype.LIBRARY_FRAGMENT:
                return "";
        }
        return getPageTitle(position);
    }

    @Override
    public int getCount() {
        return TAB_SIZE;
    }

    public void setupTab(TabLayout tabLayout, ViewPager viewPager){
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(Tabtype.STREAM_FRAGMENT).setText(Tabtype.STREAM);
        tabLayout.getTabAt(Tabtype.GENRE_FRAGMENT).setText(Tabtype.GENRE);
        tabLayout.getTabAt(Tabtype.LIBRARY_FRAGMENT).setText(Tabtype.LIBRARY);
    }
}
