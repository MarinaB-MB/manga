package com.lifecycle.start.manga.features.top.domain

import com.lifecycle.start.manga.core.data.RequestParameters
import com.lifecycle.start.manga.features.top.data.TitleType

data class MangaTopParameters(
    val type: TitleType,
    val page: Int = 0,
    val limit: Int = 50
) : RequestParameters {

    override fun toMap(): Map<String, String> {
        return mapOf(
            TYPE to type.value,
            PAGE to page.toString(),
            LIMIT to limit.toString()
        )
    }

    companion object {
        private const val TYPE = "type"
        private const val PAGE = "page"
        private const val LIMIT = "limit"
    }
}