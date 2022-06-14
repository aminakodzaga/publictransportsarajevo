package com.example.sarajevepublictransport.users;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sarajevepublictransport.lines.TransportLines;

@Dao
public interface UsersDao {

    @Insert
    public void addUser(User user);

    @Query("SELECT users.id FROM users WHERE email=(:email) LIMIT 1")
    int getUserIdByEmail(String email);

    @Query("SELECT * FROM users WHERE email=(:email) AND password=(:password) LIMIT 1")
    User checkLogin(String email, String password);


}
