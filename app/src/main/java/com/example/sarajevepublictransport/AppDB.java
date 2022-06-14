package com.example.sarajevepublictransport;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sarajevepublictransport.lines.TransportLines;
import com.example.sarajevepublictransport.lines.TransportLinesDao;
import com.example.sarajevepublictransport.users.User;
import com.example.sarajevepublictransport.users.UsersDao;
import com.example.sarajevepublictransport.vehicles.Vehicles;
import com.example.sarajevepublictransport.vehicles.VehiclesDao;

@Database(entities={Vehicles.class, User.class, TransportLines.class},version=1,exportSchema = false)
public abstract class AppDB extends RoomDatabase {

    public abstract VehiclesDao vehicleDao();
    public abstract UsersDao usersDao();
    public abstract TransportLinesDao transportLinesDao();

    public static AppDB INSTANCE = null;

    public static AppDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDB.class, "app_db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}