package com.yaksha.assignment;

public class StringComparisonConversionAssignment {

	public static void main(String[] args) {

		// Declare string variables
		String str1 = "hello";
		String str2 = "Hello";

		// 1. Perform string comparison: equals, equalsIgnoreCase, compareTo
		boolean isEqual = str1.equals(str2);
		boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2);
		int comparison = str1.compareTo(str2);

		// Print the results of string comparison
		System.out.println("Equals: " + isEqual);
		System.out.println("Equals Ignore Case: " + isEqualIgnoreCase);
		System.out.println("CompareTo: " + comparison);

		// Declare string variables
		String str = "  Trim me   ";

		// 2. Perform string conversion operations: valueOf, trim, split, toCharArray
		String trimmed = str.trim();
		String[] split = str.split(" ");
		char[] charArray = str.toCharArray();
		String strValue = String.valueOf(123);

		// Print the results of string conversion
		System.out.println("Trimmed: '" + trimmed + "'");
		System.out.println("Split: " + String.join(", ", split));
		System.out.println("CharArray: " + charArray);
		System.out.println("String Value of 123: " + strValue);
	}
}
