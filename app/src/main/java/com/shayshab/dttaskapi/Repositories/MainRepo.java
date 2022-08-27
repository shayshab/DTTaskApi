package com.shayshab.dttaskapi.Repositories;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shayshab.dttaskapi.Common.Common;
import com.shayshab.dttaskapi.Model.DataModel;
import com.shayshab.dttaskapi.Network.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepo {
    private static final String TAG = "MainRepo";
    private APIService apiService;

    public MainRepo() {
        this.apiService = Common.getAPIService();
    }

    public LiveData<DataModel> getDataResponse(String auth_token, String appid, String uid, String ip, String locale, String offer_types ) {
        MutableLiveData<DataModel> data = new MutableLiveData<>();
        String b_token = "Bearer "+ auth_token;
        apiService.getData(b_token, appid, uid, ip, locale, offer_types).enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                Log.e(TAG, "onResponse: " + response.code());
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
