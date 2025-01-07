package com.lifecycle.start.manga.di

import com.lifecycle.start.manga.features.top.data.MangaCloudDataSource
import com.lifecycle.start.manga.features.top.data.MangaRepository
import com.lifecycle.start.manga.features.top.domain.MangaInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MangaModule {

    @Binds
    @Singleton
    abstract fun bindMangaInteractor(impl: MangaInteractor.Base): MangaInteractor

    @Binds
    @Singleton
    abstract fun bindMangaRepository(impl: MangaRepository.Base): MangaRepository

    @Binds
    @Singleton
    abstract fun bindMangaCloudDataSource(impl: MangaCloudDataSource.Base): MangaCloudDataSource
}