package com.example.gb_plibs_hw_app.di.modules.data

import android.content.Context
import androidx.room.Room
import com.example.gb_plibs_hw_app.data.db.AppDatabase
import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheRepoDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUserDetailsRepositoryImpl
import com.example.gb_plibs_hw_app.data.db.cache.RoomCacheUsersListRepositoryImpl
import com.example.gb_plibs_hw_app.data.repository.repodetails.repository.RoomCacheRepoDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.userdetails.repository.RoomCacheUserDetailsRepository
import com.example.gb_plibs_hw_app.data.repository.users.repository.RoomCacheUsersListRepository
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
    ): RoomCacheRepoDetailsRepository {
        return RoomCacheRepoDetailsRepositoryImpl(db)
    }

    @Singleton
    @Provides
    fun roomCacheUserDetails(
        db: AppDatabase
    ): RoomCacheUserDetailsRepository {
        return RoomCacheUserDetailsRepositoryImpl(db)
    }

    @Singleton
    @Provides
    fun roomCacheUsersList(
        db: AppDatabase
    ): RoomCacheUsersListRepository {
        return RoomCacheUsersListRepositoryImpl(db)
    }
}