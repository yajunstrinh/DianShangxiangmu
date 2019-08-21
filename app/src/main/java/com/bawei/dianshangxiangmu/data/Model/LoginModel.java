package com.bawei.dianshangxiangmu.data.Model;

import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.data.httpUtils.ApiHttp;
import com.bawei.dianshangxiangmu.data.httpUtils.HttpUtils;
import com.bawei.dianshangxiangmu.view.interfacece.Constrans;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:15:35
 *@Description:15901514581
 * */public class LoginModel {
     public void loginShowModel(String name, String pwd,final Constrans.CallBackLogin callBackLogin){
         HttpUtils httpUtils = new HttpUtils();
         ApiHttp apiHttp = httpUtils.create(ApiHttp.class);
         HashMap<String, String> hashMap = new HashMap<>();
           hashMap.put("phone",name);
           hashMap.put("pwd",pwd);
         apiHttp.login(hashMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<LoginBean>() {
             @Override
             public void accept(LoginBean loginBean) throws Exception {
                 callBackLogin.loginBack(loginBean);
             }
         });



     }
}
