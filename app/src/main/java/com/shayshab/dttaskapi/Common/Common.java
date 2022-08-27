package com.shayshab.dttaskapi.Common;


import com.shayshab.dttaskapi.Network.APIService;
import com.shayshab.dttaskapi.Network.Retrofit;

public class Common {
    private static final String BASE_URL = "http://api.fyber.com/";

    public static APIService getAPIService(){
        return Retrofit.getRetrofitClient(BASE_URL).create(APIService.class);
    }
}