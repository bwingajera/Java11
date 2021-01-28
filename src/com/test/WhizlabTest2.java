package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WhizlabTest2 {

	
	public static void main(String[] args) throws IOException {
		List<Integer> l1=List.of(1);
		List<Integer> l2=List.of(1,2);
		List<Integer> l3=List.of(1,3);
		List<Integer> l4=List.of(1,2,3);
		Collection<Long> i=Stream.of(l1,l2,l3,l4).collect(Collectors.groupingBy(List::size,Collectors.counting())).values();
		
		Object ob=Stream.of(1,2,4).reduce((a,b)->a+b).get();
		
		parraller();
		String s1="abc";
		s1=s1.toUpperCase();
		Stream<Integer> stream=Stream.of(1,2,3);
		stream.count();
	//	stream.forEach(System.out::print);
		List<Integer> l=List.of(1,2,3);
	//	l.stream().forEach(i->i=i+10);
		//int i=stream.reduce((a,b)->a+b).get();
		//stream.count();
	//	stream.count();
		//stream.forEach(System.out::print);
		l.stream().forEach(System.out::print);
		
		UnaryOperator<String> f=s->s=s.concat(s);
	//	System.out.println(Path.of("a/b").relativize(Path.of("/a/b")));
		System.out.println(Path.of("a/b").resolve(Path.of("/d/c")));
		System.out.println(":::::::"+Path.of("/a/v/b").resolveSibling(Path.of("/d/c")));
		Path path=Path.of("/","/",".","root","");
		System.out.println(path);
	    System.out.println(path.getName(0));
		
	    
	//    nonParraller();
		//fileExample();
	//	filePathExample();;
	}
	
	public static void nonParraller(){
		
		StringBuilder sb= Stream.of("a","b").collect(StringBuilder::new,StringBuilder::append,(a,b)->b.append(a));
		System.out.println(sb);
		
		StringBuilder sb1= Stream.of("a","b").collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
		System.out.println(sb1);
		
		StringBuilder sb3= Stream.of("a","b").collect(StringBuilder::new,StringBuilder::append,(a,b)->a.append(b));
		System.out.println(sb3);
		
		StringBuilder sb4= List.of("a","b").stream().collect(StringBuilder::new,StringBuilder::append,(a,b)->a.append(b));
		System.out.println(sb4);
		
		List<String> asList = Stream.of("a","b","a","b").collect(ArrayList::new, ArrayList::add,
                 ArrayList::addAll);
		System.out.println(asList);
		List<String> asList1 = List.of("a","b","a","b").stream().collect(ArrayList::new, ArrayList::add,
                 ArrayList::addAll);
		System.out.println(asList1);
		 
		String s = List.of("a","b","a","b").stream().collect(String::new, String::concat,
				String::concat);
		System.out.println("s ::::"+s);
	
		String s2 = Stream.of("a","b").collect(String::new, String::concat,
				String::concat);
		 System.out.println("ss ::::"+s2);
		 
			String s3 = List.of("a","b").stream().collect(String::new, String::concat,
					(a,b)->a.concat(b));
			System.out.println("s3 ::::"+s3);
		
			String s4 = Stream.of("a","b").collect(String::new, String::concat,
					(a,b)->a.concat(b));
			 System.out.println("s4 ::::"+s4);
			 
			 
		
	}
	
	public static void fileExample() throws IOException {
		
		//System.out.println(Path.of("/a/c").resolveSibling(Path.of("a/b")));;
		
		Path path=Path.of("/home/sterlite/Downloads/runtime_jars_bkp");
	     Files.list(path).forEach(System.out::println);

	//    Files.newDirectoryStream(path).forEach(System.out::println);;
	    
//	    Files.newDirectoryStream(path,"*.jar").forEach(System.out::println);
	    
		try (Stream<Path> stream = Files.walk(path, 5)) {
		       stream.forEach(System.out::println);
		    }
		
	     Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>() {
	         public boolean accept(Path file) throws IOException {
	             return (Files.size(file) > 0);
	         }
	     }).forEach(System.out::println);
	
	     
	     Files.list(path).forEach(System.out::println);
	     
	     System.out.println(Files.getFileStore(path));
	     
	     
	     
	     String fileToFind = File.separator + "link";

	     try {
	       Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
	         
	         @Override
	         public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	           String fileString = file.toAbsolutePath().toString();
	           //System.out.println("pathString = " + fileString);
	           System.out.println("file found at path: " + file.toAbsolutePath());
	           if(fileString.endsWith(fileToFind)){
	             System.out.println("file found at path: " + file.toAbsolutePath());
	             return FileVisitResult.TERMINATE;
	           }
	           return FileVisitResult.CONTINUE;
	         }
	       });
	     } catch(IOException e){
	         e.printStackTrace();
	     }
	}
	
	public static void filePathExample() throws IOException {
		
		
		Path p1=Paths.get("test",".");
		Path p2=Path.of(p1.getParent().toString(),".");
		Path p3=p1.toAbsolutePath();
		Path p4=p1.normalize();
		
		System.out.println("::p1::"+p1);
		System.out.println("::p2::"+p2);
		System.out.println("::p3::"+p3);
		System.out.println("::p4::"+p4);
		System.out.println(p1.isAbsolute());
		
		System.out.println(Path.of("/","","tets","dd","/"));
		System.out.println(Path.of("","","/"));
		System.out.println(Path.of("","","/").getRoot());

		System.out.println("Count::"+Path.of("","/s","/ss").getNameCount());
		System.out.println("Count::"+Path.of("","","").subpath(0, 1));
		System.out.println("Parent:: "+Path.of(".","","").getParent());
		System.out.println("startWith:: "+Path.of("/ss","xxx","").startsWith("//ss/"));
		System.out.println(Path.of("","","sd/").getFileName());

		System.out.println(Paths.get("ss/dd/udemy_link").isAbsolute());
		System.out.println(Paths.get("/udemy_link").toAbsolutePath());
		
	//	Path p5=Paths.get("x","y","c");
		Path p5=Paths.get("/","a","b","b");
	//	Path p5=Path.of("./a/../b/./../../.././c");
		Path p6=Paths.get("/x",".","y","..","z");
	//	Path p6=Paths.get("x","y","C");
		System.out.println("Resove ::"+p5.resolve(p6));
		System.out.println("Normalize ::="+p5.normalize());
		System.out.println("Sibling ::="+p5.resolveSibling(p6));
		System.out.println("Relative ::="+p5.relativize(p6));
		System.out.println("Url ::="+Path.of("","","").toUri());
		
		System.out.println(Path.of(p5.toUri()));
		System.out.println(p5.toAbsolutePath());
//		System.out.println(p5.toRealPath(LinkOption.NOFOLLOW_LINKS));
		System.out.println(Path.of(p5.toUri()).equals(p6.toAbsolutePath()));
		
		Path p7=Paths.get("");
		Path p8=Paths.get("/");
		
		
		
		System.out.println("P7 Resove ::"+p7.resolve(p8));
		System.out.println("P7Normalize ::="+p7.normalize());
		System.out.println("P7 Sibling ::="+p7.resolveSibling(p8));
		//System.out.println("P7 Relative ::="+p7.relativize(p8));
		System.out.println("P7 Url ::="+p7.toUri());
		
		System.out.println(Path.of(p7.toUri()));
		System.out.println(p7.toAbsolutePath());
//		System.out.println(p7.toRealPath(LinkOption.NOFOLLOW_LINKS));
		System.out.println(Path.of(p7.toUri()).equals(p8.toAbsolutePath()));
	}
	
	public static void parraller(){
		
		StringBuilder sb= Stream.of("a","b").parallel().collect(StringBuilder::new,StringBuilder::append,(a,b)->b.append(a));
		System.out.println(sb);
		
		StringBuilder sb1= Stream.of("a","b").parallel().collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
		System.out.println(sb1);
		
		StringBuilder sb3= Stream.of("a","b").parallel().collect(StringBuilder::new,StringBuilder::append,(a,b)->a.append(b));
		System.out.println(sb3);
		
		StringBuilder sb4= List.of("a","b").parallelStream().collect(StringBuilder::new,StringBuilder::append,(a,b)->a.append(b));
		System.out.println(sb4);
		
		List<String> asList = Stream.of("a","b","a","b").parallel().collect(ArrayList::new, ArrayList::add,
                 ArrayList::addAll);
		System.out.println(asList);
		List<String> asList1 = List.of("a","b","a","b").parallelStream().collect(ArrayList::new, ArrayList::add,
                 ArrayList::addAll);
		System.out.println(asList1);
		 
		String s = List.of("a","b","a","b").parallelStream().collect(String::new, String::concat,
				String::concat);
		System.out.println("s ::::"+s);
	
		String s2 = Stream.of("a","b").parallel().collect(String::new, String::concat,
				String::concat);
		 System.out.println("ss ::::"+s2);
		 
			String s3 = List.of("a","b").parallelStream().collect(String::new, String::concat,
					(a,b)->a.concat(b));
			System.out.println("s3 ::::"+s3);
		
			String s4 = Stream.of("a","b").parallel().collect(String::new, String::concat,
					(a,b)->a.concat(b));
			 System.out.println("s4 ::::"+s4);
			 
			 
		
	}
	
	public static void casting() {
	
		var v= new ArrayList<WhizlabTest1>();
		WhizlabTest1 w=new WhizlabTest1();
		v.add(w);
		WhizlabTest1 w2=v.get(0);
	}	
	
	public static void var() {
	//	var result=0;
		int i1=1;
		int i2=2;
		float i3=i1++ + ++i2;
		var result=	((i1+i2)/i3);
		System.out.println(result);
		
	}
}
