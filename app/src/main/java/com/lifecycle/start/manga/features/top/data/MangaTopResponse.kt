package com.lifecycle.start.manga.features.top.data

import com.google.gson.annotations.SerializedName
import com.lifecycle.start.manga.core.data.BaseResponse
import com.lifecycle.start.manga.features.top.domain.MangaTopDomain
import com.lifecycle.start.manga.features.top.domain.MangaTopDomainItem

class MangaTopResponse(
    @SerializedName("data")
    val data: List<TopMangaData>,
    @SerializedName("pagination")
    val pagination: Pagination?
) : BaseResponse() {
    fun <T> map(mapper: Mapper<T>): T = mapper.map(data)

    interface Mapper<T> {
        fun map(data: List<TopMangaData>): T

        class ToDomain(private val mapper: TopMangaData.Mapper<MangaTopDomainItem>) : Mapper<MangaTopDomain> {
            override fun map(data: List<TopMangaData>): MangaTopDomain {
                return MangaTopDomain(data.map { it.map(mapper) })
            }
        }
    }
}

data class TopMangaData(
    @SerializedName("authors")
    val authors: List<Author?>?,
    @SerializedName("background")
    val background: String?,
    @SerializedName("chapters")
    val chapters: Int?,
    @SerializedName("genres")
    val genres: List<Genre?>?,
    @SerializedName("images")
    val images: Images?,
    val publishing: Boolean?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("scored")
    val scored: Double?,
    @SerializedName("scored_by")
    val scoredBy: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_english")
    val titleEnglish: String?,
    @SerializedName("title_japanese")
    val titleJapanese: String?,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String?>?,
    @SerializedName("titles")
    val titles: List<Title?>?,
    @SerializedName("synopsis")
    val synopsis: String?
) {
    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        title = title,
        score = score ?: 0.0,
        image = images?.jpg?.imageUrl,
        chaptersCount = chapters ?: 0,
        synopsis = synopsis
    )

    interface Mapper<T> {
        fun map(
            title: String?,
            score: Double,
            image: String?,
            chaptersCount: Int,
            synopsis: String?
        ): T

        class ToDomain() : Mapper<MangaTopDomainItem> {
            override fun map(
                title: String?,
                score: Double,
                image: String?,
                chaptersCount: Int,
                synopsis: String?
            ) = MangaTopDomainItem(
                title,
                score,
                image,
                chaptersCount,
                synopsis
            )
        }
    }
}

data class Pagination(
    @SerializedName("current_page")
    val currentPage: Int?,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean?,
    @SerializedName("items")
    val items: Items?,
    @SerializedName("last_visible_page")
    val lastVisiblePage: Int?
)

data class Author(
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

data class Genre(
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

data class Images(
    @SerializedName("jpg")
    val jpg: Jpg?,
    @SerializedName("webp")
    val webp: Webp?
)

data class Title(
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?
)

data class Jpg(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("large_image_url")
    val largeImageUrl: String?,
    @SerializedName("small_image_url")
    val smallImageUrl: String?
)

data class Webp(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("large_image_url")
    val largeImageUrl: String?,
    @SerializedName("small_image_url")
    val smallImageUrl: String?
)

data class From(
    @SerializedName("day")
    val day: Int?,
    @SerializedName("month")
    val month: Int?,
    @SerializedName("year")
    val year: Int?
)

data class Items(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total")
    val total: Int?
)