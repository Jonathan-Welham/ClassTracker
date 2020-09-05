package com.example.classtracker.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities={User.class, Course.class}, version=1)
@TypeConverters({DateTypeConverter.class})

public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public abstract DAO dao();

    public static AppDataBase getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "AppDataBase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
