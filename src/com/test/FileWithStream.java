package com.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWithStream {

	public static void main(String[] args) throws IOException {
	    Path start = Paths.get("/home/sterlite/Downloads/runtime_jars_bkp");
	    int maxDepth = 5;
	    try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) -> String.valueOf(path).endsWith(".jar"))) {
	        String joined = stream
	                .sorted()
	                .map(String::valueOf)
	                .collect(Collectors.joining("; "));
//	        System.out.println("Found: " + joined);
	    }
	    
	    
	    Path f = Paths.get("/home/sterlite/bhavin/cmd");

	    // try (Stream<String> stream = Files.lines(f)) {
		 // stream.forEach(System.out::println); }
		 
	    
	    
	    
	    List<String> list = Files.readAllLines(f);
	 //   System.out.println(list.size()+"Size");
	 //   list.stream().forEach(System.out::println);
	    
	    try (Stream<Path> stream = Files.walk(start, maxDepth)) {
	       stream.forEach(System.out::println);
	    }
	}
	
}
