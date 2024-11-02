package com.app.stream.api;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayList {

	public static void main(String[] args) {
		
		int[] itr = {2, 4, 2, 4, 9, 45};
		Map<Integer, Long> map=Arrays.stream(itr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
//		for(int i=0;i<itr.length;i++) {
//
//			
//		}

	}

}
