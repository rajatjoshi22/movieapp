package com.movieapp.service;

import com.movieapp.exception.IdNotFoundException;
import com.movieapp.model.Admin;
import com.movieapp.model.Movie;

public interface AdminService {
	
	String adminLogin(int loginid,String password);
	
	void addMovie(Movie movie);
	void deleteMovie(int movieid)throws IdNotFoundException;
	void updateMovie(int movieid,int price)throws IdNotFoundException;
	Movie getMovieById(int movieid) throws IdNotFoundException;
	

}
