package com.omernsh.wi_fi.Adapters;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.omernsh.wi_fi.Model.Data;
import com.omernsh.wi_fi.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<Data> wifi_list;

    public RecyclerViewAdapter(Activity context, ArrayList<Data> wifi_list) {
        this.context = context;
        this.wifi_list = wifi_list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Data data = wifi_list.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;

        viewHolder.tv_name.setText(data.getName());
        viewHolder.tv_mac.setText(data.getMac());
        viewHolder.tv_streght.setText(data.getStreght());
        viewHolder.tv_speed.setText(data.getSpeed());
    }

    @Override
    public int getItemCount() {
        return wifi_list.size();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {


        TextView tv_name;
        TextView tv_mac;
        TextView tv_streght;
        TextView tv_speed;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_name = itemView.findViewById(R.id.tv_wifi_name);
            tv_mac = itemView.findViewById(R.id.tv_mac);
            tv_streght = itemView.findViewById(R.id.tv_streght);
            tv_speed = itemView.findViewById(R.id.tv_speed);


        }
    }
}