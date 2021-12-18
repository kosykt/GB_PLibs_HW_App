package com.example.gb_plibs_hw_app.di.modules.data

import android.content.Context
import androidx.room.Room
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.RoomCacheRepoDetails
import com.example.gb_plibs_hw_app.data.db.RoomCacheUserDetails
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "database.db"

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun db(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun roomCacheRepoDetails(
        db: AppDatabase
    ): RoomCacheRepoDetails {
        return RoomCacheRepoDetails(db)
    }

    @Singleton
    @Provides
    fun roomCacheUserDetails(
        db: AppDatabase
    ): RoomCacheUserDetails {
        return RoomCacheUserDetails(db)
    }
}