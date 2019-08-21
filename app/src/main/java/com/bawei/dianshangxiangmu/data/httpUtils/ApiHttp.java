package com.bawei.dianshangxiangmu.data.httpUtils;

import com.bawei.dianshangxiangmu.data.bean.BannerBean;
import com.bawei.dianshangxiangmu.data.bean.HomeBean;
import com.bawei.dianshangxiangmu.data.bean.LoginBean;
import com.bawei.dianshangxiangmu.data.bean.ReginBean;
import com.bawei.dianshangxiangmu.data.bean.XiangBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/*
 *@Auther:张亚军
 *@Date: 2019/8/13
 *@Time:15:27
 *@Description:15901514581
 * */public interface ApiHttp {
     @POST("user/v1/login")
     Observable<LoginBean> login(@QueryMap HashMap<String,String> hashMap);
     @POST("user/v1/register")
     Observable<ReginBean> regin(@QueryMap HashMap<String,String> hashMap);
     @GET("commodity/v1/bannerShow")
     Observable<BannerBean> bannerBean();
     @GET("commodity/v1/commodityList")
     Observable<HomeBean> homebean();
     @GET("commodity/v1/findCommodityDetailsById")
     Observable<XiangBean> xiangbean(@Query("commodityId")String commodityId);

}
