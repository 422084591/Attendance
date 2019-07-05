package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final static String JDBC="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost:3306/attendance?useUnicode=true&amp;characterEncoding=UTF-8";
	private final static String USERNAME="root";
	private final static String PASSWORD="root";
	private Connection conn=null;
	public Connection getConnection() {
		try {
			//加载驱动
			Class.forName(JDBC);
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
