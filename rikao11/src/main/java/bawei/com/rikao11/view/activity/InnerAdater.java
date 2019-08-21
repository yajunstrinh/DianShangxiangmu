package bawei.com.rikao11.view.activity;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import bawei.com.rikao11.R;
import bawei.com.rikao11.data.bean.DingBean;

/*
 *@Auther:张亚军
 *@Date: 2019/8/17
 *@Time:8:48
 *@Description:15901514581
 * */  public class InnerAdater extends BaseQuickAdapter<DingBean.OrderListBean.DetailListBean, BaseViewHolder> {
    public InnerAdater(int layoutResId, @Nullable List<DingBean.OrderListBean.DetailListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DingBean.OrderListBean.DetailListBean item) {
        ImageView view = helper.getView(R.id.image);
        String[] split = item.getCommodityPic().split(",");

        Glide.with(mContext).load(split[0]).into(view);
        helper.setText(R.id.text_di, item.getCommodityName());
        helper.setText(R.id.price, "￥" + item.getCommodityPrice() + "");
    }
}
