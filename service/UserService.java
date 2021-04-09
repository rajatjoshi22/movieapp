package com.movieapp.service;



import com.movieapp.exception.InvalidUserException;
import com.movieapp.model.User;


public interface UserService {
	
	void userLogin(int loginid,String password)throws InvalidUserException;
	void userSignup(User user);
	

}
