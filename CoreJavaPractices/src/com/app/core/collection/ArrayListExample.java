package com.app.core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayListExample {
	 
	public static void main(String[] args) {
		
		//
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7); //duplicate 
		primes.add(7);
		primes.add(11); // let's print arraylist with duplicate System.out.println("list of prime numbers : " + primes);
        ArrayList newList = new ArrayList<>(); 
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25,4500),
                new Employee("Bob", 35,3444),
                new Employee("Charlie", 32,4564),
                new Employee("Charlie", 32,656)
            );
//       
  List<Employee> emp= employees.stream().filter(e->e.getAge()>30).sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getAge)).collect(Collectors.toList());
  System.out.println("Sorted by Name (Ascending):");
  emp.forEach(System.out::println);
  double averageSalary = employees.stream()
          .mapToDouble(Employee::getSalary) // Convert to a DoubleStream
          .average() // Calculate the average
          .orElse(0.0); // Default value if no employees
  double max = employees.stream()
          .mapToDouble(Employee::getSalary) // Convert to a DoubleStream
          .max() // Calculate the average
          .orElse(0.0); // Default value if no employees
  System.out.println("Average Salary: " + max);

   

  //        List<Employee> sortedByNameAsc = employees.stream()
//                .sorted(Comparator.comparing(Employee::getName))
//                .collect(Collectors.toList());
//
//        System.out.println("Sorted by Name (Ascending):");
//        sortedByNameAsc.forEach(System.out::println);     
//		List<Integer> li=primes.stream().distinct().collect(Collectors.toList());
//		System.out.println("set123"+li);
//		Integer li1=primes.stream().max(Integer::compare).get();
//		 Collections.reverse(primes);
//		System.out.println("set123sgdgsfsg"+primes);
//       
//		ArrayList<String> list=new ArrayList<String>();
//		
//		list.add("Anki");
//		list.add("Ramu");
//		list.add("Test");
//		list.add("test");
//		list.add("Anki");
//		list.add("Ramu");
//	Map<String, Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//	
//	System.out.println("Map"+map); 
//	
//Optional<String> name=	list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
//List<String> dup=list.stream().distinct().collect(Collectors.toList());
//long map2=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).count();
//String join=list.stream().collect(Collectors.joining("-"));
//StringJoiner l2=new StringJoiner("-");
//
//list.forEach(l2::add);
//
//String resultWithJoiner = l2.toString();
//
//System.out.println("Find second++"+resultWithJoiner);
	
	
	}

}
