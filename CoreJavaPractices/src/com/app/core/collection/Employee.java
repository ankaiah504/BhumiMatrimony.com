package com.app.core.collection;

public class Employee {

	  String name;
	    int age;
	    double salary;

	    Employee(String name, int age,double salary) {
	        this.name = name;
	        this.age = age;
	        this.salary=salary;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }
	    public double getSalary() {
	        return salary;
	    }

		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
	    
}