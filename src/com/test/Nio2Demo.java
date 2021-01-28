package com.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2Demo {

	static int  a,b=8;
	
	public static void main(String[] args) {
		
		
		Path path = Paths.get("/home/sterlite/Downloads/runtime_jars_bkp");
		System.out.println(path);
		System.out.println(path.getFileName());
		System.out.println(path.getName(2));
		System.out.println(path.getNameCount());
		
	
		System.out.println(path.getRoot());
		System.out.println(path.getNameCount());
		
		Path pa = Paths.get("/wws/dd");
		Path p = pa.resolveSibling("bar");
		System.out.println(p);
		
		
		
		
		Path p1 = Paths.get("/home/sterlite/Downloads/../../");
		Path p2 = p1.normalize();
		System.out.println(p1);
		System.out.println(p1.getNameCount());
		System.out.println(p2);
		System.out.println(p2.getNameCount());
		
		
		Path p3 = Paths.get("dd/home/sterlite/Downloads/");
		Path p4 = Paths.get("crestelsetup");
		
		Path p3_p4 = p3.relativize(p4);
		System.out.println(p3_p4);

		Path p4_p3 = p4.relativize(p3);
		System.out.println(p4_p3);
		System.out.println(a+""+b);
	}
	
	
}
