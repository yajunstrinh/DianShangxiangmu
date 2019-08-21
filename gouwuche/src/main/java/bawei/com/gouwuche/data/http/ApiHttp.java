package bawei.com.gouwuche.data.http;

import bawei.com.gouwuche.data.bean.HomeBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:10:05
 *@Description:15901514581
 * */public interface ApiHttp {
     @GET("CartJson/master/CartJson.json")
     Observable<HomeBean> homebean();
}
