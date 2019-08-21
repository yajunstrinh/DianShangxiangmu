package com.bawei.dianshangxiangmu.view.adpater;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.data.bean.HomeBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:14:13
 *@Description:15901514581
 * */   public class BaseAdpater1 extends BaseQuickAdapter<HomeBean.ResultBean.MlssBean.CommodityListBeanXX,BaseViewHolder> {
    public BaseAdpater1(int layoutResId, @Nullable List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.ResultBean.MlssBean.CommodityListBeanXX item) {
           helper.setText(R.id.text_name,item.getCommodityName());
           helper.setText(R.id.text_price,item.getPrice()+"");
        ImageView view = helper.getView(R.id.image_recycle1);
        Glide.with(mContext).load(item.getMasterPic()).into(view);
    }
}
