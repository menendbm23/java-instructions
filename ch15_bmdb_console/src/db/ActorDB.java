package db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.Actor;

public class ActorDB implements DAOUploadable<Actor> {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false";
		String userName = "bmdb_user";
		String password = "sesame";
		Connection conn = DriverManager.getConnection(dbURL, userName, password);
		return conn;
}

	@Override
	public Actor getById(int id) {
		Actor a = null;
		String sql = "select * from actor where id = ?";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				a = getActorFromResultSet(rs);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Error getting actor by id.");
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Actor> getAll() {
		List<Actor> actors = new ArrayList<>();
		String sql = "select * from actor";
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
		while (rs.next()) {
			Actor a = getActorFromResultSet(rs);
			actors.add(a);
		}
	}	catch (SQLException e) {
		System.out.println("Error getting all actors.");
		e.printStackTrace();
	}
		return actors;
	}

	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String firstName = rs.getString(2);
		String lastName = rs.getString(3);
		String gender = rs.getString(4);
		String birthDateStr = rs.getString(5);
		LocalDate birthDate = LocalDate.parse(birthDateStr);
		Actor a = new Actor(id, firstName, lastName, gender, birthDate);
		return a;
	}

	@Override
	public boolean add(Actor a) {
		boolean success = false;
		String sql = "insert into actor (firstname, lastname, gender, birthdate) " + 
		"values (?, ?, ?, ?)";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, a.getFirstName());
			ps.setString(2, a.getLastName());
			ps.setString(3, a.getGender());
			ps.setString(4, a.getBirthDate().toString());
			ps.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			System.err.println("Error adding actor. ");
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean update(Actor a) {
		// not yet implemented
		return false;
	}

	@Override
	public boolean delete(Actor a) {
		boolean success = false;
		String sql = "delete from actor where id = ?";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, a.getId());
			ps.executeUpdate();
			success = true;
		} catch (SQLException e) {
			System.err.println("Error deleting actor. ");
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean upload() {
		// not yet implemented
		return false;
	}
	
}