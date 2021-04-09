package com.movieapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection;
	  public static Connection openConnection() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "system";
		  try {
			connection=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return connection;
	  }
	  public static void closeConnection() {
		  if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  System.out.println("closeConnection");    
	  }
}
