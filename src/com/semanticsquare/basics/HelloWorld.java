package com.semanticsquare.basics;

public class HelloWorld{
	

	public static void main(String[] args){
		System.out.println("Hello world");
		Bitch b = new Bitch();
		System.out.println(b.age);
	}
}

class Bitch {
	int age = 90;
}