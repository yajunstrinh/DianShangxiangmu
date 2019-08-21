package com.bawei.dianshangxiangmu.data.Model;

import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.data.bean.ReginBean;
import com.bawei.dianshangxiangmu.data.httpUtils.ApiHttp;
import com.bawei.dianshangxiangmu.data.httpUtils.HttpUtils;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:15:35
 *@Description:15901514581
 * */public class ReginModel {
     public void reginShowModel(String name, String pwd, final Constrans.CallBackRegin callBackRegin){
         HttpUtils httpUtils = new HttpUtils();
         ApiHttp apiHttp = httpUtils.create(ApiHttp.class);
         HashMap<String, String> hashMap = new HashMap<>();
           hashMap.put("phone",name);
           hashMap.put("pwd",pwd);
         apiHttp.regin(hashMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ReginBean>() {
             @Override
             public void accept(ReginBean reginBean) throws Exception {
                 callBackRegin.reginBack(reginBean);
             }
         });



     }
}
