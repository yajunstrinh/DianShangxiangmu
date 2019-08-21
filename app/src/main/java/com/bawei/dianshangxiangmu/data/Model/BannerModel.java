package com.bawei.dianshangxiangmu.data.Model;

import com.bawei.dianshangxiangmu.data.bean.BannerBean;
import com.bawei.dianshangxiangmu.data.bean.HomeBean;
import com.bawei.dianshangxiangmu.data.httpUtils.ApiHttp;
import com.bawei.dianshangxiangmu.data.httpUtils.HttpUtils;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:21:05
 *@Description:15901514581
 * */public class BannerModel {
     public void banData(final Constrans.CallBackBan callBackBan){
          HttpUtils httpUtils = new HttpUtils();
          ApiHttp apiHttp = httpUtils.create(ApiHttp.class);
          apiHttp.bannerBean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<BannerBean>() {
               @Override
               public void accept(BannerBean bannerBean) throws Exception {
                    callBackBan.BanBack(bannerBean);
               }
          });


     }
  public void homeData(final Constrans.CallBackHome callBackHome){
      HttpUtils httpUtils = new HttpUtils();
      ApiHttp apiHttp = httpUtils.create(ApiHttp.class);
      apiHttp.homebean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HomeBean>() {
          @Override
          public void accept(HomeBean homeBean) throws Exception {
              callBackHome.homeBack(homeBean);
          }
      });
  }

}
