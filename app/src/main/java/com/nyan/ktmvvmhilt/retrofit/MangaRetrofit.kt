package com.nyan.ktmvvmhilt.retrofit

import com.nyan.ktmvvmhilt.model.MangaList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaRetrofit {

    @GET("search/anime")
    suspend fun getAnimeList(
        @Query("rated") rated: String): MangaList

}