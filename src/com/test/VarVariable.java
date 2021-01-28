package com.test;

import java.util.function.Function;
import java.util.function.Supplier;

public class VarVariable {

public static void main(String[] args) {
	VarVariable v=new  VarVariable();
	//v.m6(x);
}
	
void m1(int x) {
    int y =10;
    foo(() -> x+y);
    // Legal: x and y are both effectively final.
    
}
	
void m2(int x) {
    int y;
    y = 1;
    foo(() -> x+y);
    // Legal: x and y are both effectively final.
}

void m3(int x) {
	int j=10;
    int y;
    if (j>0) y = 1;
   // foo(() -> x+y);
    // Illegal: y is effectively final, but not definitely assigned.
}

void m4(int x) {
    int y;
    if (false) y = 1; else y = 2;
    foo(() -> x+y);
    // Legal: x and y are both effectively final.
}

void m5(int x) {
    int y;
    if (true) y = 1;
    y = 2;
    foo(() -> x+y);
    // Illegal: y is not effectively final.
}

void m6(int x) {
    foo(() -> x+1);
    x++;
    System.out.println(x);
    // Illegal: x is not effectively final.
}

void m7(int x) {
  //  foo(() -> x=1);
    // Illegal: x is not effectively final.
}

void m8() {
    int y;
//    foo(() -> y=1);
    // Illegal: y is not definitely assigned before the lambda.
}

void m9(String[] arr) {
    for (String s : arr) {
        foo(() -> s);
        // Legal: s is effectively final
        // (it is a new variable on each iteration)
    }
}

void m10(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
        foo(() -> arr[i]);
        // Illegal: i is not effectively final
        // (it is not final, and is incremented)
    }
}

private void foo(Supplier s) {
	// TODO Auto-generated method stub
	
}

}
