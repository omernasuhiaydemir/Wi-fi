package com.omernsh.wi_fi.ViewModel;



import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.widget.ListView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.omernsh.wi_fi.Model.Data;
import com.omernsh.wi_fi.Service.WifiReceiver;
import com.omernsh.wi_fi.Viev.MainActivity;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    MutableLiveData<ArrayList<Data>> LiveData;
    ArrayList<Data> dataArrayList;




    public MainViewModel() {

        LiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Data>> getUserMutableLiveData() {

        return LiveData;
    }

    public void init(){

        populateList();
        LiveData.setValue(dataArrayList);



    }

    public void populateList(){



        Data data = new Data("Turk Telekom","12:12:23:34:34","Low","High");



        dataArrayList = new ArrayList<>();
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);
        dataArrayList.add(data);


        WifiReceiver wifiReceiver = new WifiReceiver();

        if (wifiReceiver.deviceList != null){

            System.out.println("TTTTTTTTTTTTTTTTT TTT T  TT  T TT T " + wifiReceiver.deviceList);

        }else {

            System.out.println("LİSTE BOŞŞŞŞŞŞ");

        }





    }





}

