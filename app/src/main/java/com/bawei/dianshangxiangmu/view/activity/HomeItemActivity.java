package com.bawei.dianshangxiangmu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dianshangxiangmu.R;
import com.bawei.dianshangxiangmu.data.bean.XiangBean;
import com.bawei.dianshangxiangmu.presenter.XiangPresenter;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeItemActivity extends BaseActivity<XiangPresenter> implements Constrans.XiangView {

    private String commodityId;
    private TextView text_price,text_scs;
    private ImageView image;
    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text_price = findViewById(R.id.text_price);
        text_scs = findViewById(R.id.text_scs);
        image = findViewById(R.id.image);
        web_view = findViewById(R.id.web_View);

    }

    @Override
    protected void initData() {

                presenter.xingpresenter(commodityId);


    }

    @Override
    protected XiangPresenter setPresenter() {
        return new XiangPresenter();
    }

    @Override
    protected void initView() {
        //EventBus.getDefault().register(this);
        Intent intent = getIntent();
        commodityId = intent.getStringExtra("commodityId");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home_item;

    }

    @Override
    public void xiang(XiangBean xiangBean) {
        XiangBean.ResultBean result = xiangBean.getResult();
        String[] split = result.getPicture().split(",");
        Glide.with(this).load(split[0]).into(image);
        text_price.setText("￥"+xiangBean.getResult().getPrice()+"");
        text_scs.setText(xiangBean.getResult().getCommodityName());


        //webview加载接口中代码
        String details = xiangBean.getResult().getDetails();
        WebSettings settings = web_view.getSettings();
        settings.setJavaScriptEnabled(true);
        web_view.loadData(details,"text/html; charset=utf-8",null);

    }


}
