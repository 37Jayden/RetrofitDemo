package cctvnews.wuguicheng.com.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "testlog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void method2(View view){
        HttpUtil.getInstance()
                .getApiInterface("http://gc.ditu.aliyun.com")
//                .getApiInterface()
                .getWeather("苏州")
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        if(response!=null&&response.isSuccessful()&&response.body()!=null){
                            Toast.makeText(MainActivity.this,response.body().getLon()+":"+response.body().getLat(),Toast.LENGTH_SHORT).show();
                            Log.i(TAG,response.body().getLon()+":"+response.body().getLat());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {
                        t.printStackTrace();
                        Log.e(TAG,"请求失败="+t.getMessage()+":"+t.toString());
                    }
                });
    }

    public void method1(View view){
        HttpUtil.getInstance()
                .getApiInterface()
                .repo("Jayden37")
                .enqueue(new Callback<TestModel>() {
                    @Override
                    public void onResponse(Call<TestModel> call, Response<TestModel> response) {
                        if(response!=null&&response.isSuccessful()&&response.body()!=null) {
                            Toast.makeText(MainActivity.this, response.body().getLogin(), Toast.LENGTH_SHORT).show();
                            Log.i(TAG,response.body().getLogin());
                        }
                    }

                    @Override
                    public void onFailure(Call<TestModel> call, Throwable t) {
                        Log.e(TAG,"请求失败="+t.getMessage()+":"+t.toString());
                    }
                });
    }


}
