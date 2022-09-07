package com.shayshab.dttaskapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;


import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.shayshab.dttaskapi.Adapter.DataListAdapter;
import com.shayshab.dttaskapi.Common.Common;
import com.shayshab.dttaskapi.Model.DataModel;
import com.shayshab.dttaskapi.ViewModel.MainActivityViewModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    RecyclerView recyclerView;
    DataListAdapter adapter;
    String hashKey, deviceID, path = "offers.json";
    long timeStamp;



    EditText edtToken, edtUserId, edtAppID;
    String eToken, eUserID, eAppId;
    Button btnGetData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        printKeyHash();

        initViews();


        timeStamp = System.currentTimeMillis() / 1000L;
        Log.d("Time Stamp", String.valueOf(timeStamp));

        deviceID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.e("Device ID", "" + deviceID);



    }


    private void initViews() {
        edtToken = findViewById(R.id.edtToken);
        edtUserId = findViewById(R.id.edtUserId);
        edtAppID = findViewById(R.id.edtAppID);
        btnGetData = findViewById(R.id.btnGetData);
        recyclerView = findViewById(R.id.recyclerView);

        edtUserId.setText(Common.USER_ID);
        edtAppID.setText(Common.APP_ID);
        edtToken.setText(Common.TOKEN);

        btnGetData.setOnClickListener(view -> {
            showDataList();
        });
    }


        private void printKeyHash() {
            try {

                PackageInfo info = getPackageManager().getPackageInfo("com.shayshab.dttaskapi", PackageManager.GET_SIGNATURES);
                for (Signature signature : info.signatures){
                    MessageDigest md = MessageDigest.getInstance("SHA1");
                    md.update(signature.toByteArray());

                    hashKey = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                    Log.d("KEYHASH", hashKey);
                }
            }
            catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }



    private void showDataList() {
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        eUserID = edtUserId.getText().toString();
        eAppId = edtAppID.getText().toString();
        eToken = edtToken.getText().toString();

        mainActivityViewModel.getDataList(path, eAppId, eUserID, eToken, Common.IP, Common.LOCALE, timeStamp, Common.OFFER_TYPES, hashKey).observe(this, getApiResponse -> {
            if (getApiResponse != null){
               setDataInAdapter(getApiResponse.getOffers());
                Log.d("Data", getApiResponse.getMessage());
            }
        });
    }


    private void setDataInAdapter(List<DataModel.Offer> offers) {
        if (!offers.isEmpty()){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new DataListAdapter(this, offers);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);

        }
    }

//    private boolean CheckAllFields() {
//        if (eAppid.length() == 0) {
//            eAppid.setError("This field is required");
//            return false;
//        }
//
//        if (eUserid.length() == 0) {
//            eUserid.setError("This field is required");
//            return false;
//        }
//
//        if (eToken.length() == 0) {
//            eToken.setError("Email is required");
//            return false;
//        }
//
//        return true;
//    }
}

