package com.movieapp.dao;


import com.movieapp.model.User;

public interface UserDao {
	User oneUserLogin(String loginId,String password) ;
	void oneUserSignUp(User user) ;
}
