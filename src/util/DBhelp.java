package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelp {
	
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=shop";
	private static final String USER="sa";
	private static final String PASSWORD="951115";
	
	private static Connection connection=null;
	
    //静态代码块负责加载驱动
	static
	{
	   try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnecton()
	{
		if(connection==null)
		{
			try {
				connection=DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}
