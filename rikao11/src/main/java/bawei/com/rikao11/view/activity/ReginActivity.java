package bawei.com.rikao11.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bawei.com.rikao11.R;
import bawei.com.rikao11.data.bean.ReginBean;
import bawei.com.rikao11.presenter.ReginPresenter;
import bawei.com.rikao11.view.interfacece.Constans;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReginActivity extends BaseActivity<ReginPresenter> implements Constans.reginView {


    @BindView(R.id.edit_name_regin)
    EditText mEditNameRegin;
    @BindView(R.id.edit_pass_regin)
    EditText mEditPassRegin;
    @BindView(R.id.text_login)
    TextView mTextLogin;
    @BindView(R.id.but_regin)
    Button mButRegin;

    @Override
    protected void initData() {

    }

    @Override
    protected ReginPresenter setPresenter() {
        return new ReginPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regin;
    }

    @Override
    public void showRegin(ReginBean reginBean) {
        if(reginBean!=null){
            Toast.makeText(this,reginBean.getMessage(), Toast.LENGTH_SHORT).show();
            if("0000".equals(reginBean.getStatus())){
                startActivity(new Intent(ReginActivity.this,MainActivity.class));
            }
        }
    }


    @OnClick({R.id.text_login, R.id.but_regin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_login:
                startActivity(new Intent(ReginActivity.this,MainActivity.class));
                break;
            case R.id.but_regin:
                String name = mEditNameRegin.getText().toString();
                String pass = mEditPassRegin.getText().toString();
                presenter.reginpresenter(name,pass);
                break;
        }
    }
}
