package com.lifecycle.start.manga.features.top.data

import javax.inject.Inject

interface MangaCloudDataSource {
    suspend fun fetchMangaTop(params: Map<String, String>): MangaTopResponse

    class Base @Inject constructor(
        private val service: MangaService
    ) : MangaCloudDataSource {

        override suspend fun fetchMangaTop(params: Map<String, String>): MangaTopResponse {
            return service.getTopManga(params)
        }
    }
}

