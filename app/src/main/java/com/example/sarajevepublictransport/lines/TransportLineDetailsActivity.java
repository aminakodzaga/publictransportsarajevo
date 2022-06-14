package com.example.sarajevepublictransport.lines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sarajevepublictransport.AppDB;
import com.example.sarajevepublictransport.R;
import com.example.sarajevepublictransport.vehicles.VehicleDetailsActivity;

import java.util.List;

public class TransportLineDetailsActivity extends AppCompatActivity {

    TextView vehicle_id, start, end;
    Button vehicle_info;
    ImageView company_logo, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_line_details);

        back = findViewById(R.id.back);
        vehicle_id = findViewById(R.id.vehicle_id_value);
        start = findViewById(R.id.start_value);
        end = findViewById(R.id.end_value);
        vehicle_info = findViewById(R.id.vehicle_info);
        company_logo = findViewById(R.id.company_logo);

        int id = getIntent().getIntExtra("transport_line_id",-1);

        if(id!=-1){
            TransportLines transportLine = AppDB.getInstance(this).transportLinesDao().getTransportLineById(id);

            vehicle_id.setText(""+transportLine.getVehicle_id());
            start.setText(transportLine.getStart_destination());
            end.setText(transportLine.getEnd_destination());
            Glide.with(this).load(transportLine.getCompany_logo()).into(company_logo);

            vehicle_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(TransportLineDetailsActivity.this, VehicleDetailsActivity.class);
                    intent.putExtra("vehicle_id", transportLine.getVehicle_id());
                    startActivity(intent);

                }
            });
        }

        back.setOnClickListener(view -> {
            finish();
        });
    }
}