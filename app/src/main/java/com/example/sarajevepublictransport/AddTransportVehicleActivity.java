package com.example.sarajevepublictransport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sarajevepublictransport.vehicles.Vehicles;

public class AddTransportVehicleActivity extends AppCompatActivity {

    EditText name, type, date;
    Button reg, non_reg;
    TextView add;
    View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transport_vehicle);

        final boolean[] regVal = {true};

        name = findViewById(R.id.vehicle_name);
        type = findViewById(R.id.vehicle_type);
        date = findViewById(R.id.registed_date);
        reg = findViewById(R.id.registed);
        non_reg = findViewById(R.id.notregisted);
        add = findViewById(R.id.add);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regVal[0] =true;
            }
        });
        non_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regVal[0] =false;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vehicles vehicle = new Vehicles(
                        name.getText().toString(),
                        type.getText().toString(),
                        date.getText().toString(),
                        regVal[0]
                );
                AppDB.getInstance(getApplicationContext()).vehicleDao().addVehicle(vehicle);
                finish();
            }
        });

    }
}