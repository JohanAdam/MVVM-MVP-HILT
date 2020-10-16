package com.nyan.ktmvvmhilt.room

import com.nyan.ktmvvmhilt.model.Manga
import com.nyan.ktmvvmhilt.model.MangaList
import com.nyan.ktmvvmhilt.retrofit.MangaNetworkEntity
import com.nyan.ktmvvmhilt.utils.EntityMapper
import javax.inject.Inject

class CacheMapper

@Inject
constructor(): EntityMapper<MangaCacheEntity, Manga> {
    override fun mapFromEntity(entity: MangaCacheEntity): Manga {
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

    override fun mapToEntity(domain: Manga): MangaCacheEntity {
        return MangaCacheEntity(
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

    fun mapFromEntityList(entities: List<MangaCacheEntity>): List<Manga> {
        return entities.map { mapFromEntity(it) }
    }

}