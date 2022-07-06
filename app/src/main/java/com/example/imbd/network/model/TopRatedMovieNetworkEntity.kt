package com.example.imbd.network.model

import com.google.gson.annotations.SerializedName

class TopRatedMovieNetworkEntity (
    @SerializedName("adult")
    var adult: Boolean?= null,

    @SerializedName("backdrop_path")
    var backdrop_path: String?= null,

    @SerializedName("genre_ids")
    var genre_ids: List<Int>?= null,

    @SerializedName("id")
    var id: Int?= null,

    @SerializedName("original_language")
    var original_language: String?= null,

    @SerializedName("original_title")
    var original_title: String?= null,

    @SerializedName("overview")
    var overview: String?= null,

    @SerializedName("popularity")
    var popularity: Double?= null,

    @SerializedName("poster_path")
    var poster_path: String?= null,

    @SerializedName("release_date")
    var release_date: String?= null,

    @SerializedName("title")
    var title: String?= null,

    @SerializedName("video")
    var video: Boolean?= null,

    @SerializedName("vote_average")
    var vote_average: Double?= null,

    @SerializedName("vote_count")
    var vote_count: Long?= null,



)