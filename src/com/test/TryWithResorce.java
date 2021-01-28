package com.test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyResorce implements AutoCloseable
{

	@Override
	public void close() throws Exception {
		System.out.println("Close");
		throw new IOException();
	}
	}

public class TryWithResorce {

	public static void main(String[] args) {
	//	System.out.print(Stream.of(0).findAny().or(()-> Optional.of(1)).ifPresentOrElse(System.out::print,null));
		
		List<Integer> l1=List.of(1);
		List<Integer> l2=List.of(1,2);
		List<Integer> l3=List.of(1,3);
		List<Integer> l4=List.of(1,2,3);
		Stream<List<Integer>> list=Stream.of(l1,l2,l3,l4);
		list.flatMap(Collection::stream).distinct().peek(System.out::print).noneMatch(i->i>0);
	//	list.flatMap(l-> l.stream()).distinct().peek(System.out::print).noneMatch(i->i>0);
//		System.out.println(list.flatMap(Collection::stream).distinct().peek(System.out::println).noneMatch(i->i>0));;
		//	System.out.println(list.flatMap(l-> l.stream()).distinct().peek(System.out::println).noneMatch(i->i>0));;
		
		
		Stream<Integer> stream=Stream.of(1,3,5);
		Optional<Optional<Integer>> optional=Optional.of(stream.filter(i-> i%2==0).
				reduce(Integer::sum));
		System.out.println(optional.get());
		
		String sou=Stream.of(new StringBuffer("US"),new StringBuffer("Uk")).parallel()
				.collect(Collectors.joining("-","=",""));
		System.out.println(sou);
		
		String souf=Stream.of(new String("US"),new String("Uk")).parallel()
				.collect(Collectors.joining("-","=",""));
		System.out.println(souf);
		
		String souString=Stream.of("hi","fi","hh").parallel()
				.reduce("-",(s1,s2)-> s1+s2);
		System.out.println(souString);
		
		try(MyResorce m=new MyResorce()){
			throw new NullPointerException();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
}
