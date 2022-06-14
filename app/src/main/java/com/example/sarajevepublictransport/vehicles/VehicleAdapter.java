package com.example.sarajevepublictransport.vehicles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sarajevepublictransport.R;

import java.util.List;

public class VehicleAdapter extends BaseAdapter {

    private List<Vehicles> vehiclesList;
    private Context context;

    public VehicleAdapter(Context context, List<Vehicles> vehiclesList){
        this.context = context;
        this.vehiclesList = vehiclesList;
    }

    @Override
    public int getCount() {
        return vehiclesList.size();
    }

    @Override
    public Object getItem(int i) {
        return vehiclesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return vehiclesList.indexOf(vehiclesList.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.vehicle_layout_item, viewGroup, false);
        Vehicles vehicle = (Vehicles) getItem(i);
        ImageView vehicle_image = view.findViewById(R.id.vehicle_image);
        TextView vehicle_id = view.findViewById(R.id.vehicle_id);
        TextView vehicle_manufacture_date=view.findViewById(R.id.vehicle_manufacture_date);
        TextView vehicle_type = view.findViewById(R.id.vehicle_type);
        TextView vehicle_registered = view.findViewById(R.id.vehicle_registered);

        Glide.with(context).load(vehicle.getVehicle_image_url()).into(vehicle_image);
        vehicle_id.setText(""+vehicle.getVehicle_id());
        vehicle_manufacture_date.setText(vehicle.getVehicle_manufacture_date());
        vehicle_type.setText(vehicle.getVehicle_type());
        if(vehicle.isVehicle_registered()){
            vehicle_registered.setText("Registered");
        }else{
            vehicle_registered.setText("Not registered");
        }
        return view;
    }
}