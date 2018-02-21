package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.*;
import util.DBhelp;

public class CartDao {

	public boolean addGoods(Cart cart) {

		String sql = "insert into cart(userid,goodsid,status,number) values(?,?,?,?)";
		Connection connection = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {

			statement = connection.prepareStatement(sql);

			
			statement.setInt(1, cart.getUserid());
			statement.setInt(2, cart.getGoodsid());
			statement.setInt(3, cart.getStatus());
			statement.setInt(4, cart.getNumber());
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

	public ArrayList<Cart> getAllByUserid(int userid) {

		String sql = "select * from cart where userid=" + userid;
		Connection connection = null;
		ArrayList<Cart> carts = new ArrayList<Cart>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBhelp.getConnecton();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Cart cart = new Cart();
				cart.setCartid(resultSet.getInt(1));
				cart.setUserid(resultSet.getInt(2));
				cart.setGoodsid(resultSet.getInt(3));
				cart.setStatus(resultSet.getInt(4));
				cart.setNumber(resultSet.getInt(5));
				carts.add(cart);
			}
			return carts;

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

	public boolean delByGoodsid(int goodsid) {

		String sql = "delete from cart where goodsid=" + goodsid;
		PreparedStatement statement = null;
		Connection connection = null;

		connection = DBhelp.getConnecton();
		try {
			statement = connection.prepareStatement(sql);
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

		}
		return true;
	}

	public static void main(String[] args) {

		CartDao dao = new CartDao();
		
			
			
			dao.delByGoodsid(6);
		
		System.out.println("ok");
	   
	}
}
