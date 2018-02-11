package entity;


import java.sql.Timestamp;

public class Users {

	private int userid;
	private String username;
	private String password;
	private String email;
	private Timestamp lastlogin;

	
	
	public Users(int userid, String username, String password, String email, Timestamp lastlogin) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.lastlogin = lastlogin;
	}
	
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userid+"  "+username+"  "+password+"  "+email;
	}

	
	
}
