package bawei.com.gouwuche.model;

import bawei.com.gouwuche.data.bean.HomeBean;
import bawei.com.gouwuche.data.http.ApiHttp;
import bawei.com.gouwuche.data.http.ApiHttpUtils;
import bawei.com.gouwuche.view.interfacece.Constans;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:10:21
 *@Description:15901514581
 * */public class HomeModel {
     public void showModel(final Constans.CallBackHome callBackHome){
         ApiHttpUtils.getInstance().create(ApiHttp.class).homebean().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<HomeBean>() {
             @Override
             public void accept(HomeBean homeBean) throws Exception {
                 callBackHome.calBck(homeBean);
             }
         });
     }
}
