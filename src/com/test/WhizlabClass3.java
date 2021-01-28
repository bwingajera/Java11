package com.test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class Data {
	int number;
	Data(int i){
		this.number=number;
	}
}

class Data1 {
	String number;
	Data1(String i){
		this.number=number;
	}
}


public class WhizlabClass3 {

	static int add (int i2, int i1) {
		System.out.println(0);
		return i1+i2;
	} 
	
	public static void main(String[] args) {
		
		String s = List.of("a","b","a","b").stream().collect(String::new, (a,b)->b.concat(a),
				(a,b)->a.concat(b));			
		System.out.println("s ::::"+s);
	
		String s2 = Stream.of("a","b").collect(String::new, (a,b)->a.concat(b),
				(a,b)->a.concat(b));
		 System.out.println("ss ::::"+s2);
		 
			String s3 = List.of("a","b").stream().collect(String::new, (a,b)->a.concat(b),
					(a,b)->a.concat(b));
			System.out.println("s3 ::::"+s3);
		
			String s4 = Stream.of("a","b").collect(String::new, (a,b)->a.concat(b),
					(a,b)->a.concat(b));
			 System.out.println("s4 ::::"+s4);
			 
		
	
		Function<Integer, Integer> function=(Integer i)-> i;
		Data data1=new Data(1);
		Data data2=new Data(2);
		Stream.of(new Data1("dd"),new Data1("ddd")).sorted();
		
		
		int result=Stream.of(data1,data2).reduce(0,(d1,d2)-> d1+d2.number,WhizlabClass3::add);
		System.out.println(result);
		
		Stream.of(0,1,2,3).peek(i-> {
			if(i%2!=0)
				System.out.println(i);
		}).forEach(i-> {
			if(i%2==0)
				System.out.println(i);
		});;
		
		
		
		

		Stream.of(0,1,2,3).filter(i-> i >2).forEach(i-> {
			if(i%2==0)
				System.out.println(i);
		});;

		
	}
}
