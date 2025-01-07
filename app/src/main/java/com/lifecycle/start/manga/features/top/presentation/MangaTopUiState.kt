package com.lifecycle.start.manga.features.top.presentation

import com.lifecycle.start.manga.core.presntation.UiState

sealed interface MangaTopUiState : UiState {

    class Success(private val mangaList: List<MangaTopUiStateItem>) : MangaTopUiState
    data object Loading : MangaTopUiState
    class Error(val message: String) : MangaTopUiState
}

