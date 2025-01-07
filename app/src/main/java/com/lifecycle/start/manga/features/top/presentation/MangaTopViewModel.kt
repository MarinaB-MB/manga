package com.lifecycle.start.manga.features.top.presentation

import androidx.lifecycle.viewModelScope
import com.lifecycle.start.manga.core.domain.Dispatchers
import com.lifecycle.start.manga.core.presntation.BaseViewModel
import com.lifecycle.start.manga.features.top.domain.MangaInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaTopViewModel @Inject constructor(
    private val mangaInteractor: MangaInteractor,
    dispatchers: Dispatchers
) : BaseViewModel(dispatchers) {

    private val _uiState: MutableStateFlow<MangaTopUiState> = MutableStateFlow(MangaTopUiState.Loading)
    val uiState: StateFlow<MangaTopUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch { fetchData() }
    }

    private suspend fun fetchData() {
        // todo
    }
}
