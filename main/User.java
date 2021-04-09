package com.movieapp.main;

import java.util.List;
import java.util.Scanner;

import com.movieapp.exception.InvalidUserException;
import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.MovieModel;
import com.movieapp.service.MovieServiceImple;
import com.movieapp.service.UserServiceImple;

public class User {

	public User() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1-Log In\n2- Sign Up");
		int opt = sc.nextInt();

		if (opt == 1) {
			UserServiceImple userService = new UserServiceImple();

			sc.nextLine();
			System.out.println("Enter log in id:");
			String loginId = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();

			try {
				userService.login(loginId, password);

				System.out.println("Enter name to search for movie:");
				String name = sc.nextLine();

				MovieServiceImple movieService = new MovieServiceImple();

				List<MovieModel> movies;
				movies = movieService.getMoviesByName(name);

				for (MovieModel movie : movies) {
					System.out.println(movie.getName());
					System.out.println(movie.getDirector());
					System.out.println(movie.getPrice());
				}

			} catch (InvalidUserException e) {
				e.printStackTrace();
			} catch (MovieNotFoundException e) {
				e.printStackTrace();
			}
			sc.close();
		} else if (opt == 2) {
			//
		}
	}

}
