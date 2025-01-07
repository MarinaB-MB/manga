package com.lifecycle.start.manga.di

import com.lifecycle.start.manga.features.top.data.MangaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideMangaService(retrofit: Retrofit): MangaService {
        return retrofit.create(MangaService::class.java)
    }
}