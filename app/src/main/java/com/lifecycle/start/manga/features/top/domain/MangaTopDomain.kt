package com.lifecycle.start.manga.features.top.domain

import com.lifecycle.start.manga.features.top.presentation.MangaTopUiState
import com.lifecycle.start.manga.features.top.presentation.MangaTopUiStateItem

data class MangaTopDomain(val list: List<MangaTopDomainItem>) {
    fun <T> map(mapper: Mapper<T>): T = mapper.map(list)

    interface Mapper<T> {
        fun map(data: List<MangaTopDomainItem>): T

        class ToUi(private val mapper: MangaTopDomainItem.Mapper<MangaTopUiStateItem>) : Mapper<MangaTopUiState> {
            override fun map(data: List<MangaTopDomainItem>): MangaTopUiState {
                return MangaTopUiState.Success(data.map { it.map(mapper) })
            }
        }
    }
}

