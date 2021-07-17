package com.assignment.bigstep.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.assignment.bigstep.model.MusicDescDatabaseModel;

import java.util.List;

@Dao
public interface DatabaseDao {
/*Select everthing fromt able*/
    @Query("SELECT * FROM MusicDescDatabaseModel")
     LiveData<List<MusicDescDatabaseModel>> getAll();

    /*Select everthing fromt able*/
    @Insert
    void insert(MusicDescDatabaseModel musicDescDatabaseModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllOrders(List<MusicDescDatabaseModel> products);

    @Query("DELETE FROM MusicDescDatabaseModel WHERE id = :id")
    void delete(Integer id);

}