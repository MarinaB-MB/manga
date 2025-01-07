package com.lifecycle.start.manga.di

import com.lifecycle.start.manga.features.top.data.MangaTopResponse
import com.lifecycle.start.manga.features.top.data.TopMangaData
import com.lifecycle.start.manga.features.top.domain.MangaTopDomain
import com.lifecycle.start.manga.features.top.domain.MangaTopDomainItem
import com.lifecycle.start.manga.features.top.presentation.MangaTopUiState
import com.lifecycle.start.manga.features.top.presentation.MangaTopUiStateItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    @Singleton
    fun provideMangaTopResponseToDomainItem(): TopMangaData.Mapper<MangaTopDomainItem> = TopMangaData.Mapper.ToDomain()

    @Provides
    @Singleton
    fun provideMangaTopResponseToDomain(itemMapper: TopMangaData.Mapper<MangaTopDomainItem>): MangaTopResponse.Mapper<MangaTopDomain> =
        MangaTopResponse.Mapper.ToDomain(itemMapper)

    @Provides
    @Singleton
    fun provideMangaTopResponseToUiItem(): MangaTopDomainItem.Mapper<MangaTopUiStateItem> =
        MangaTopDomainItem.Mapper.ToUi()

    @Provides
    @Singleton
    fun provideMangaTopDomainToUi(itemMapper: MangaTopDomainItem.Mapper<MangaTopUiStateItem>): MangaTopDomain.Mapper<MangaTopUiState> =
        MangaTopDomain.Mapper.ToUi(itemMapper)
}