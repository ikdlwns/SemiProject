package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

	static final String MYSQL_URL="jdbc:mysql://rds-mysql-semi.czpm8y7t3fzb.ap-northeast-2.rds.amazonaws.com:3306/semiwebproject";

	//생성자
	public DbConnect() {

		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 드라이버 실패:"+e.getMessage());
		}
	}

	//Connection
	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(MYSQL_URL, "admin", "Pa$$w0rd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 연결실패: "+e.getMessage());
		}


		return conn;
	}

	public void dbClose(ResultSet rs, Statement stmt, Connection conn) {

		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null)conn.close();

		}catch (SQLException e) {
			System.out.println("close 실패");
		}
	}

	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null)conn.close();

		}catch (SQLException e) {
			System.out.println("close 실패");
		}
	}
	
	public void dbClose(Statement stmt, Connection conn) {

		try {
			if(stmt != null) stmt.close();
			if(conn != null)conn.close();

		}catch (SQLException e) {
			System.out.println("close 실패");
		}
	}

	public void dbClose(PreparedStatement pstmt, Connection conn) {

		try {
			if(pstmt != null) pstmt.close();
			if(conn != null)conn.close();

		}catch (SQLException e) {
			System.out.println("close 실패");
		}
	}
	
}
