package com.illidan.my_project_memo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.illidan.my_project_memo.fragment.MemoViewFragment;

import java.util.List;

public class MemoVIewPagerAdapter extends FragmentStatePagerAdapter {

    List<String> pageTitles;

    public MemoVIewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MemoVIewPagerAdapter(FragmentManager fm,List<String> pageTitles) {
        super(fm);
        this.pageTitles = pageTitles;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return new MemoViewFragment();
    }

    @Override
    public int getCount() {
        return pageTitles.size();
    }
}
