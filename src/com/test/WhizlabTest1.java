package com.test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

interface Foo{
	boolean compare(boolean f,boolean f1);
}


public class WhizlabTest1 {

	
	long log () {
		return 1;
	}
	
	public static boolean compare(boolean f,boolean f1) {
		return true;
	}
	public static void main(String[] args) {

		try {}catch (Exception e) {
			e=new RuntimeException();
			// TODO: handle exception
		}
		Foo foo1=(foo2,foo3)->foo2 && foo3; 
		Foo foo2=(b,b1)->b || b1; 
		Foo foo3=(b1,b2)->foo2.compare(b1, b2); 
		System.out.println(foo1.compare(true, true));
		
		
		
		Path pa = Paths.get("/home/sterlite/Downloads/runtime_jars_bkp/a");
		Path p = pa.resolve("sdsds/bar");
		
		Path path = Path.of("/home/sterlite/Downloads/runtime_jars_bkp/a");
		
		//Path directories = Files.createDirectories(path.getParent());
		System.out.println(path.getParent());
		
		System.out.println(Stream.of(1,2,3,4).reduce(0,(a,b)-> a<b ? a:b));
		int iq=0,i2=0;
		Stream<String> s=Stream.of("United","states","dfd	");
		BinaryOperator<String> operator=(s1,s2)-> s1.concat(s2.toUpperCase());
		String result=s.reduce("-",operator);
		System.out.println(result);
		

	//	System.out.println(Stream.of(1,2,3,4).reduce(0,(a,b)-> a<b ? a:b));

		Stream<Integer> stream=Stream.of(-2,-1,0,1,2,-3);
		Predicate<Integer> positive=i->{
	//		System.out.print(i);
			return i>0;
		};
		Predicate<Integer> negative=i->{
//			System.out.print(i);
			return i<0;
		};
		stream.filter(positive).allMatch(negative);
		
		
		
		Person p1=new Person(20, "test");
		Person p2=new Person(25, "demo");
		Person p3=new Person(30, "abc");
		Person p4=new Person(28, "xyz");
		Optional<Person> opo=Stream.of(p2,p1,p3,p4).max((pp1,pp2)->pp1.age+pp2.age);
	//	System.out.println(opo.get().name);
		
		Person p6=Stream.of(p2,p1,p3,p4).findAny().orElse(getPerson());
		System.out.println(p6.name);
		
		
		List<Integer> list= List.of(2,3,4);
		System.out.println(list.stream().reduce(1,Integer::sum,(a,b)-> { return a*b;}));
		
		System.out.println(Stream.of(0).findAny().orElse(increse()));
		System.out.println(i);
		
		
		System.out.println(list.stream().reduce(1,Integer::sum,(a,b)->  a*b));
		System.out.println(list.stream().parallel().reduce(1,Integer::sum,(a,b)->  a*b));
		
		
		System.out.println(List.of(2.0,3.0,4.0).stream().parallel().reduce(1.0,Double::sum,(a,b)->  a*b));

	}
	
	static Person getPerson() {
		System.out.println("dddd");
		return new Person(30, "ytttttt");
	}
	
	
	int a;
	static int i;
	static int increse() {
		System.out.println("Increse");
		return ++i;
	}
	
	
	
	
	
	
	
	
	
	
}
class Person{
	int age;
	String name;
	
	public Person(int age,String name) {
		this.age=age;
		this.name=name;
	}
}


