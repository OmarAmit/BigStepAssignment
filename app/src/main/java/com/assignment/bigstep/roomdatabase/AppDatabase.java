package com.assignment.bigstep.roomdatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.assignment.bigstep.model.MusicDescDatabaseModel;


@Database(entities = {MusicDescDatabaseModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao taskDao();
}