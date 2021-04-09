package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.model.Admin;
import com.movieapp.model.Movie;

public class AdminDaoImpl implements AdminDao {
	PreparedStatement statement=null;
	public Admin oneAdminLogin(String loginId,String password)  {
		Admin admin=null;
		String sql="select * from movieadmin where loginId=? and password=?";
		Connection connection=DBConnection.openConnection();
		try {
			statement=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, loginId);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
	        while(rs.next())
	        {
	        	String mobileNo=rs.getString(3);
	        	String adminName=rs.getString(4);
	            admin=new Admin(loginId,password,mobileNo,adminName);
	        	
	        }
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBConnection.closeConnection();
			}
		return admin;
     
	}

	public void addOneMovie(Movie movie) {
		// TODO Auto-generated method stub
String sql="insert into onlinemovie values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
        Connection connection=DBConnection.openConnection();
               
		try {
			statement = connection.prepareStatement(sql);
	        
	        statement.setString(1,movie.getMovieName());
	        statement.setInt(2,movie.getRatings());
	        statement.setInt(3,movie.getMovieId());
	        statement.setString(4,movie.getLanguage());
	        statement.setString(5,movie.getCategory());
	        statement.setString(6,movie.getDirector());
	        statement.setString(7,movie.getActor());
	        statement.setString(8,movie.getActress());
	        statement.setString(9,movie.getDate());
	        
	        statement.setDouble(10,movie.getPrice());
	        statement.setString(11,movie.getCity());
	        statement.setString(12,movie.getTheatre());
	        statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBConnection.closeConnection();
			}

	}

	public int updateOneMovie(int movieId, double price) {
		// TODO Auto-generated method stub
       String sql="update onlinemovie set price=? where movieId=?";
		 int result=0;
        Connection connection=DBConnection.openConnection();
        
		try {
			statement = connection.prepareStatement(sql);
	        statement.setDouble(1, price);
	        statement.setInt(2, movieId);
	        result= statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBConnection.closeConnection();
			}
		return result;
	}

	public int deleteOneMovie(int movieId) {
String sql="delete from onlinemovie where movieId=?";
		int result=0;
        Connection connection=DBConnection.openConnection();
        PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement(sql);
	        statement.setInt(1, movieId);
	       result= statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBConnection.closeConnection();
			}
		return result;

	}

	public List<Movie> findAllMovie() {
		// TODO Auto-generated method stub
		String sql="select * from onlinemovie";
		List<Movie> movieList=new ArrayList<>();
		Connection connection=DBConnection.openConnection();
		try{
			statement=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
				  String city=rs.getString(11);
				String theatre=rs.getString(12);
				Movie movie=new Movie(movieName,ratings,movieId,language,category,director,actor,actress,date,price,city,theatre);
				 movieList.add(movie);
			}
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBConnection.closeConnection();
			}
		return movieList;
	}

	

	@Override
	public void oneAdminSignUp(Admin admin){
		// TODO Auto-generated method stub
      String sql="insert into movieadmin values(?,?,?,?)";
		
        Connection connection=DBConnection.openConnection();
        
		try {
			statement = connection.prepareStatement(sql);
	        statement.setString(1,admin.getLoginId());
	        statement.setString(2,admin.getPassword());
	        statement.setString(3,admin.getMobileNo());
            statement.setString(4,admin.getAdminName());
            statement.execute();
        	System.out.println("Signup successfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBConnection.closeConnection();
			}
		
	}

}
