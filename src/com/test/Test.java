package com.test;

public class Test {
	public static void main(String[] args) {
		C c =new C();
		c.m1();

		P p =new P();
		p.m1();
		
		P p2=new C();
		p2.m1();
	
	}
	
	
	
}
class P {
public static void m1() {
	System.out.println("p");
}
}
class C extends P {
public static void m1() {
	System.out.println("C");

}
}
