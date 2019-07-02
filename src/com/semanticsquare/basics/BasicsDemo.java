package com.semanticsquare.basics;

public class BasicsDemo{

	public static void foo(){
		System.out.println("Inside foo...");
	}

	public void stringExamples(){
		System.out.println("Inside stringExamples()...");

		String s = "Hello World";
		System.out.println("s: " + s);

		System.out.println("s.length(): " + s.length());
		System.out.println("s.isEmpty(): " + s.isEmpty());

		// Comparison
		System.out.println("\n\ns.equals(\"Hello World\")" + s.equals("Hello World"));
		System.out.println("s.equals(\"Hello World\")" + s.equals("hello world"));
		System.out.println("s.equalsIgnoreCase( \"hello world\" ): " + s.equalsIgnoreCase("hello world"));
		System.out.println("s.compareTo( \"Hello World\" ): " + s.compareTo("Hello World"));
		System.out.println("s.compareTo( \"hello world\" ): " + s.compareTo("hello world"));

		// Searching
		System.out.println();
		System.out.println();
		System.out.println("s.contains( \"HELLO WORLD\" ): " + s.contains("HELLO WORLD"));
		System.out.println("s.contains( \"Hello\" ): " + s.contains("Hello"));
		System.out.println("s.startsWith(\"He\"): " + s.startsWith("He"));
		System.out.println("s.endsWith(\"ld\"): " + s.endsWith("ld"));
		System.out.println("s.indexOf(\"ll\"): " + s.indexOf("ll"));
		System.out.println("s.indexOf(\'o\'): " + s.indexOf('o'));
		System.out.println("s.lastIndexOf(\'o\'): " + s.lastIndexOf('o'));

		// Examing individual characters
		System.out.println();
		System.out.println("s.charAt(4): " + s.charAt(4));

		// Extracting substring
		System.out.println();
		System.out.println("s.substring(4):" + s.substring(4));
		System.out.println("s.substring(4, 9):" + s.substring(4, 9));

		// Case conversion
		System.out.println();
		System.out.println("s.toLowerCase(): " + s.toLowerCase());
		System.out.println("s.toUpperCase(): " + s.toUpperCase());
		System.out.println("s.trim(): " + s.trim());

		// Replace
		System.out.println();
		System.out.println("s.replaceAll(\"o\", \"X\"):" + s.replaceAll("o", "X"));

		// Split
		System.out.println();
		System.out.println("String[] strings = s.split(\"o\"):" );
		String[] strings = s.split("o");
		for (String s1 : strings) {
			System.out.println(s1);
		}

		// Static methods
		System.out.println("String.valueOf(1.3): " + String.valueOf(1.3));

	}

	public static void main(String[] args) {
		BasicsDemo bd = new BasicsDemo();
		bd.stringExamples();
	}
}