package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB implements DAO<User> {
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prsdb?useSSL=false&allowPublicKeyRetrieval=true";
		String userName = "prs_user";
		String password = "sesame";
		Connection conn = DriverManager.getConnection(dbURL, userName, password);
		return conn;
	}
	private List<User> users;
	
	
	public UserDB(List<User> users) {
		super();
		this.users = users;
	}


	public UserDB() {
	}


	@Override
	public User getById(int id) {
		User u = null;
		String sql = "select * from users where id = ?";
		try { 
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = getUserFromResultSet(rs);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Error getting movie by id.");
			e.printStackTrace();
		}
		for (User user: users) {
			if (user.getId()==id) {
				u = user;
			}
		}
		
		return u;
	}

	@Override
	public List<User> getAll() {
		List <User> users = new ArrayList<>();
		String sql = "select * from users";
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				User u = getUserFromResultSet(rs);
				users.add(u);
			}
		} catch (SQLException e) {
			System.err.println("Error getting all users.");
			e.printStackTrace();
		}
		return users;
	}
	
	private User getUserFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String userName = rs.getString(2);
		String password = rs.getString(3);
		String firstName = rs.getString(4);
		String lastName = rs.getString(5);
		String phoneNumber = rs.getString(6);
		String email = rs.getString(7);
		boolean reviewer = rs.getBoolean(9);
		boolean admin = rs.getBoolean(8);
		User u = new User(id, userName, password, firstName, lastName, phoneNumber, email, reviewer, admin);
		return u;
	}

	@Override
	public boolean add(User u) {
		boolean success = false;
		String sql = "insert into users (username, password, firstname, lastname, phone, email, isReviewer, isAdmin) " +
					"values ( ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getPhoneNumber());
			ps.setString(6, u.getEmail());
			ps.setBoolean(7, u.isReviewer());
			ps.setBoolean(8, u.isAdmin());
			ps.executeUpdate();
			success = true;
		
		} catch (Exception e) {
			System.err.println("Error adding user. ");
			e.printStackTrace();
			
		}
		return success;
	}

	@Override
	public boolean update(User u) {
		boolean success = false;
		String sql = "delete from users where id = ?";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
		ps.setInt(1, u.getId());
		ps.executeUpdate();
		success = true;
	}	catch (SQLException e) {
		System.err.println("Error deleting movie. ");
		e.printStackTrace();
		
	}
	return success;
	
}

	@Override
	public boolean delete(User u) {
		// not yet implemented
		return false;
	}

}
