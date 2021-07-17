package com.assignment.bigstep.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.assignment.bigstep.model.MusicDescDatabaseModel;
import com.assignment.bigstep.roomdatabase.DatabaseDao;

import java.util.List;


public class HistoryRepository {
    private MutableLiveData<List<MusicDescDatabaseModel>> mutableLiveData = new MutableLiveData<>();
private DatabaseDao databaseDao;



    public HistoryRepository() {

    }



    public LiveData<List<MusicDescDatabaseModel>> getCategories() {
        return databaseDao.getAll();
    }
}
