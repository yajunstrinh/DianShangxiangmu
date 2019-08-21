package bawei.com.rikao11.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bawei.com.rikao11.R;
import bawei.com.rikao11.data.bean.LoginBean;
import bawei.com.rikao11.presenter.LoginPresenter;
import bawei.com.rikao11.view.interfacece.Constans;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter> implements Constans.loginView {
    @BindView(R.id.edit_name_login)
    EditText mEditNameLogin;
    @BindView(R.id.edit_pass_login)
    EditText mEditPassLogin;
    @BindView(R.id.check)
    CheckBox mCheck;
    @BindView(R.id.text_regin)
    TextView mTextRegin;
    @BindView(R.id.but_login)
    Button mButLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showLogin(LoginBean loginBean) {
         if(loginBean!=null){
             Toast.makeText(this,loginBean.getMessage(), Toast.LENGTH_SHORT).show();
             if("0000".equals(loginBean.getStatus())){
                 startActivity(new Intent(MainActivity.this,DingActivity.class));
             }
         }
    }



    @OnClick({R.id.text_regin, R.id.but_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_regin:
                startActivity(new Intent(MainActivity.this,DingActivity.class));
                break;
            case R.id.but_login:
                String name = mEditNameLogin.getText().toString();
                String pass = mEditPassLogin.getText().toString();
                presenter.loginpresenter(name,pass);
                break;
        }
    }
}
