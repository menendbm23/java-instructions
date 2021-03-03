package ui;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import util.Console;
import business.Actor;
import business.Movie;
import business.User;
import db.ActorDB;
import db.DAO;
import db.DAOUploadable;
import db.MovieDB;
import db.MovieTextFile;
import db.UserDB;

public class BmdbConsoleApp {
	private static DAOUploadable<Movie> movieDAO = new MovieDB();
	private static DAOUploadable<Actor> actorDAO = new ActorDB();
	private static UserDB userDB = new UserDB();

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Bootcamp Movie Database!!!");
		String command = "";

		while (!command.equalsIgnoreCase("exit")) {
			
			command = Console.getRequiredString("movie or actor menu: ");
			if (command.equals("movie")) {
				System.out.println("show  - show all movies");
				System.out.println("add   - add a movie");
				System.out.println("get   - get a movie by id");
				System.out.println("del   - delete a movie by id");
				System.out.println("upl   - upload new movies from upload file");
				System.out.println("login - user login");
				System.out.println("exit  - exit app");

				command = Console.getRequiredString("Command: ");
				switch (command) {

				case "show":
					// read all records from file and print to screen
					List<Movie> movies = movieDAO.getAll();
					System.out.println("Movie List:");
					System.out.println("============");
					if (movies.size() != 0) {
						for (Movie m : movies) {
							System.out.println(m);
						}
					} else {
						System.out.println("Movie file empty.");
					}
					break;
				case "add":
					// prompt user for all fields for a new movie
					System.out.println("Add a movie:");
					System.out.println("============");
					// int id = Console.getInt("ID: ", 0, Integer.MAX_VALUE);
					String title = Console.getRequiredString("Title: ");
					String rating = Console.getRequiredString("Rating: ");
					int year = Console.getInt("Year: ", 0, Integer.MAX_VALUE);
					String director = Console.getRequiredString("Director: ");
					// create instance of movie
					Movie m = new Movie(title, rating, year, director);
					// call writeMovieRecord
					if (movieDAO.add(m)) {
						System.out.println("Movie added!");
					} else {
						System.out.println("Doh! Error adding movie.");
					}
					break;
				case "get":
					System.out.println("Get a movie:");
					System.out.println("============");
					int id = Console.getInt("Movie ID: ", 0, Integer.MAX_VALUE);
					Movie movie = movieDAO.getById(id);
					if (movie != null) {
						System.out.println(movie);
					} else {
						System.out.println("Invalid movie id.");
					}
					break;
				case "del":
					System.out.println("Delete a movie:");
					System.out.println("============");
					id = Console.getInt("Movie ID: ", 0, Integer.MAX_VALUE);
					movie = movieDAO.getById(id);
					if (movie != null) {
						movieDAO.delete(movie);
						System.out.println("Movie successfully deleted");
					} else {
						System.out.println("Invalid movie id.");
					}
					break;
				case "upload":
					if (movieDAO.upload())
						System.out.println("Upload completed successfully!");
					else
						System.err.println("Error in movie upload....check console.");
					break;
				case "login":
					System.out.println("User login:");
					System.out.println("============");
					String un = Console.getRequiredString("Username: ");
					String pwd = Console.getRequiredString("Password: ");
					User authenticatedUser = userDB.login(un, pwd);
					if (authenticatedUser==null) {
						System.out.println("Invalid login!");
					}
					else {
						System.out.println("Successful login! Welcome, "
								+authenticatedUser.getFirstName()+"!");
					}
					break;
				case "exit":
					break;
				}

			} else if (command.equals("actor")) {
				System.out.println("show - show all actors");
				System.out.println("add  - add a actor");
				System.out.println("get  - get a actor by id");
				System.out.println("del  - delete a actor by id");
				System.out.println("upl  - upload new actors from upload file");
				System.out.println("login - user login");
				System.out.println("exit - exit app");

				command = Console.getRequiredString("Command: ");
				switch (command) {

				case "show":
					// read all records from file and print to screen
					List<Actor> actors = actorDAO.getAll();
					System.out.println("Actor List:");
					System.out.println("============");
					if (actors.size() != 0) {
						for (Actor a : actors) {
							System.out.println(a);
						}
					} else {
						System.out.println("Actor file empty.");
					}
					break;
				case "add":
					// prompt user for all fields for a new movie
					System.out.println("Add a actor:");
					System.out.println("============");
					String firstName = Console.getRequiredString("First Name: ");
					String lastName = Console.getRequiredString("Last Name: ");
					String gender = Console.getRequiredString("Gender: ");
					String birthDateStr = Console.getRequiredString("Birth Date (YYYY-MM-DD): ");
					LocalDate birthDate = LocalDate.parse(birthDateStr); 
					Actor a = new Actor(firstName, lastName, gender, birthDate);
					// call writeMovieRecord
					if (actorDAO.add(a)) {
						System.out.println("Actor added!");
					} else {
						System.out.println("Doh! Error adding actor.");
					}
					break;
				case "get":
					System.out.println("Get a actor:");
					System.out.println("============");
					int id = Console.getInt("Actor ID: ", 0, Integer.MAX_VALUE);
					Actor actor = actorDAO.getById(id);
					if (actor != null) {
						System.out.println(actor);
					} else {
						System.out.println("Invalid actor id.");
					}
					break;
				case "del":
					System.out.println("Delete a actor:");
					System.out.println("============");
					id = Console.getInt("Actor ID: ", 0, Integer.MAX_VALUE);
					actor = actorDAO.getById(id);
					if (actor != null) {
						actorDAO.delete(actor);
						System.out.println("Actor successfully deleted");
					} else {
						System.out.println("Invalid actor id.");
					}
					break;
				case "upload":
					if (actorDAO.upload())
						System.out.println("Upload completed successfully!");
					else
						System.err.println("Error in actor upload....check console.");
					break;
				case "login":
					System.out.println("User login:");
					System.out.println("============");
					String un = Console.getRequiredString("Username: ");
					String pwd = Console.getRequiredString("Password: ");
					User authenticatedUser = userDB.login(un, pwd);
					if (authenticatedUser==null) {
						System.out.println("Invalid login!");
					}
					else {
						System.out.println("Successful login! Welcome, "
								+authenticatedUser.getFirstName()+"!");
					}
					break;
				case "exit":
					break;
				}

				System.out.println("Bye");
			}

		}

	}

}
