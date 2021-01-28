package com.test;

import java.util.function.Predicate;



interface Interf {
	public void m1(); 
}

public class Demo implements AutoCloseable{
	int x = 10;
	public void m2() {
		int y =10;
		Interf i =()-> {
			int x=100;
			x=10000;
			System.out.println(this.x+"::"+y+"::"+x);
		};
		i.m1();
	}
	
	
	public static void main(String[] args) {
		
		Predicate<Comparable> p = i -> i==null ;
		System.out.println(p.test(100));
		System.out.println(p.test(7));
		System.out.println(p.test(true)); //CE
	 Demo d =new Demo();
	 d.m2();
	 
	 try(Demo demo1=new Demo()){
		 throw new ArithmeticException();
	 }
	 
	}


	@Override
	public void close()  {
		throw new RuntimeException("Errro");
		
	}
}
