package bawei.com.rikao11.data.http;

import java.util.Map;

import bawei.com.rikao11.data.bean.DingBean;
import bawei.com.rikao11.data.bean.LoginBean;
import bawei.com.rikao11.data.bean.ReginBean;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/*
 *@Auther:张亚军
 *@Date: 2019/8/15
 *@Time:9:12
 *@Description:15901514581
 * */public interface ApiHttp {
     @POST("user/v1/register")
     Observable<ReginBean> regin(@QueryMap Map<String,String> map);

    @POST("user/v1/login")
    Observable<LoginBean> login(@QueryMap Map<String,String> map);


    @GET("order/verify/v1/findOrderListByStatus")
    Observable<DingBean> dingbean(@HeaderMap Map <String,String> map, @Query("status") int status, @Query("page") int page, @Query("count") int count);
}
