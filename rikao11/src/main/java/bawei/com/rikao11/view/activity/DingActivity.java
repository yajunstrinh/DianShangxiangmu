package bawei.com.rikao11.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bawei.com.rikao11.R;
import bawei.com.rikao11.data.bean.DingBean;
import bawei.com.rikao11.presenter.DingPresenter;
import bawei.com.rikao11.view.interfacece.Constans;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DingActivity extends BaseActivity<DingPresenter> implements Constans.dingView {


    @BindView(R.id.recycle)
    RecyclerView mRecycle;
   int status=1;
   int page=1;
   int count=5;
    @Override
    protected void initData() {
        presenter.dingpresenter(status,page,count);
    }

    @Override
    protected DingPresenter setPresenter() {
        return new DingPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_ding;
    }

    @Override
    public void dingRegin(DingBean dingBean) {
        List<DingBean.OrderListBean> orderList = dingBean.getOrderList();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycle.setLayoutManager(manager);
        BaseAdpater baseAdpater = new BaseAdpater(R.layout.dingitem,orderList);
        mRecycle.setAdapter(baseAdpater);


    }



}
