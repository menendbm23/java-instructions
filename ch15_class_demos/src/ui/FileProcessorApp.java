package ui;

import java.io.IOException;
import java.nio.file.*;

public class FileProcessorApp {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the file processing app");
		//p. 463
		String dirString = "c:/temp/files"; //creates the file name
		Path dirPath = Paths.get(dirString); // creates the file 
		
		//create the directory if it doesnt already exist
		if (Files.notExists(dirPath)) {
			Files.createDirectories(dirPath);
			System.out.println("Directory created");
		}
		else {
			System.out.println("Directory already exists");
		}
		//create the file if it doesnt already exist
		String fileString = "products.txt";
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
			System.out.println("File created");
		}
		else { 
			System.out.println("File already exists");
		}
		
		//display files in c:/temp/files folder
		if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
			System.out.println("Directory: "+dirPath.toAbsolutePath());
			System.out.println("Files:");
			DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
			for (Path p: dirStream) {
				if(Files.isRegularFile(p)) {
					System.out.println("    "+p.getFileName());
				}
			}
		}
		
		
		
		
		
		
		
		
		System.out.println("Bye");
		
	}

}
