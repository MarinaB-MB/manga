package com.lifecycle.start.manga.features.top.data

import com.lifecycle.start.manga.features.top.domain.MangaTopDomain
import com.lifecycle.start.manga.features.top.domain.MangaTopParameters
import javax.inject.Inject

interface MangaRepository {
    suspend fun fetchMangaTop(
        type: TitleType,
        page: Int,
        limit: Int
    ): MangaTopDomain

    class Base @Inject constructor(
        private val cloudDataSource: MangaCloudDataSource,
        private val mapperToDomain: MangaTopResponse.Mapper<MangaTopDomain>
    ) : MangaRepository {
        override suspend fun fetchMangaTop(
            type: TitleType,
            page: Int,
            limit: Int
        ): MangaTopDomain {
            val params = MangaTopParameters(type, page, limit)
            return cloudDataSource.fetchMangaTop(params.toMap()).map(mapperToDomain)
        }
    }
}

