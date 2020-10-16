package com.nyan.ktmvvmhilt.model

/**
 * Domain Model.
 * Model exclusively for this project.
 * Retrofit entity model will convert to this model.
 */

data class MangaList(
    var result: List<Manga>
)

data class Manga(
    var id: String,
    val url: String,
    val image_url: String,
    val title: String,
    val airing: String,
    val synopsis: String,
    val type: String,
    val episode: Int,
    val rated: String
)

