package com.nyan.ktmvvmhilt.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Class that model that data that come from API calls.
 * Exclusively model for Retrofit API calls.
 */

data class MangaListNetworkEntity(
    @SerializedName("result")
    @Expose
    var result: List<MangaNetworkEntity>
)

data class MangaNetworkEntity(

    @SerializedName("mal_id")
    @Expose
    var id: Int,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("image_url")
    @Expose
    var imageUrl: String,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("airing")
    @Expose
    var airing: String,

    @SerializedName("synopsis")
    @Expose
    var synopsis: String,

    @SerializedName("type")
    @Expose
    var type: String,

    @SerializedName("episode")
    @Expose
    var episode: Int,

    @SerializedName("rated")
    @Expose
    var rated: String

    )
