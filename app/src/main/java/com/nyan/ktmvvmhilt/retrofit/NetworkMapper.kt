package com.nyan.ktmvvmhilt.retrofit

import com.nyan.ktmvvmhilt.model.Manga
import com.nyan.ktmvvmhilt.model.MangaList
import com.nyan.ktmvvmhilt.utils.EntityMapper
import javax.inject.Inject

/**
 * Responsible to map network obj to domain obj.
 */

class NetworkMapper

@Inject
constructor() : EntityMapper<MangaNetworkEntity, Manga> {
    override fun mapFromEntity(entity: MangaNetworkEntity): Manga {
        return Manga(
            id = entity.id,
            url = entity.url,
            image_url = entity.imageUrl,
            title = entity.title,
            airing = entity.airing,
            synopsis = entity.synopsis,
            type = entity.type,
            episode = entity.episode,
            rated = entity.rated
        )
    }

    override fun mapToEntity(domain: Manga): MangaNetworkEntity {
        return MangaNetworkEntity(
            id = domain.id,
            url = domain.url,
            imageUrl = domain.image_url,
            title = domain.title,
            airing = domain.airing,
            synopsis = domain.synopsis,
            type = domain.type,
            episode = domain.episode,
            rated = domain.rated
        )
    }

    fun mapFromEntityList(entities: List<MangaNetworkEntity>): List<Manga> {
        return entities.map { mapFromEntity(it) }
    }
}
