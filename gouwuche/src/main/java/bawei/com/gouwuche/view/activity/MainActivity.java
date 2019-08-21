package bawei.com.gouwuche.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

import bawei.com.gouwuche.R;
import bawei.com.gouwuche.data.bean.HomeBean;
import bawei.com.gouwuche.presenter.HomePresenter;
import bawei.com.gouwuche.view.adpater.BaseAdpater;
import bawei.com.gouwuche.view.interfacece.Constans;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<HomePresenter> implements Constans.BaseMain {
    @BindView(R.id.wlistview)
    ExpandableListView mWlistview;
    @BindView(R.id.check_main)
    CheckBox mCheckMain;
    @BindView(R.id.text_main)
    TextView mTextMain;
    @BindView(R.id.but_main)
    Button mButMain;
    private List<HomeBean.DataBean> data;
    private BaseAdpater baseAdpater;
    private boolean misAllstause = false;

    @Override
    protected void initData() {
        presenter.showPresenter();
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void main(HomeBean string) {
        data = string.getData();
        baseAdpater = new BaseAdpater(data);
        baseAdpater.setCarOnLinseten(new BaseAdpater.CarOnLinseten() {
            @Override
            public void oncar(boolean isAllstause, float coprice, int num) {
                refreshButtom(isAllstause, coprice, num);
            }
        });
        mWlistview.setAdapter(baseAdpater);
        for (int i = 0; i < data.size(); i++) {
            mWlistview.expandGroup(i);
        }
    }

    private void refreshButtom(boolean isAllstause, float coprice, int num) {
        misAllstause = isAllstause;
        mCheckMain.setChecked(misAllstause);
        mTextMain.setText("" + coprice);
        mButMain.setText("" + num);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.check_main)
    public void onViewClicked() {
        misAllstause = !misAllstause;
        baseAdpater.changAllpreduocet(misAllstause);
        baseAdpater.resetCartAllaSTUST();
    }
}
