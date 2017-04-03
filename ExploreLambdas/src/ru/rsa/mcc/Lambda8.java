package ru.rsa.mcc;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lambda8 {
	
	public static void main(String[] args) {
		Path dir = FileSystems.getDefault().getPath("C:\\Git");
		
		/*
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path file) {
				 return (Files.isDirectory(file));						
			}
		};*/
		
		// using behavior parameterization with lambda expression and method reference
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, Files::isDirectory )) {
			for (Path file: stream) {
		        System.out.println(file.getFileName()); // printing directories only
		    }	
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
	}

}