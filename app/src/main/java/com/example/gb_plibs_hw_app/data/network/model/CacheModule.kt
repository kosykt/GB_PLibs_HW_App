package com.example.gb_plibs_hw_app.data.network.model

import android.content.Context
import androidx.room.Room
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import dagger.Module
import dagger.Provides

private const val DB_NAME = "database.db"

@Module
class CacheModule {

    @Provides
    fun db(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}