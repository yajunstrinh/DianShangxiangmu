package com.bawei.dianshangxiangmu.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dianshangxiangmu.R;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:17:12
 *@Description:15901514581
 * */public class FragmentLie extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragmentlie, container, false);

        return inflate;
    }
}
