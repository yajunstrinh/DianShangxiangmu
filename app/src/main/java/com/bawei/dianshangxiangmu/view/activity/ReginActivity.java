package com.bawei.dianshangxiangmu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.data.bean.ReginBean;
import com.bawei.dianshangxiangmu.presenter.ReginPresenter;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReginActivity extends BaseActivity<ReginPresenter> implements Constrans.ReginView {


    @BindView(R.id.phone_main)
    ImageView mPhoneMain;
    @BindView(R.id.name_regin)
    EditText mNameRegin;
    @BindView(R.id.view_name_main)
    View mViewNameMain;
    @BindView(R.id.lock_main)
    ImageView mLockMain;
    @BindView(R.id.pwd_regin)
    EditText mPwdRegin;
    @BindView(R.id.eye_main)
    ImageView mEyeMain;
    @BindView(R.id.view_pwd_main)
    View mViewPwdMain;
    @BindView(R.id.regin_main_regin)
    TextView mReginMainRegin;
    @BindView(R.id.login_regin)
    Button mLoginRegin;

    @Override
    protected void initData() {

    }

    @Override
    protected ReginPresenter setPresenter() {
        return new ReginPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regin;
    }

    @Override
    public void regin(ReginBean reginBean) {
        if(reginBean!=null){
            Log.e("TAG",""+reginBean);
            Toast.makeText(this, reginBean.getMessage(), Toast.LENGTH_SHORT).show();
            if("0000".equals(reginBean.getStatus())){
                startActivity(new Intent(ReginActivity.this,MainActivity.class));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.regin_main_regin, R.id.login_regin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regin_main_regin:
                startActivity(new Intent(ReginActivity.this,MainActivity.class));
                break;
            case R.id.login_regin:
                String name = mNameRegin.getText().toString();
                String pwd = mPwdRegin.getText().toString();
                presenter.reginData(name,pwd);
                break;
        }
    }
}
