package com.example.sarajevepublictransport.lines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sarajevepublictransport.R;
import com.example.sarajevepublictransport.vehicles.Vehicles;

import java.util.List;

public class TransportLineAdapter extends BaseAdapter {

    private List<TransportLines> transportLines;
    private Context context;

    public TransportLineAdapter(Context context, List<TransportLines> transportLines){
        this.context = context;
        this.transportLines = transportLines;
    }

    @Override
    public int getCount() {
        return transportLines.size();
    }

    @Override
    public Object getItem(int i) {
        return transportLines.get(i);
    }

    @Override
    public long getItemId(int i) {
        return transportLines.indexOf(transportLines.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.line_layout_item, viewGroup, false);
        TransportLines transportLine = (TransportLines) getItem(i);
        ImageView company_image = view.findViewById(R.id.company_image);
        TextView line_id = view.findViewById(R.id.line_id);
        TextView vehicle_id=view.findViewById(R.id.vehicle_id);
        TextView start_location = view.findViewById(R.id.start_location);
        TextView end_location = view.findViewById(R.id.end_location);

        Glide.with(context).load(transportLine.getCompany_logo()).into(company_image);
        line_id.setText(""+transportLine.getId());
        vehicle_id.setText(""+transportLine.getVehicle_id());
        start_location.setText(transportLine.getStart_destination());
        end_location.setText(transportLine.getEnd_destination());

        return view;
    }
}
