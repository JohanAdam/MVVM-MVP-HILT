package com.nyan.ktmvvmhilt.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MangaDao  {

    //Return rows number OR -1 if failed.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mangaEntity: MangaCacheEntity): Long

    @Query("SELECT * FROM mangas")
    suspend fun getAll(): List<MangaCacheEntity>

}