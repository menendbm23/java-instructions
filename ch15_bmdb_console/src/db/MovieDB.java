package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.Movie;

public class MovieDB implements DAOUploadable<Movie> {

	// p. 677 - all CRUD methods will use this to get a connection to the DB
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false";
		String userName = "bmdb_user";
		String password = "sesame";
		Connection conn = DriverManager.getConnection(dbURL, userName, password);
		return conn;

	}

	@Override
	public Movie getById(int id) {
		Movie m = null;
		String sql = "select * from movie where id = ?";
		try {
			Connection conn = getConnection();
			//p. 685 prepared statements
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = getMovieFromResultSet(rs);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("Error getting movie by id.");
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Movie> getAll() {
		// p. 679
		List<Movie> movies = new ArrayList<>();
		String sql = "select * from movie";
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			// p, 681 - processing result set
			while (rs.next()) {
				Movie m = getMovieFromResultSet(rs);
				movies.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Error getting all movies.");
			e.printStackTrace();
		}
		return movies;
	}

	private Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String title = rs.getString(2);
		int year = rs.getInt(3);
		String rating = rs.getString(4);
		String director = rs.getString(5);
		Movie m = new Movie(id, title, rating, year, director);
		return m;
	}

	@Override
	public boolean add(Movie m) {
		boolean success = false;
		String sql = "insert into movie (title, year, rating, director) " +
				"values (?, ?, ?, ?)";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, m.getTitle());
			ps.setInt(2, m.getYear());
			ps.setString(3, m.getRating());
			ps.setString(4, m.getDirector());
			ps.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			System.err.println("Error adding movie. ");
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean update(Movie t) {
		// not yet implemented
		return false;
	}

	@Override
	public boolean delete(Movie m) {
		boolean success = false;
		// p. 691
		String sql = "delete from movie where id = ?";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, m.getId());
			ps.executeUpdate();
			success = true;
		} catch (SQLException e) {
			System.err.println("Error deleting movie. ");
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean upload() {
		// Not yet implemented
		return false;
	}

}
