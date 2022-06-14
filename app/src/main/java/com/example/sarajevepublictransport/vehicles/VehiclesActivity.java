package com.example.sarajevepublictransport.vehicles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sarajevepublictransport.AddTransportLineActivity;
import com.example.sarajevepublictransport.AddTransportVehicleActivity;
import com.example.sarajevepublictransport.AppDB;
import com.example.sarajevepublictransport.R;

import java.util.List;

public class VehiclesActivity extends AppCompatActivity {

    ListView listView;
    ImageView back;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        add = findViewById(R.id.add);
        listView=findViewById(R.id.product_list);
        back = findViewById(R.id.back);

        List<Vehicles> vehicles = AppDB.getInstance(this).vehicleDao().getAll();
        VehicleAdapter adapter = new VehicleAdapter(this, vehicles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Vehicles vehicles1 =(Vehicles) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(getApplicationContext(), VehicleDetailsActivity.class);
            intent.putExtra("vehicle_id", vehicles1.getVehicle_id());
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            finish();
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddTransportVehicleActivity.class);
                startActivity(intent);
            }
        });
    }
}