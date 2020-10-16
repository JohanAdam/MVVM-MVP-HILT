package com.nyan.ktmvvmhilt.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MangaCacheEntity::class], version = 1)
abstract class MangaDatabase: RoomDatabase() {

    abstract fun mangaDao(): MangaDao

    companion object {
        val DATABASE_NAME:String = "manga_db"
    }
}