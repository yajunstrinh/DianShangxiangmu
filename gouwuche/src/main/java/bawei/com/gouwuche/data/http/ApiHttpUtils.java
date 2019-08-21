package bawei.com.gouwuche.data.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:张亚军
 *@Date: 2019/8/14
 *@Time:10:08
 *@Description:15901514581
 * */public class ApiHttpUtils {
    private static final ApiHttpUtils ourInstance = new ApiHttpUtils();
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    public static ApiHttpUtils getInstance() {
        return ourInstance;
    }

    private ApiHttpUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.LIE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }
    public <T> T create(final Class<T> service) {
      return retrofit.create(service);
        }
}
