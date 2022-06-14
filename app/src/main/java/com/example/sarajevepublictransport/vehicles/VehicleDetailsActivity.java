package com.example.sarajevepublictransport.vehicles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sarajevepublictransport.AppDB;
import com.example.sarajevepublictransport.R;
import com.example.sarajevepublictransport.lines.TransportLineDetailsActivity;
import com.example.sarajevepublictransport.lines.TransportLines;

public class VehicleDetailsActivity extends AppCompatActivity {

    TextView vehicle_id, vehicle_type, vehicle_manufacture_date, vehicle_registered;
    ImageView company_logo;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);

        back = findViewById(R.id.back);

        vehicle_id= findViewById(R.id.vehicle_id_value);
        vehicle_type = findViewById(R.id.vehicle_type_value);
        vehicle_manufacture_date = findViewById(R.id.vehicle_manufacture_date_value);
        vehicle_registered = findViewById(R.id.vehicle_registered_value);
        company_logo = findViewById(R.id.company_logo);

        int id = getIntent().getIntExtra("vehicle_id",-1);

        if(id!=-1){
            Vehicles vehicle = AppDB.getInstance(this).vehicleDao().getVehicleById(id);

            if(vehicle!=null){
                Glide.with(this).load(vehicle.getVehicle_image_url()).into(company_logo);
                vehicle_id.setText(""+vehicle.getVehicle_id());
                vehicle_type.setText(vehicle.getVehicle_type());
                vehicle_manufacture_date.setText(vehicle.getVehicle_manufacture_date());
                if(vehicle.isVehicle_registered()){
                    vehicle_registered.setText("Registered");
                }else{
                    vehicle_registered.setText("Not registered");
                }
            }


        }
        back.setOnClickListener(view -> {
            finish();
        });
    }
}