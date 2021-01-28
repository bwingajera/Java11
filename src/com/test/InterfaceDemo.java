package com.test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

interface Too{
	String text="Too";
	static void print() {
		System.out.println(text);
	}
}

interface Bar extends Too{
	String text="Bar";
	/*
	 * default void print() { System.out.println(text); }
	 */
	void print();
}


public class InterfaceDemo implements Bar{
	//String text="IToo";
	
	public static void main(String[] args) {
		String souString=Stream.of("hi","fi").parallel()
				.reduce("-",(s1,s2)-> s1+s2);
		System.out.println(souString);
		
		
		BiFunction<Integer, Integer,Integer> iw=(final Integer i,final Integer j)-> i+j;
		Too too=new InterfaceDemo();
		//too.print();
		System.out.println(too.text);
		System.out.println(text);
		//		too.text;
	
		int a=0;
		int b=0;
		System.out.println(Integer.valueOf(text).equals(a)	);
		//Too too=new InterfaceDemo();
		
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}
