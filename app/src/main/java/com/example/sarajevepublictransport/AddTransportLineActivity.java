package com.example.sarajevepublictransport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sarajevepublictransport.lines.TransportLines;
import com.example.sarajevepublictransport.vehicles.Vehicles;

import org.w3c.dom.Text;

public class AddTransportLineActivity extends AppCompatActivity {

    EditText veh_id, company_url, start, end;
    TextView add;
    View back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transport_line);

        veh_id = findViewById(R.id.vehicle_id);
        company_url = findViewById(R.id.company_image_url);
        start = findViewById(R.id.start_desination);
        end = findViewById(R.id.end_desination);
        add = findViewById(R.id.add);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransportLines transportLine = new TransportLines(
                        Integer.parseInt(veh_id.getText().toString()),
                        company_url.getText().toString(),
                        start.getText().toString(),
                        end.getText().toString()
                );
                AppDB.getInstance(getApplicationContext()).transportLinesDao().addLine(transportLine);
                finish();
            }
        });
    }
}