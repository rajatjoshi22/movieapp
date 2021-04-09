package com.movieapp.service;

import java.util.List;


import com.movieapp.dao.MovieDao;
import com.movieapp.dao.MovieDaoImpl;
import com.movieapp.exception.ActorNotFoundException;
import com.movieapp.exception.ActressNotFoundException;
import com.movieapp.exception.CategoryNotFoundException;
import com.movieapp.exception.CityNotFoundException;
import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.Movie;

public class MovieServiceImpl implements MovieService{
	MovieDao movieDAO = new MovieDaoImpl();
	
	public List<Movie> getMovieByCity(String city) throws CityNotFoundException {
		
		List<Movie> movieList = movieDAO.findMovieByCity(city);
		if(movieList.isEmpty())
			throw new CityNotFoundException("Invalid City");
		return movieList;
		
		
	}

	public List<Movie> getMovieByTheatre(String theatre) throws TheatreNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByTheatre(theatre);
		if(movieList.isEmpty())
			throw new TheatreNotFoundException("Invalid Theater");
		return movieList;
	}

	public List<Movie> getMovieByPrice(int price) throws TheatreNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByPrice(price);
		if(movieList.isEmpty())
			throw new TheatreNotFoundException("Invalid Price");
		return movieList;
	}

	public List<Movie> getMovieByDate(String date) throws TheatreNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByDate(date);
		if(movieList.isEmpty())
			throw new TheatreNotFoundException("Invalid date");
		return movieList;
	}

	public List<Movie> getMovieByCategory(String category) throws CategoryNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByCategory(category);
		if(movieList.isEmpty())
			throw new CategoryNotFoundException("Invalid Category");
		return movieList;
	}

	public List<Movie> getMovieByRating(int rating) throws MovieNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByRating(rating);
		if(movieList.isEmpty())
			throw new MovieNotFoundException("Invalid Movie");
		return movieList;
	}

	public List<Movie> getMovieByActor(String actor) throws ActorNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByActor(actor);
		if(movieList.isEmpty())
			throw new ActorNotFoundException("Invalid Category");
		return movieList;
	}

	public List<Movie> getMovieByActress(String actress) throws ActressNotFoundException {
		List<Movie> movieList = movieDAO.findMovieByActress(actress);
		if(movieList.isEmpty())
			throw new ActressNotFoundException("Invalid actress");
		return movieList;
	}
	
	
	
}
