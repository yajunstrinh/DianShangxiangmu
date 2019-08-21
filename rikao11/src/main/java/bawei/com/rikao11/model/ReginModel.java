package bawei.com.rikao11.model;

import java.util.HashMap;
import java.util.Map;

import bawei.com.rikao11.data.bean.LoginBean;
import bawei.com.rikao11.data.bean.ReginBean;
import bawei.com.rikao11.data.http.ApiHttp;
import bawei.com.rikao11.data.http.ApiHttpUtils;
import bawei.com.rikao11.view.interfacece.Constans;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:9:16
 *@Description:15901514581
 * */public class ReginModel {
     public void reginMofrl(String name, String pass, final Constans.CallBackRegin callBackRegin){
         Map<String,String> stringMap =new HashMap<>();
         stringMap.put("phone",name);
         stringMap.put("pwd",pass);
         ApiHttpUtils.getInstance().create(ApiHttp.class).regin(stringMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ReginBean>() {
             @Override
             public void accept(ReginBean reginBean) throws Exception {
                 callBackRegin.callRegin(reginBean);
             }
         });
     }
}
