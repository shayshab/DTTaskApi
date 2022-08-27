package com.shayshab.dttaskapi.Network;

import com.shayshab.dttaskapi.Model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("feed/v1/offers.json")
    Call<DataModel> getData(
            @Header("Authorization") String auth_token,

            @Query("appid") String appid,
            @Query("uid") String uid,
            @Query("ip") String ip,
            @Query("locale") String locale,
            @Query("offer_types") String offer_types




    );
}
