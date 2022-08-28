package com.shayshab.dttaskapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.shayshab.dttaskapi.Adapter.DataListAdapter;
import com.shayshab.dttaskapi.Model.DataModel;
import com.shayshab.dttaskapi.ViewModel.MainActivityViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    RecyclerView recyclerView;
    DataListAdapter adapter;
    LinearLayoutManager layoutManager;
    EditText eAppid;
    EditText eUserid;
    EditText eToken;
    Button showData;
    //String appid = "2070";
    //String userid = "superman";
    String ip = "109.235.143.113";
    String locale = "DE";
    String offer_types = "112";
    //String token = "1c915e3b5d42d05136185030892fbb846c278927";
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        eAppid = findViewById(R.id.etappid);
        eUserid = findViewById(R.id.etuserid);
        eToken = findViewById(R.id.ettoken);
        showData = findViewById(R.id.btshowdata);
        recyclerView = findViewById(R.id.recyclerView);

        String appid =  eAppid.getText().toString();
        String userid = eUserid.getText().toString();
        String token = eToken.getText().toString();

        showData.setOnClickListener(view -> {

            isAllFieldsChecked = CheckAllFields();
            if(isAllFieldsChecked)
            {
                showDataList(token, appid, userid, ip, locale, offer_types);
            }



        });

    }

    private void showDataList(String token, String appid, String userid, String ip, String locale, String offer_types) {
        mainActivityViewModel.getDataList(token, appid, userid, ip, locale, offer_types).observe(this, dataModels -> {
            if (dataModels != null){
                setDataInAdapter(dataModels.getOffers());
            }
            else {
                Toast.makeText(this, "Data Not Found!!!", Toast.LENGTH_SHORT).show();
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

    private boolean CheckAllFields() {
        if (eAppid.length() == 0) {
            eAppid.setError("This field is required");
            return false;
        }

        if (eUserid.length() == 0) {
            eUserid.setError("This field is required");
            return false;
        }

        if (eToken.length() == 0) {
            eToken.setError("Email is required");
            return false;
        }

        return true;
    }
}

