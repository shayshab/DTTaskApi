package com.shayshab.dttaskapi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.shayshab.dttaskapi.Model.DataModel;
import com.shayshab.dttaskapi.Repositories.MainRepo;


public class MainActivityViewModel extends ViewModel {
    private final MainRepo mainRepo;

    public MainActivityViewModel() {
        mainRepo = new MainRepo();
    }

    public LiveData<DataModel> getDataList(String path, String appid, String uid, String token, String ip, String locale, long timestamp, String offer_types, String hashkey){
        return mainRepo.getApiResponse(path, appid, uid, token, ip, locale, timestamp, offer_types, hashkey);

    }

}
