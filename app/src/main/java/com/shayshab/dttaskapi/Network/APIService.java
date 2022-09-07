package com.shayshab.dttaskapi.Network;

import com.shayshab.dttaskapi.Model.DataModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @POST("feed/v1/{path}")
    Call<DataModel> getData(
            @Path("path") String path,
            @Query("appid") String appid,
            @Query("uid") String uid,
            @Query("token") String token,
            @Query("ip") String ip,
            @Query("locale") String locale,
            @Query("timestamp") long timestamp,
            @Query("offer_types") String offer_types,
            @Query("hashkey") String hashkey

    );


}
