package com.shayshab.dttaskapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.shayshab.dttaskapi.Adapter.DataListAdapter;
import com.shayshab.dttaskapi.ViewModel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    RecyclerView recyclerView;
    DataListAdapter adapter;
    LinearLayoutManager layoutManager;
    String appid = "2070";
    String userid = "superman";
    String ip = "109.235.143.113";
    String locale = "DE";
    String offer_types = "112";
    String token = "1c915e3b5d42d05136185030892fbb846c278927";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);


        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        mainActivityViewModel.getDataList(token, appid, userid, ip, locale, offer_types).observe(this, dataModels -> {


                    if (dataModels != null){
                        //adapter = new MovieListAdapter(this , (List<MovieModel.Offer>) movieModels);
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
                });




    }
}