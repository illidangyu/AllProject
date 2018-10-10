package com.illidan.my_project_memo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.illidan.my_project_memo.R;
import com.illidan.my_project_memo.adapter.MemoVIewPagerAdapter;
import com.illidan.my_project_memo.database.MemoVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HomeFragment extends Fragment {
    List<String> pageTitle;
    TabLayout homeTabLayout;
    ViewPager homeViewPager;
    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        homeTabLayout = view.findViewById(R.id.home_tab_layout);
        homeViewPager = view.findViewById(R.id.home_view_pager);
        homeTabLayout.setupWithViewPager(homeViewPager);
        pageTitle = new ArrayList<>();


        FirebaseDatabase.getInstance().getReference().child("my_memo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                pageTitle.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MemoVO vo = ds.getValue(MemoVO.class);
                    Log.d("VO", vo.toString());
                    pageTitle.add(vo.getMemoCat());
                }
                Log.d("PageTitle1", "" + pageTitle.size());
//                중복제거
                pageTitle = new ArrayList<>(new TreeSet<>(pageTitle));
//                homeViewPager.setAdapter(new MemoVIewPagerAdapter(getFragmentManager(), pageTitle));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("F-ERROR", databaseError.toString());
            }
        });
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //여기에 딜레이 후 시작할 작업들을 입력
                Log.d("PageTitle3", "" + pageTitle.size());
                homeViewPager.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return pageTitle.get(position);
//                return super.getPageTitle(position);
                    }

                    @Override
                    public Fragment getItem(int position) {
                        return new MemoViewFragment();
                    }

                    @Override
                    public int getCount() {
                        Log.d("PageTitle2", "" + pageTitle.size());
                        return pageTitle.size();
                    }
                });

            }
        }, 2000);
/*

        */

        return view;

    }
}
