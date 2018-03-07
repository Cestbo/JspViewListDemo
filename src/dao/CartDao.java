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

		ArrayList<Cart> carts = getAllByUserid(cart.getUserid());
		for (Cart c : carts) {
			if (c.getGoodsid() == cart.getGoodsid()) {
				updateNum(cart);
				return true;
			}
		}
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

	public boolean delByCartid(int goodsid) {

		String sql = "delete from cart where cartid=" + goodsid;
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

	public void updateNum(Cart cart) {

		int priNum=getnumBygoodsidAnduserid(cart.getGoodsid(), cart.getUserid());
		int total=priNum+cart.getNumber();
		String sql = "update cart set number=" + total + " where userid=" + cart.getUserid() + " and goodsid="
				+ cart.getGoodsid();
		Connection connection = null;

		PreparedStatement statement = null;

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

	}
	
	public int getnumBygoodsidAnduserid(int goodsid,int userid) {
		
		int num=0;
		String sql="select number from cart where goodsid=? and userid=?";
		PreparedStatement statement=null;
		Connection connection=DBhelp.getConnecton();
		
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, goodsid);
			statement.setInt(2, userid);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				num=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return num;
		
	}

	public static void main(String[] args) {

		CartDao dao = new CartDao();

		

		System.out.println("ok");

	}
}
