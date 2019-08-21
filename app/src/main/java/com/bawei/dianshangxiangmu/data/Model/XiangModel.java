package com.bawei.dianshangxiangmu.data.Model;

import com.bawei.dianshangxiangmu.data.bean.XiangBean;
import com.bawei.dianshangxiangmu.data.httpUtils.ApiHttp;
import com.bawei.dianshangxiangmu.data.httpUtils.HttpUtils;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:17:26
 *@Description:15901514581
 * */public class XiangModel{
     public void XaingModel(String commodityId,final Constrans.CallBackXiang callBackXiang){
         HttpUtils httpUtils = new HttpUtils();
         ApiHttp apiHttp = httpUtils.create(ApiHttp.class);

         apiHttp.xiangbean(commodityId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<XiangBean>() {
             @Override
             public void accept(XiangBean xiangBean) throws Exception {
                 callBackXiang.xiangnBack(xiangBean);
             }
         });
     }

}
