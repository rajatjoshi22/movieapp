package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.movieapp.model.Movie;

public class MovieDaoImpl implements MovieDao {
     PreparedStatement statement=null;
     List<Movie> movieByCity=new ArrayList<>();
     Scanner src=new Scanner(System.in);
	@Override
	public List<Movie> findMovieByCity(String city){
		// TODO Auto-generated method stub
		String sql="Select * from onlinemovie where city=?";
		Connection connection=DBConnection.openConnection();
		
		try {
			statement=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1,city);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				 String movieName=rs.getString(1);
				 Integer ratings=rs.getInt(2);
				 Integer movieId=rs.getInt(3);
				String language=rs.getString(4);
				 String category=rs.getString(5);
				String director=rs.getString(6);
			   String actor=rs.getString(7);
              String actress=rs.getString(8);
			  String date=rs.getString(9);
			  Double price=rs.getDouble(10);
				String theatre=rs.getString(12);
			Movie movie =new Movie(movieName,ratings,movieId,language,category,director,actor,actress,date,price,city,theatre);
			movieByCity.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieByCity;
		
	}

	@Override
	public List<Movie> findMovieByPrice() {
		// TODO Auto-generated method stub
		List<Movie> byPrice=new ArrayList<>();
		System.out.println("High to low type(h) || low to high type(l)");
		String choice=src.next();
		if(choice.equals("l"))
		{
		byPrice=movieByCity.stream().sorted((mov1,mov2)->mov1.getPrice().compareTo(mov2.getPrice())).collect(Collectors.toList());
		}
		else {
			byPrice=movieByCity.stream().sorted((mov1,mov2)->mov2.getPrice().compareTo(mov1.getPrice())).collect(Collectors.toList());
		}
		return byPrice;
	}

	@Override
	public List<Movie> findMovieByRatings() {
		// TODO Auto-generated method stub
		List<Movie> byRatings=new ArrayList<>();
		System.out.println("High to low type(h) || low to high type(l)");
		String choice=src.next();
		if(choice.equals("l")) {
		byRatings= movieByCity.stream().sorted((mov1,mov2)->mov1.getRatings().compareTo(mov2.getRatings())).collect(Collectors.toList());
		}
		else {
			byRatings=movieByCity.stream().sorted((mov1,mov2)->mov2.getRatings().compareTo(mov1.getRatings())).collect(Collectors.toList());
		}
		return byRatings;
	}

	@Override
	public List<Movie> findMovieByActor(String actor) {
		// TODO Auto-generated method stub
		List<Movie> byActor= movieByCity.stream().filter((mov)->mov.getActor().equals(actor)).sorted((mov1,mov2)->mov1.getMovieName().compareTo(mov2.getMovieName())).collect(Collectors.toList());
	    return byActor;
	}

	@Override
	public List<Movie> findMovieByActress(String actress) {
		// TODO Auto-generated method stub
		List<Movie> byActress= movieByCity.stream().filter((mov)->mov.getActress().equals(actress)).sorted((mov1,mov2)->mov1.getMovieName().compareTo(mov2.getMovieName())).collect(Collectors.toList());
	    return byActress;
	}

	@Override
	public List<Movie> findMovieByTheatre(String theatre) {
		// TODO Auto-generated method stub
		List<Movie> byTheatre= movieByCity.stream().filter((mov)->mov.getTheatre().equals(theatre)).sorted((mov1,mov2)->mov1.getMovieName().compareTo(mov2.getMovieName())).collect(Collectors.toList());
	    return byTheatre;
	}
	}


