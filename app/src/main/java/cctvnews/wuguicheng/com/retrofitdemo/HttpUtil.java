package cctvnews.wuguicheng.com.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wuguicheng on 16/10/18.
 */

public class HttpUtil {
    private static HttpUtil httpUtil;
    private APIInterface apiInterface;
    private final String BASE_URL = "https://api.github.com";
    private String mBaseUrl = BASE_URL;

    public HttpUtil(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(APIInterface.class);
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
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(APIInterface.class);
            this.mBaseUrl = baseUrl;
        }
        return apiInterface;
    }

    /**
     * 默认的前缀网址为BASE_URL
     * @return
     */
    public APIInterface getApiInterface(){
        return getApiInterface(BASE_URL);
    }


}
