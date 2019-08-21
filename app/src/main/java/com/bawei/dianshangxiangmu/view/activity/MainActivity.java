package com.bawei.dianshangxiangmu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.presenter.LoginPresenter;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter> implements Constrans.LoginView {
    @BindView(R.id.name_main)
    EditText mNameMain;
    @BindView(R.id.pwd_main)
    EditText mPwdMain;
    @BindView(R.id.check_main)
    CheckBox mCheckMain;
    @BindView(R.id.regin_main)
    TextView mReginMain;
    @BindView(R.id.login_main)
    Button mLoginMain;

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }


    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void login(LoginBean string) {
           if(string!=null){
               Log.e("TAG",""+string);
               Toast.makeText(this, string.getMessage(), Toast.LENGTH_SHORT).show();
               if("0000".equals(string.getStatus())){
                   startActivity(new Intent(MainActivity.this,HomeActivity.class));
               }
           }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.regin_main, R.id.login_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regin_main:
                   startActivity(new Intent(MainActivity.this,ReginActivity.class));
                break;
            case R.id.login_main:
                String name = mNameMain.getText().toString();
                String pwd = mPwdMain.getText().toString();
                presenter.loginData(name,pwd);
                break;
        }
    }
}
