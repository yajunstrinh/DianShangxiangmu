package com.bawei.dianshangxiangmu.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.presenter.BasePresenter;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:14:28
 *@Description:15901514581
 * */public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        initView();
        presenter = setPresenter();
        presenter.attchView(this);
        initData();
    }

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract void initView();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
