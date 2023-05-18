package com.travel.busyflights.domain.busyflights.constants;

public enum ConstantUtils {
    CRAZYAIRJET("http://localhost:8080/crazyairsapis/crazyairflights","01"),
    TOUGHJET("http://localhost:8080/toughjetapis/toughjets","02");
    private final String url;
    private final String urlCode;
    ConstantUtils(String url,String value)
    {
        this.url=url;
        this.urlCode=value;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlCode() {
        return urlCode;
    }
}
