package com.movieapp.service;

import java.util.List;


import com.movieapp.exception.ActorNotFoundException;
import com.movieapp.exception.ActressNotFoundException;
import com.movieapp.exception.CategoryNotFoundException;
import com.movieapp.exception.CityNotFoundException;
import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.Movie;

public interface MovieService {
	
	List<Movie> getMovieByCity(String city) throws CityNotFoundException;
	List<Movie> getMovieByTheatre(String theatre) throws TheatreNotFoundException;
	List<Movie> getMovieByPrice(int price) throws TheatreNotFoundException;
	List<Movie> getMovieByDate(String date) throws TheatreNotFoundException;
	List<Movie> getMovieByCategory(String category) throws CategoryNotFoundException;
	List<Movie> getMovieByRating(int rating) throws MovieNotFoundException;
	List<Movie> getMovieByActor(String actor) throws ActorNotFoundException;
	List<Movie> getMovieByActress(String actress) throws ActressNotFoundException;

	
	
}
