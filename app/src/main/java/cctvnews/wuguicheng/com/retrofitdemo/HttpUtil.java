package cctvnews.wuguicheng.com.retrofitdemo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wuguicheng on 16/10/18.
 */

public class HttpUtil {
    private static HttpUtil httpUtil;
    private APIInterface apiInterface;
    /**基址*/
    private final String BASE_URL = "https://api.github.com";
    private String mBaseUrl = BASE_URL;
    /*超时设置*/
    private  final int DEFAULT_TIMEOUT = 10;

    public HttpUtil(){
        apiInterface = getRetrofit(BASE_URL).create(APIInterface.class);
    }

    public static synchronized HttpUtil getInstance(){
        if(httpUtil==null){
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    /**
     * @param baseUrl 设置为对应的baseUrl
     * @return
     */
    public APIInterface getApiInterface(String baseUrl){
        if(!mBaseUrl.equals(baseUrl)){
            apiInterface = getRetrofit(baseUrl).create(APIInterface.class);
            this.mBaseUrl = baseUrl;
        }
        return apiInterface;
    }


    private Retrofit getRetrofit(String baseUrl){
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)    //连接超时秒
                 .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);    //设置从服务器读取数据超时
        return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    /**
     * 默认的前缀网址为BASE_URL
     * @return
     */
    public APIInterface getApiInterface(){
        return getApiInterface(BASE_URL);
    }


}
