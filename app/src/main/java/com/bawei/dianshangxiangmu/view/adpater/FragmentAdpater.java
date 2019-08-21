package com.bawei.dianshangxiangmu.view.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:20:10
 *@Description:15901514581
 * */   public class FragmentAdpater extends FragmentPagerAdapter {
    private List<Fragment> list;

    public FragmentAdpater(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public FragmentAdpater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
