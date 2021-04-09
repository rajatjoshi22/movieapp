package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.Admin;
import com.movieapp.model.Movie;

public interface AdminDao {
	void oneAdminSignUp(Admin admin) ;
	Admin oneAdminLogin(String loginId,String password);
	void addOneMovie(Movie movie);
	int updateOneMovie(int movieId,double price);
	int deleteOneMovie(int movieId);
	List<Movie> findAllMovie();
}
