package bawei.com.gouwuche.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bawei.com.gouwuche.R;
import bawei.com.gouwuche.presenter.BasePresenter;
import butterknife.ButterKnife;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:9:57
 *@Description:15901514581
 * */public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
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
