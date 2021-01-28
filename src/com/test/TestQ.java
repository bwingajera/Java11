package com.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestQ {

	public static void main(String[] args) {
		Stream<Integer> values = IntStream.rangeClosed(10, 15).boxed(); //1
		
		Stream<Integer> ls1=IntStream.of(1).boxed();
		
		List<Integer> ls = Arrays.asList(1, 2, 3);
		ls.stream().forEach(System.out::print);
	
		ls.forEach(System.out::print);

		
		List<Integer> list= List.of(2,3);
		System.out.println(list.stream().parallel().reduce(1.0,Double::sum,(a, b)-> { return a*b;}));
	
		System.out.println(Optional.of(0).orElse(1));
		
		 Path p1 = Paths.get("/company/records/customers.dat");
		 Path p2 = p1.resolveSibling("/ss/sss");
		 System.out.println(p2.toString());
		
		List<Integer> myList = new ArrayList<>();
		for(int i=10; i<20; i++) myList.add(i);
		System.out.println(myList);
		myList.stream().mapToDouble(i->i).reduce( (a, b)->a+b).getAsDouble();
		System.out.println(myList.stream().map(i->i).reduce( (a, b)->a+b));;
		
		Stream<Integer> stream=list.stream();
		stream.filter(i->i>9);
		stream.forEach(System.out::println);
		
	}
}
