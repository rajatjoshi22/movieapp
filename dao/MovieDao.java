package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.Movie;

public interface MovieDao {
	List<Movie> findMovieByCity(String city) ;
	List<Movie> findMovieByPrice() ;
	List<Movie> findMovieByRatings() ;
	List<Movie> findMovieByActor(String actor) ;
	List<Movie> findMovieByActress(String actress) ;
	List<Movie> findMovieByTheatre(String theatre) ;
}
