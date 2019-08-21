package bawei.com.rikao11.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bawei.com.rikao11.R;
import bawei.com.rikao11.presenter.BasePresenter;
import butterknife.ButterKnife;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:9:00
 *@Description:15901514581
 * */public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        presenter = setPresenter();
        presenter.attchLogin(this);
        initData();
    }

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachLogin();
    }
}
