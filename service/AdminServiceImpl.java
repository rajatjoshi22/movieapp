package com.movieapp.service;
import com.movieapp.dao.AdminDao;
import com.movieapp.dao.AdminDaoImpl;
import com.movieapp.exception.IdNotFoundException;
import com.movieapp.model.Movie;

public class AdminServiceImpl implements AdminService{
	
	AdminDao movieDAO=new AdminDaoImpl();
	public String adminLogin(int loginid, String password) {
		return "Granted";
		
		
	}

	public void addMovie(Movie movie) {
		movieDAO.addOneMovie(movie);
		
	}

	public void deleteMovie(int movieid) throws IdNotFoundException {
		int result=movieDAO.deleteOneMovie(movieid);
		if(result==0)
			throw new IdNotFoundException("Invalid id");
		
	}

	public void updateMovie(int movieid, int price) throws IdNotFoundException {
		int result=movieDAO.updateOneMovie(movieid, price);
		if(result==0)
			throw new IdNotFoundException("Invalid id");
		}

	public Movie getMovieById(int movieid) throws IdNotFoundException {
		Movie movie = movieDAO.findMovieById(movieid);
		if(movie==null)
			throw new IdNotFoundException("Invalid ID");
		return movie;
	}
	
	

}
