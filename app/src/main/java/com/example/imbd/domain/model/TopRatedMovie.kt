package com.example.imbd.domain.model

import java.io.Serializable


data class TopRatedMovie (
    var adult: Boolean?= null,
    var backdrop_path: String?= null,
    var genre_ids: List<Int>?= listOf(),
    var id: Int?= null,
    var original_language: String?= null,
    var original_title: String?= null,
    var overview: String?= null,
    var popularity: Double?= null,
    var poster_path: String?= null,
    var release_date: String?= null,
    var title: String?= null,
    var video: Boolean?= null,
    var vote_average: Double?= null,
    var vote_count: Long?= null,
): Serializable