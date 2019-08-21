package com.bawei.dianshangxiangmu.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.presenter.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:21:27
 *@Description:15901514581
 * */public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    public P presenter;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), container, false);

        initView();
        unbinder = ButterKnife.bind(this, inflate);
        presenter = setPresenter();
        presenter.attchView(this);
        initData();
        return inflate;
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract int getLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        unbinder.unbind();
    }
}
