package com.shayshab.dttaskapi.Repositories;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shayshab.dttaskapi.Model.DataModel;
import com.shayshab.dttaskapi.Network.APIService;
import com.shayshab.dttaskapi.Network.RetrofitClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepo {

    private static final String TAG = "MainRepo";
    private final APIService apiService;

    public MainRepo() {
        this.apiService = RetrofitClient.getApiService();
    }

    public LiveData<DataModel> getApiResponse(String path, String appid, String uid, String token, String ip, String locale, long timestamp, String offer_types, String hashkey) {
        MutableLiveData<DataModel> data = new MutableLiveData<>();
        apiService.getData(path, appid, uid, token, ip, locale, timestamp, offer_types, hashkey)
                .enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                        Log.e(TAG, "onResponse: " + response.body());
                        if (response.isSuccessful()) {
                            data.setValue(response.body());
                        } else {
                            data.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                        data.setValue(null);
                    }
                });
        return data;
    }
}
