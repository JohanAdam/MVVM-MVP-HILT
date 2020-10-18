package com.nyan.ktmvvmhilt.di

import com.nyan.ktmvvmhilt.repository.MainRepository
import com.nyan.ktmvvmhilt.retrofit.NetworkMapper
import com.nyan.ktmvvmhilt.retrofit.NetworkService
import com.nyan.ktmvvmhilt.room.CacheMapper
import com.nyan.ktmvvmhilt.room.MangaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        dao: MangaDao,
        networkService: NetworkService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(dao, networkService, cacheMapper, networkMapper)
    }


}