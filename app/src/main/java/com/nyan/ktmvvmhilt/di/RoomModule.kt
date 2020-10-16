package com.nyan.ktmvvmhilt.di

import android.content.Context
import androidx.room.Room
import com.nyan.ktmvvmhilt.room.MangaDao
import com.nyan.ktmvvmhilt.room.MangaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule{

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): MangaDatabase {
        return Room.databaseBuilder(
            context,
            MangaDatabase::class.java,
            MangaDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: MangaDatabase): MangaDao {
        return database.mangaDao()
    }

}