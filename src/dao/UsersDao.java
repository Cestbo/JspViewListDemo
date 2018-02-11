package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import entity.Users;
import util.DBhelp;

public class UsersDao {

	public boolean addUser(Users user) {
	
		String sql = "insert into users(username,password,email,lastlogin) values(?,?,?,?)";
		Connection connection = null;
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {
			
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setTimestamp(4, user.getLastlogin());
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return true;
	}
	
	public Users getUserByName(String name) {
		
		String sql = "select * from users where username=?";
		Connection connection = null;
		Users user=null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				user=new Users(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getTimestamp(5));
				
			}
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return user;
		
	}
	
	
	public static void main(String[] args) {
		UsersDao dao=new UsersDao();
		Users user=new Users();
		user.setUsername("张三");
		user.setPassword("123456");
		user.setEmail("张三@qq.com");
		//SimpleDateFormat format=new SimpleDateFormat("")
		System.out.println();
		java.sql.Timestamp timestamp=new java.sql.Timestamp(System.currentTimeMillis());
		//Date date=new Date(new java.util.Date().getTime());
		user.setLastlogin(timestamp);
		System.out.println(timestamp);
		
		System.out.println("添加成功");
		user=dao.getUserByName("ass");
		if(user==null)
	    System.out.println("not found");
		
	}
}
