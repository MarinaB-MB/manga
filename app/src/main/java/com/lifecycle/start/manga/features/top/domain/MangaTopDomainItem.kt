package com.lifecycle.start.manga.features.top.domain

import com.lifecycle.start.manga.features.top.presentation.MangaTopUiStateItem

data class MangaTopDomainItem(
    val title: String? = null,
    val score: Double,
    val image: String? = null,
    val chaptersCount: Int,
    val description: String? = null
) {
    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        title,
        score,
        image,
        chaptersCount,
        description
    )

    interface Mapper<T> {
        fun map(
            data: String?,
            score: Double,
            image: String?,
            chaptersCount: Int,
            description: String?
        ): T

        class ToUi : Mapper<MangaTopUiStateItem> {
            override fun map(
                data: String?,
                score: Double,
                image: String?,
                chaptersCount: Int,
                description: String?
            ): MangaTopUiStateItem {
                return MangaTopUiStateItem(data, score, image, chaptersCount, description)
            }
        }
    }
}