package ru.rsa.mcc;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lambda4 {
	
	public static void main(String[] args) {
		Path dir = FileSystems.getDefault().getPath("C:\\Eclipse");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file: stream) {
		        System.out.println(file.getFileName()); // printing files and directories
		    }	
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
	}

}
