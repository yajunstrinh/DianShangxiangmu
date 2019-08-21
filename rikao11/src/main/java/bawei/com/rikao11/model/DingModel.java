package bawei.com.rikao11.model;

import java.util.HashMap;
import java.util.Map;

import bawei.com.rikao11.data.bean.DingBean;
import bawei.com.rikao11.data.http.ApiHttp;
import bawei.com.rikao11.data.http.ApiHttpUtils;
import bawei.com.rikao11.view.interfacece.Constans;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/16
 *@Time:9:21
 *@Description:15901514581
 * */public class DingModel {
     public void Dingmodel(int status,int page,int count,final Constans.CallBackding callBackding){
         ApiHttpUtils apiHttpUtils = new ApiHttpUtils();
         ApiHttp apiHttp = apiHttpUtils.create(ApiHttp.class);
         Map<String,String> map=new HashMap<>();
         map.put("userid","4896");
         map.put("sessionId","15662841578364896");
         apiHttp.dingbean(map,status,page,count).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<DingBean>() {
             @Override
             public void accept(DingBean dingBean) throws Exception {
                 callBackding.callDing(dingBean);
             }
         });


     }
}
