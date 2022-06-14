package com.example.sarajevepublictransport.vehicles;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface VehiclesDao {

    @Insert
    public void addVehicle(Vehicles vehicle);

    @Query("SELECT * FROM vehicles")
    List<Vehicles> getAll();

    @Query("SELECT * FROM vehicles WHERE vehicle_id=(:id)")
    Vehicles getVehicleById(long id);

    @Delete
    public void deleteProduct(Vehicles vehicle);

    @Update
    public void updateProduct(Vehicles vehicle);
}
