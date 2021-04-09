package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.movieapp.model.User;

public class UserDaoImpl implements UserDao {
	PreparedStatement statement=null;
	@Override
	public User oneUserLogin(String loginId, String password){
		// TODO Auto-generated method stub
		String sql="select * from movieuser  where loginId=? and password=?";
		User user=null;
		Connection connection=DBConnection.openConnection();
		
		try {
			statement=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, loginId);
			statement.setString(2,password);
			ResultSet rs=statement.executeQuery();
	        while(rs.next()) {
	        	String userName=rs.getString(3);
	        	String mobileNo=rs.getString(4);
	        	user=new User(loginId,password,userName,mobileNo);
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
		return user;
     
	}

	@Override
	public void oneUserSignUp(User user) {
		// TODO Auto-generated method stub
         String sql="insert into movieuser values(?,?,?,?)";
		
        Connection connection=DBConnection.openConnection();
        
		try {
			statement=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			statement = connection.prepareStatement(sql);
	        statement.setString(1,user.getLoginId());
	        statement.setString(2,user.getPassword());
	        statement.setString(3,user.getUserName());
            statement.setString(4,user.getMobileNo());
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
