package com.bawei.dianshangxiangmu.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.data.bean.BannerBean;
import com.bawei.dianshangxiangmu.data.bean.HomeBean;
import com.bawei.dianshangxiangmu.data.bean.ItemBean;
import com.bawei.dianshangxiangmu.presenter.BanPresenter;
import com.bawei.dianshangxiangmu.view.activity.HomeItemActivity;
import com.bawei.dianshangxiangmu.view.adpater.BaseAdpater1;
import com.bawei.dianshangxiangmu.view.adpater.BaseAdpater2;
import com.bawei.dianshangxiangmu.view.adpater.BaseAdpater3;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:17:12
 *@Description:15901514581
 * */public class FragmentHome extends BaseFragment<BanPresenter> implements Constrans.BeanView {


    @BindView(R.id.xban)
    XBanner mXban;
    @BindView(R.id.image_zuo)
    ImageView mImageZuo;
    @BindView(R.id.image_suo)
    ImageView mImageSuo;
    @BindView(R.id.text_xin)
    TextView mTextXin;
    @BindView(R.id.recycle1)
    RecyclerView mRecycle1;
    @BindView(R.id.text_shi)
    TextView mTextShi;
    @BindView(R.id.recycle2)
    RecyclerView mRecycle2;
    @BindView(R.id.text_pin)
    TextView mTextPin;
    @BindView(R.id.recycle3)
    RecyclerView mRecycle3;
    Unbinder unbinder;
    private List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList;
    private List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1;
    private LinearLayoutManager manager1;
    private List<HomeBean.ResultBean.RxxpBean.CommodityListBean> commodityList2;


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.banData();
        presenter.homePresenter();
    }

    @Override
    protected BanPresenter setPresenter() {
        return new BanPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragmenthome;
    }

    @Override
    public void ban(final BannerBean bannerBean) {
        mXban.setBannerData(bannerBean.getResult());
        mXban.setAutoPalyTime(5000);
        mXban.setPageTransformer(Transformer.ZoomFade);
        mXban.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(bannerBean.getResult().get(position).getXBannerUrl()).into((ImageView) view);

            }
        });
        mXban.startAutoPlay();
    }

    @Override
    public void home(final HomeBean homeBean) {




        commodityList = homeBean.getResult().getMlss().getCommodityList();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
       mTextShi.setText(homeBean.getResult().getMlss().getName());
        mRecycle1.setLayoutManager(manager);
        BaseAdpater1 baseAdpater1 = new BaseAdpater1(R.layout.recycleitem1,commodityList);
        mRecycle1.setAdapter(baseAdpater1);



           baseAdpater1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
               @Override
               public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //   EventBus.getDefault().postSticky(new ItemBean(commodityList.get(position).getCommodityId()));
                   Toast.makeText(getContext(),commodityList.get(position).getCommodityId()+"", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getActivity(), HomeItemActivity.class);
                   intent.putExtra("commodityId",commodityList.get(position).getCommodityId()+"");
                   startActivity(intent);
               }
           });









        commodityList1 = homeBean.getResult().getPzsh().getCommodityList();
        manager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mTextPin.setText(homeBean.getResult().getPzsh().getName());
        mRecycle2.setLayoutManager(manager1);
        BaseAdpater2 baseAdpater2 = new BaseAdpater2(R.layout.recycleitem2,commodityList1);
        mRecycle2.setAdapter(baseAdpater2);



        baseAdpater2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(),commodityList1.get(position).getCommodityId()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HomeItemActivity.class);
                intent.putExtra("commodityId",commodityList1.get(position).getCommodityId()+"");
                startActivity(intent);
            }
        });







        commodityList2 = homeBean.getResult().getRxxp().getCommodityList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecycle3.setLayoutManager(gridLayoutManager);
        mTextXin.setText(homeBean.getResult().getRxxp().getName());
        BaseAdpater3 baseAdpater3 = new BaseAdpater3(R.layout.recycleitem3,commodityList2);
        mRecycle3.setAdapter(baseAdpater3);


        baseAdpater3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(),commodityList2.get(position).getCommodityId()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HomeItemActivity.class);
                intent.putExtra("commodityId",commodityList2.get(position).getCommodityId()+"");
                startActivity(intent);
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mXban.stopAutoPlay();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
