package com.nyan.ktmvvmhilt.repository

import com.nyan.ktmvvmhilt.di.RetrofitModule
import com.nyan.ktmvvmhilt.model.Manga
import com.nyan.ktmvvmhilt.retrofit.NetworkMapper
import com.nyan.ktmvvmhilt.retrofit.NetworkService
import com.nyan.ktmvvmhilt.room.CacheMapper
import com.nyan.ktmvvmhilt.room.MangaDao
import com.nyan.ktmvvmhilt.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import java.lang.Exception

class MainRepository

constructor(
    private val mangaDao: MangaDao,
    private val networkService: NetworkService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper) {

    suspend fun getManga(): Flow<DataState<List<Manga>>> = flow {
        //Show loading.
        emit(DataState.Loading)

        //Show dummy delay.
        delay(1000)

        try {
            //Get from network.
            val networkManga = networkService.getAnimeList("g")
            //Convert network model > domain model.
            val mangas = networkMapper.mapFromEntityList(networkManga)
            //Insert to db one by one.
            for (manga in mangas) {
                mangaDao.insert(cacheMapper.mapToEntity(manga))
            }
            //Get all the saved data in db.
            val cacheMangas = mangaDao.getAll()
            //Show success with saved data.
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheMangas)))
        } catch (e: Exception) {
            //Show error.
            emit(DataState.Error(e))
        }
    }

}