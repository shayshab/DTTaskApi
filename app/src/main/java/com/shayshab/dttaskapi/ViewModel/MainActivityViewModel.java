package com.shayshab.dttaskapi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.shayshab.dttaskapi.Model.DataModel;
import com.shayshab.dttaskapi.Repositories.MainRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final MainRepo mainRepo;

    public MainActivityViewModel() {
        mainRepo = new MainRepo();
    }

    public LiveData<DataModel> getDataList(String auth_token, String appid, String uid, String ip, String locale, String offer_types){
        return mainRepo.getDataResponse(auth_token, appid, uid, ip, locale, offer_types);

    }

}
