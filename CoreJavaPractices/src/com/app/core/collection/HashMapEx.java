package com.app.core.collection;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HashMapEx {

	public static void main(String[] args) {
	HashMap<Integer,String> m=new HashMap<Integer,String>();
	
	m.put(1, "Anki");
	m.put(2, "Ramu");
	m.put(3, "Love");
//	System.out.print("output"+m);
	m.put(3, "Shivani");
	m.put(null, "Shivani");
	m.put(null, "Rijg");
	m.putIfAbsent(5,"Anki143");
	m.remove(5);
	 Map<String, Integer> budget = new HashMap<>();
	    budget.put("clothes", 120);
	    budget.put("grocery", 150);
	    budget.put("transportation", 100);
	    budget.put("utility", 130);
	    budget.put("rent", 1150);
	    budget.put("miscellneous", 90);
	    Map<String, Integer> sorted = budget .entrySet() .stream() .sorted(comparingByValue()) .collect( toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
	    System.out.println("map after sorting by values: " + sorted);

	 // above code can be cleaned a bit by using method reference
	    sorted = budget
	        .entrySet()
	        .stream()
	        .sorted(comparingByValue())
	        .collect(
	            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));

	    // now let's sort the map in decreasing order of value
	    sorted = budget
	        .entrySet()
	        .stream()
	        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	        .collect(
	            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));

	    System.out.println("map after sorting by values in descending order: "
	        + sorted);
	    List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
	    String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", "));
System.out.println(G7Countries);

//Create List of square of all distinct numbers 
List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4); 
List<Integer> distinct = numbers.stream() .map( i -> i*i).distinct() .collect(Collectors.toList()); 
System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);

//Get count, min, max, sum, and average for numbers
 List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
 IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();
 System.out.println("Highest prime number in List : " + stats.getMax());
 System.out.println("Lowest prime number in List : " + stats.getMin());
 System.out.println("Sum of all prime numbers : " + stats.getSum());
 System.out.println("Average of all prime numbers : " + stats.getAverage());

 

	}
}
