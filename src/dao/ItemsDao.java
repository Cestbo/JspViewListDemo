package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Items;
import util.DBhelp;

public class ItemsDao {
	
	public ArrayList<Items> getAllitems()
	{
		String sql="select * from items";
		Connection connection=null;
		ArrayList<Items> items=new ArrayList<Items>();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		connection=DBhelp.getConnecton();
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				Items items2=new Items();
				items2.setNo(resultSet.getInt("no"));
				items2.setName(resultSet.getString("name"));
				items2.setPrice(resultSet.getInt("price"));
				items2.setNumber(resultSet.getInt("number"));
				items2.setCity(resultSet.getString("city"));
				items2.setPicture(resultSet.getString("picture"));
			    items.add(items2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(resultSet!=null)
			{
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Items> list=null;
		ItemsDao dao=new ItemsDao();
		list=dao.getAllitems();
		for(Items i:list)
		{
			System.out.println(i.getName());
		}
		
	}

}
