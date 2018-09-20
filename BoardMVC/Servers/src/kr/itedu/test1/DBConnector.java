package kr.itedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	public static Connection getConn() throws SQLException, ClassNotFoundException{
	
		Connection conn = null;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String id="hr";
		String pw="hkitedu";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}	
	
	public static void close(Connection c, PreparedStatement p, ResultSet r) {
		if(r != null) {
			try { r.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if(p != null) {
			try { p.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if(c != null) {
			try { c.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
}
