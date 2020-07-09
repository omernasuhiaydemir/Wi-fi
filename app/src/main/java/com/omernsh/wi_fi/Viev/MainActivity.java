package com.omernsh.wi_fi.Viev;


import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omernsh.wi_fi.Adapters.RecyclerViewAdapter;
import com.omernsh.wi_fi.Model.Data;
import com.omernsh.wi_fi.R;
import com.omernsh.wi_fi.Service.WifiReceiver;
import com.omernsh.wi_fi.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    private ListView wifiList;
    private WifiManager wifiManager;


    WifiReceiver receiverWifi;


    private List<Data> data_list;




    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    MainActivity context;
    MainViewModel viewModel;


    private final int MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        context = this;
        viewModel = ViewModelProviders.of(context).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);



        wifiList = findViewById(R.id.wifiList);
        Button buttonScan = findViewById(R.id.scanBtn);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);




        recyclerView = findViewById(R.id.recycler_view);
        viewModel = ViewModelProviders.of(context).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);


       /*   WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

// Level of a Scan Result
        List<ScanResult> wifiList = wifiManager.getScanResults();
        for (ScanResult scanResult : wifiList) {
            int level = WifiManager.calculateSignalLevel(scanResult.level, 5);
            System.out.println("Diğer wifiler 5 üzerinden " + level );
        }

// Level of current connection
        int rssi = wifiManager.getConnectionInfo().getRssi();
        int level = WifiManager.calculateSignalLevel(rssi, 5);
        System.out.println("Aktif wifi 5 üzerinden " + level );




        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo != null) {
            Integer linkSpeed = wifiInfo.getLinkSpeed();
            System.out.println("Wifi hızı " + String.valueOf(linkSpeed) );


        }

        System.out.println("Wifi MAC ADRES " +wifiInfo.getMacAddress() );


        */




        receiverWifi = new WifiReceiver(wifiManager, wifiList);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(receiverWifi, intentFilter);
        getWifi();










    }




    Observer<ArrayList<Data>> userListUpdateObserver = new Observer<ArrayList<Data>>() {
        @Override
        public void onChanged(ArrayList<Data> userArrayList) {
            recyclerViewAdapter = new RecyclerViewAdapter(context,userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    };

    private void getWifi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(MainActivity.this, "version> = marshmallow", Toast.LENGTH_SHORT).show();
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "location turned off", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
            } else {
                Toast.makeText(MainActivity.this, "location turned on", Toast.LENGTH_SHORT).show();
                wifiManager.startScan();
            }
        } else {
            Toast.makeText(MainActivity.this, "scanning", Toast.LENGTH_SHORT).show();
            wifiManager.startScan();
        }
    }



}