package com.omernsh.wi_fi.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.omernsh.wi_fi.Model.Data;

import java.util.ArrayList;
import java.util.List;


public class WifiReceiver extends BroadcastReceiver {
    WifiManager wifiManager;
    StringBuilder sb;
    ListView wifiDeviceList;
   public List<ScanResult> wifiList;

   public ArrayList<String> deviceList;
    public WifiReceiver(WifiManager wifiManager, ListView wifiDeviceList) {
        this.wifiManager = wifiManager;
        this.wifiDeviceList = wifiDeviceList;
    }

    public WifiReceiver() {

    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            sb = new StringBuilder();
            wifiList = wifiManager.getScanResults();
             deviceList = new ArrayList<>();
            for (ScanResult scanResult : wifiList) {


                sb.append("\n").append(scanResult.SSID).append(" - ").append(scanResult.capabilities);


                deviceList.add(scanResult.SSID + " - " + scanResult.capabilities);

               // System.out.println("VİEW MODELDEN DEVİCELİST "+ deviceList);







              /*  String wifi_adı = scanResult.SSID;
                System.out.println( "Wifi adları  "+ (wifi_adı));

                int streght_int_diğer = WifiManager.calculateSignalLevel(scanResult.level, 5);
                System.out.println("Diğer wifiler 5 üzerinden " + streght_int_diğer );


                int rssi = wifiManager.getConnectionInfo().getRssi();
                int level = WifiManager.calculateSignalLevel(rssi, 5);
                System.out.println("Aktif wifi 5 üzerinden " + level );

                streght_str = String.valueOf(level);


                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null) {
                    Integer linkSpeed = wifiInfo.getLinkSpeed();
                    System.out.println("Wifi hızı " + String.valueOf(linkSpeed) );
                     link_speed = String.valueOf(linkSpeed);

                }


               */





            }

        }
    }
}