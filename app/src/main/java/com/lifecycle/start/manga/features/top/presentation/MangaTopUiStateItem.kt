package com.lifecycle.start.manga.features.top.presentation

data class MangaTopUiStateItem(
    val title: String? = null,
    val score: Double,
    val image: String? = null,
    val chaptersCount: Int,
    val description: String? = null,
)