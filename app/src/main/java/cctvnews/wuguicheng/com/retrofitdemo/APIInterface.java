package cctvnews.wuguicheng.com.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wuguicheng on 16/10/15.
 */

public interface APIInterface {

    /**https://api.github.com/users/Jayden37*/
    @GET("/users/{user}")
    Call<TestModel> repo(@Path("user") String user);

    /**http://gc.ditu.aliyun.com/geocoding?a=苏州*/
    @GET("/geocoding")
    Call<WeatherModel> getWeather(@Query("a") String cityName);
}
