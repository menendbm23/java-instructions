package db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserTextFile implements DAO<User> {
	private static final String USER_FILE_NAME = "USER.txt";
	List<User> user = new ArrayList<>();
	
	public UserTextFile() {
		getAll();
	}
	
	@Override
	public User getById(int id) {
		User u = null;
		for (User user: user) {
			if (user.getId()==id) {
				u = user;
			}
		}
		return u;
	}
	@Override
	public List<User> getAll() {
		if (user.size()==0) {
			try {
				BufferedReader in = new BufferedReader(
									new FileReader(USER_FILE_NAME));
				String line = in.readLine();
				while (line != null) {
					String [] fields = line.split("\t");
					String idStr = fields[0];
					int id = Integer.parseInt(idStr);
					String userName = fields[0];
					String password = fields[1];
					String firstName = fields[2];
					String lastName = fields[3];
					String phoneNumber = fields[4];
					String email = fields[5];
					boolean reviewer = fields[6] != null;
					boolean admin = fields[7] != null;
					
					
					User u = new User(id, userName, password, firstName, lastName, 
							phoneNumber, email, reviewer, admin);
					
					user.add(u);
				
					line = in.readLine();
				}
				in.close();
			}
			catch (Exception e) {
				System.out.println("Error getting user records from file.");
				e.printStackTrace();
			}
		}
		return user;
	}
	@Override
	public boolean add(User newUser) {
		user.add(newUser);
		return saveAll();
	}
	
	private boolean saveAll() {
		boolean success = true;
		Path usersPath = Paths.get(USER_FILE_NAME);
		File usersFile = usersPath.toFile();
		
		try (PrintWriter out = new PrintWriter(
						  new BufferedWriter(
						  new FileWriter(usersFile)))) {
			for (User u: user) {
				out.println(u.getId()+"\t"+u.getUserName()+"\t"+u.getPassword()+
						"\t"+u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getPhoneNumber()
						+"\t"+u.getEmail()+"\t"+u.isReviewer()+"\t"+u.isAdmin());
			}
			out.close();
		
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
	
		return success;				  
	}
	@Override
	public boolean update(User u) {
		return false;
	}
	@Override
	public boolean delete(User u) {
		user.remove(u);
		return saveAll();
	}
	
	

}
