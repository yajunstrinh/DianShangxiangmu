package bawei.com.rikao11.view.activity;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import bawei.com.rikao11.R;
import bawei.com.rikao11.data.bean.DingBean;

/*
 *@Auther:张亚军
 *@Date: 2019/8/16
 *@Time:9:37
 *@Description:15901514581
 * */ public class BaseAdpater extends BaseQuickAdapter<DingBean.OrderListBean, BaseViewHolder> {

    public BaseAdpater(int layoutResId, @Nullable List<DingBean.OrderListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DingBean.OrderListBean item) {
        helper.setText(R.id.tv_order_id, item.getOrderId() + "");
        RecyclerView recyclerView = helper.getView(R.id.rexyxlessss);
        List<DingBean.OrderListBean.DetailListBean> detailList = item.getDetailList();
          recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        InnerAdater innterAdpater = new InnerAdater(R.layout.xiao, detailList);
        recyclerView.setAdapter(innterAdpater);
    }
}
