package com.bawei.dianshangxiangmu.presenter;

import android.util.Log;

import com.bawei.dianshangxiangmu.data.Model.BannerModel;
import com.bawei.dianshangxiangmu.data.Model.LoginModel;
import com.bawei.dianshangxiangmu.data.bean.BannerBean;
import com.bawei.dianshangxiangmu.data.bean.HomeBean;
import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:14:41
 *@Description:15901514581
 * */public class BanPresenter extends BasePresenter<Constrans.BeanView> {
     public void banData(){
         BannerModel bannerModel = new BannerModel();
         bannerModel.banData(new Constrans.CallBackBan() {
             @Override
             public void BanBack(BannerBean string) {
                 getView().ban(string);
             }
         });
     }
     public void homePresenter(){
         BannerModel bannerModel = new BannerModel();
         bannerModel.homeData(new Constrans.CallBackHome() {
             @Override
             public void homeBack(HomeBean homeBean) {
                 getView().home(homeBean);
             }
         });
     }
}
