package com.bitleet.miucsefest2020.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bitleet.miucsefest2020.day_1;
import com.bitleet.miucsefest2020.day_2;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();
    private int days;


    public PagerAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment, int behavior) {
        super(fm, behavior);
        this.days = days;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new day_1();
            case 1:
                return new day_2();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }


}
