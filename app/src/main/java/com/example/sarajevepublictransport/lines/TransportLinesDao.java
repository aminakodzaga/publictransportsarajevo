package com.example.sarajevepublictransport.lines;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sarajevepublictransport.vehicles.Vehicles;

import java.util.List;

@Dao
public interface TransportLinesDao {

    @Insert
    public void addLine(TransportLines transportLine);

    @Query("SELECT * FROM transportlines")
    List<TransportLines> getAll();

    @Query("SELECT * FROM transportlines WHERE id=(:id)")
    TransportLines getTransportLineById(long id);

    @Delete
    public void deleteLine(TransportLines transportLine);

    @Update
    public void updateLine(TransportLines transportLine);
}
