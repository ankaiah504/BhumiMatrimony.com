package com.app.core.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysStream {

	public static void main(String[] args) {
		
		int[] arr= {1,2,3,5,6};
		Optional<Integer> str=Arrays.stream(arr).boxed().collect(Collectors.toList()).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println(str);
		String[] s= {"word","Test","verse","uuuuu"};
		
	String str1=	Arrays.stream(s).collect(Collectors.joining("-"));
	System.out.println(str1);
	String[] ch = {"H", "E", "L", "L", "O"};
	String result = Arrays.stream(ch)
	                      .collect(Collectors.joining());

	}

}
