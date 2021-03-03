package db;

import java.sql.*;

import business.User;

public class UserDB {
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false";
		String userName = "bmdb_user";
		String password = "sesame";
		Connection conn = DriverManager.getConnection(dbURL, userName, password);
		return conn;

	}
	
	
	public User login(String un, String pwd) {
		// NOTE: poor design....wont be able to differentiate
		// between invalid login and exception!!!!
		User u = null;
		String sql = "select * from user "
				   + "where username = ?"
				   + "  and password = ?";
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
			//p. 685 prepared statements
			
			ps.setString(1, un);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = getUserFromResultSet(rs);
			}
		}
		catch (SQLException e) {
			System.err.println("Exception during user login.");
			e.printStackTrace();
		}
		return u;
	}
	
	private User getUserFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String un = rs.getString(2);
		String pwd = rs.getString(3);
		String fn = rs.getString(4);
		String ln = rs.getString(5);
		String pn = rs.getString(6);
		String em = rs.getString(7);
		double cv = rs.getDouble(8);
		User u = new User(id, un, pwd, fn, ln, pn, em, cv);
		return u;
	}
}
