package com.semanticsquare.basics;

public class BasicsDemo{

	public static void foo(){
		System.out.println("Inside foo...");
	}

	public void stringExamples(){
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		BasicsDemo bd = new BasicsDemo();
		bd.stringExamples();
	}
}