package com.lifecycle.start.manga.features.top.data

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MangaService {

    @GET(FETCH_MANGA_TOP)
    suspend fun getTopManga(@QueryMap parameters: Map<String, String>): MangaTopResponse

    companion object {
        const val FETCH_MANGA_TOP = "top/manga"
    }
}