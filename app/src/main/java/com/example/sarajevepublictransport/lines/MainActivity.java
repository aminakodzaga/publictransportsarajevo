package com.example.sarajevepublictransport.lines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sarajevepublictransport.AddTransportLineActivity;
import com.example.sarajevepublictransport.AppDB;
import com.example.sarajevepublictransport.R;
import com.example.sarajevepublictransport.vehicles.VehiclesActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ImageView back;
    TextView vehicles;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.lines_list);
        back = findViewById(R.id.back);
        vehicles = findViewById(R.id.vehicles);
        add=findViewById(R.id.add);

        List<TransportLines> transportLines = AppDB.getInstance(this).transportLinesDao().getAll();
        TransportLineAdapter adapter = new TransportLineAdapter(this, transportLines);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            TransportLines transportLine = (TransportLines) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(getApplicationContext(), TransportLineDetailsActivity.class);
            intent.putExtra("transport_line_id", transportLine.getId());
            startActivity(intent);
        });

        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VehiclesActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(view -> {
            finish();
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddTransportLineActivity.class);
                startActivity(intent);
            }
        });
    }
}