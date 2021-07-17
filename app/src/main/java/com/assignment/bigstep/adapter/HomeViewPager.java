package com.assignment.bigstep.adapter;

import android.os.Parcelable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.assignment.bigstep.view.fragment.VideoHistoryFragment;
import com.assignment.bigstep.view.fragment.VideoFragment;

public class HomeViewPager extends FragmentStatePagerAdapter {

   /* private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private  Context mContext*/;

    public HomeViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                VideoFragment videoFragment = new VideoFragment();
                return videoFragment;
//            break;
            case 1:
                VideoHistoryFragment historyFragment = new VideoHistoryFragment();
                return historyFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Video";
        } else if (position == 1) {
            title = "History";
        }
        return title;
    }

    @Override
    public void restoreState(final Parcelable state, final ClassLoader loader) {
        try {
            super.restoreState(state, loader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
