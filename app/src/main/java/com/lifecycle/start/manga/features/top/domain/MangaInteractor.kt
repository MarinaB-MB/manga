package com.lifecycle.start.manga.features.top.domain

import com.lifecycle.start.manga.features.top.data.MangaRepository
import com.lifecycle.start.manga.features.top.data.TitleType
import com.lifecycle.start.manga.features.top.presentation.MangaTopUiState
import javax.inject.Inject

interface MangaInteractor {
    suspend fun fetchMangaTop(
        type: TitleType,
        page: Int,
        limit: Int
    ): MangaTopUiState

    class Base @Inject constructor(
        private val repository: MangaRepository,
        private val mapperTopToUi: MangaTopDomain.Mapper<MangaTopUiState>
    ) : MangaInteractor {
        override suspend fun fetchMangaTop(
            type: TitleType,
            page: Int,
            limit: Int
        ): MangaTopUiState {
            return repository.fetchMangaTop(type, page, limit).map(mapperTopToUi)
        }
    }
}