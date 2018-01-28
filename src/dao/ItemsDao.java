package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.batch.Main;

import entity.Items;
import util.DBhelp;

public class ItemsDao {

	public ArrayList<Items> getAllitems() {
		String sql = "select * from items";
		Connection connection = null;
		ArrayList<Items> items = new ArrayList<Items>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Items items2 = new Items();
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

		return items;
	}

	// 通过商品编号找商品
	public Items getItembyNO(int no) {
		String sql = "select * from items where no=" + no;
		Connection connection = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Items items2 = new Items();
				items2.setNo(resultSet.getInt("no"));
				items2.setName(resultSet.getString("name"));
				items2.setPrice(resultSet.getInt("price"));
				items2.setNumber(resultSet.getInt("number"));
				items2.setCity(resultSet.getString("city"));
				items2.setPicture(resultSet.getString("picture"));
				return items2;
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

		return null;
	}

	public static void main(String[] args) {

		ItemsDao dao = new ItemsDao();
		ArrayList<Items> a = dao.getViewList("1,2,3,4");
		for(Items i:a)
		{
			System.out.println(i.getName());
		}

	}

	public ArrayList<Items> getViewList(String cookies) {

		ArrayList<Items> items = new ArrayList<Items>();
		String[] arr = cookies.split(",");
		String sql = "select * from items where no=?";
		Connection connection = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {
			for (String list : arr) {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, Integer.valueOf(list));
				resultSet = statement.executeQuery();
				if (resultSet.next()) {
					Items items2 = new Items();
					items2.setNo(resultSet.getInt("no"));
					items2.setName(resultSet.getString("name"));
					items2.setPrice(resultSet.getInt("price"));
					items2.setNumber(resultSet.getInt("number"));
					items2.setCity(resultSet.getString("city"));
					items2.setPicture(resultSet.getString("picture"));
					items.add(items2);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return items;
	}

}
