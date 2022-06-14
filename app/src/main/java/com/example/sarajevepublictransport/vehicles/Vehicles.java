package com.example.sarajevepublictransport.vehicles;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "vehicles")
public class Vehicles {
    @PrimaryKey(autoGenerate = true)
    private int vehicle_id;

    private String vehicle_image_url;
    private String vehicle_type;
    private String vehicle_manufacture_date;
    private boolean vehicle_registered;

    @Ignore
    public Vehicles(String vehicle_image_url, String vehicle_type, String vehicle_manufacture_date, boolean vehicle_registered) {
        this.vehicle_image_url = vehicle_image_url;
        this.vehicle_type = vehicle_type;
        this.vehicle_manufacture_date = vehicle_manufacture_date;
        this.vehicle_registered = vehicle_registered;
    }

    public Vehicles(int vehicle_id, String vehicle_image_url, String vehicle_type, String vehicle_manufacture_date,
                    boolean vehicle_registered) {
        this.vehicle_id = vehicle_id;
        this.vehicle_image_url = vehicle_image_url;
        this.vehicle_type = vehicle_type;
        this.vehicle_manufacture_date = vehicle_manufacture_date;
        this.vehicle_registered = vehicle_registered;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_manufacture_date() {
        return vehicle_manufacture_date;
    }

    public void setVehicle_manufacture_date(String vehicle_manufacture_date) {
        this.vehicle_manufacture_date = vehicle_manufacture_date;
    }

    public boolean isVehicle_registered() {
        return vehicle_registered;
    }

    public void setVehicle_registered(boolean vehicle_registered) {
        this.vehicle_registered = vehicle_registered;
    }

    public String getVehicle_image_url() {
        return vehicle_image_url;
    }

    public void setVehicle_image_url(String vehicle_image_url) {
        this.vehicle_image_url = vehicle_image_url;
    }
}


