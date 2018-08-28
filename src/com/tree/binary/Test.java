package com.tree.binary;

enum Student 
{
	John(11), Bella(10), Sam(13), Viraaj(9);
	private int age;                   
	public int getage()
	{
		return age; 
	}  //method defined in enum Student
	Student(int age)  //constructor defined in enum Student
	{
	  this.age= age;
	  System.out.println("Calling constructor");
	}
}

public class Test {

	public static void main(String[] args) {
		
	}
}




