package com.example.imbd.network.model

import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.domain.util.EntityMapper

class TopRatedMovieNetworkMapper: EntityMapper<TopRatedMovieNetworkEntity, TopRatedMovie> {
    override fun mapFromEntity(entity: TopRatedMovieNetworkEntity): TopRatedMovie {
        return  TopRatedMovie(
            adult = entity.adult,
            backdrop_path = entity.backdrop_path,
            genre_ids = entity.genre_ids?: listOf(),
            id= entity.id,
            original_language = entity.original_language,
            original_title = entity.original_title,
            overview = entity.overview,
            popularity = entity.popularity,
            poster_path = entity.poster_path,
            release_date = entity.release_date,
            title = entity.title,
            video = entity.video,
            vote_average=entity.vote_average,
            vote_count = entity.vote_count
        )
    }

    override fun mapToEntity(domainModel: TopRatedMovie): TopRatedMovieNetworkEntity {
        return TopRatedMovieNetworkEntity(
            adult = domainModel.adult,
            backdrop_path = domainModel.backdrop_path,
            genre_ids = domainModel.genre_ids,
            id= domainModel.id,
            original_language = domainModel.original_language,
            original_title = domainModel.original_title,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.poster_path,
            release_date = domainModel.release_date,
            title = domainModel.title,
            video = domainModel.video,
            vote_count = domainModel.vote_count
        )
    }

    fun fromEntityList(initial: List<TopRatedMovieNetworkEntity>): List<TopRatedMovie>{
        return  initial.map{ mapFromEntity(it)}
    }

    fun toEntityList(initial: List<TopRatedMovie>): List<TopRatedMovieNetworkEntity>{
        return initial.map{mapToEntity(it)}
    }
}