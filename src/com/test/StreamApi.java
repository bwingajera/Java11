package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
	
	public static void main(String[] args) {
	
		List<Integer> myList = new ArrayList<>();
		for(int i=10; i<20; i++) myList.add(i);
		System.out.println(myList);
		
		System.out.println(myList.stream().reduce(10,(i,j)-> i+j));
		
		List l=myList.stream().filter((var i)-> i%2==0).collect(Collectors.toList());
		System.out.println(l);
		
		l=myList.stream().map((var i)-> i*i).collect(Collectors.toList());
		System.out.println(l);
		
		Optional<Integer> k=myList.stream().reduce((i,j)-> i+j);
		System.out.println("Reduce ::: "+k.get());
		
		long count=myList.stream().count();
		System.out.println(count);
		
		System.out.println(myList.stream().anyMatch((var i)-> i==4));;
		System.out.println(myList.stream().allMatch((var i)-> i==4));;
		System.out.println(myList.stream().noneMatch((var i)-> 	i==4));;
		System.out.println(myList.stream().dropWhile(i-> i>4).collect(Collectors.toList()));;
		System.out.println(myList.stream().findAny().get());;
		System.out.println(myList.stream().findFirst().get());;
		//System.out.println(myList.stream().pee)(i-> i*i));;
	
		System.out.println(myList.stream().max(Comparator.comparing(Integer::longValue)));;
		System.out.println("Sum ::"+myList.stream().mapToInt(i->i).min());;

		System.out.println(myList.stream().min(Comparator.comparing(Integer::longValue)).orElseThrow());;

		System.out.println(myList.stream().sorted((var i,var j)-> j.compareTo(i)).collect(Collectors.toList()));;
		
		System.out.println(myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));;
		
	//	l.forEach(System.out::print);
		
		

		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		Stream<Integer> stream = ss.parallelStream();
		 
		stream.map(s -> {
		        synchronized (result) {
		          if (result.size() < 10) {
		            result.add(s);
		          }
		        }
				return s;
		    }).forEach( e -> {});
	//	 System.out.println(result);   
	}
	
	
}
