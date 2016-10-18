package cctvnews.wuguicheng.com.retrofitdemo;

/**
 * Created by wuguicheng on 16/10/16.
 */

public class WeatherModel {
    /**
     "lon": 120.58531,
     "level": 2,
     "address": "",
     "cityName": "",
     "alevel": 4,
     "lat": 31.29888
     */
    private float lon;
    private long level;
    private String address;
    private String cityName;
    private long alevel;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getAlevel() {
        return alevel;
    }

    public void setAlevel(long alevel) {
        this.alevel = alevel;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
