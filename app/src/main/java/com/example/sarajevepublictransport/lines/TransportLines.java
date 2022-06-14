package com.example.sarajevepublictransport.lines;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "transportlines")
public class TransportLines {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int vehicle_id;
    private String company_logo;
    private String start_destination;
    private String end_destination;

    @Ignore
    public TransportLines(int vehicle_id, String company_logo, String start_destination, String end_destination) {
        this.vehicle_id = vehicle_id;
        this.company_logo = company_logo;
        this.start_destination = start_destination;
        this.end_destination = end_destination;
    }


    public TransportLines(int id, int vehicle_id, String company_logo, String start_destination, String end_destination) {
        this.id = id;
        this.vehicle_id = vehicle_id;
        this.company_logo = company_logo;
        this.start_destination = start_destination;
        this.end_destination = end_destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getStart_destination() {
        return start_destination;
    }

    public void setStart_destination(String start_destination) {
        this.start_destination = start_destination;
    }

    public String getEnd_destination() {
        return end_destination;
    }

    public void setEnd_destination(String end_destination) {
        this.end_destination = end_destination;
    }
}
