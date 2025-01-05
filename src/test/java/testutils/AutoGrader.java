package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

    // Test for string comparison and string conversion methods
	public boolean testStringComparisonAndConversion(String filePath) throws IOException {
        System.out.println("Starting testStringComparisonAndConversion with file: " + filePath);

        // Load participant's file
        File participantFile = new File(filePath); // Path to participant's file
        if (!participantFile.exists()) {
            System.out.println("File does not exist at path: " + filePath);
            return false;
        }

        // Parse the file using JavaParser
        FileInputStream fileInputStream = new FileInputStream(participantFile);
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try {
            cu = javaParser.parse(fileInputStream).getResult()
                    .orElseThrow(() -> new IOException("Failed to parse the Java file"));
        } catch (IOException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
            throw e;
        }

        System.out.println("Parsed the Java file successfully.");

        // Flags to check for string comparison and conversion methods
        boolean hasComparisonMethods = false;
        boolean hasConversionMethods = false;

        // 1. Checking String Comparison Methods (equals, equalsIgnoreCase, compareTo)
        System.out.println("------ Checking String Comparison Methods ------");
        for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
            String methodName = method.getNameAsString();
            if (methodName.equals("equals") || methodName.equals("equalsIgnoreCase") ||
                methodName.equals("compareTo")) {
                hasComparisonMethods = true;
                System.out.println("✓ Found string comparison method: " + methodName);
            }
        }

        // Output the result for string comparison methods
        if (hasComparisonMethods) {
            System.out.println("✓ String comparison methods are present.");
        } else {
            System.out.println("✘ Missing string comparison methods.");
        }

        // 2. Checking String Conversion Methods (valueOf, trim, split, toCharArray)
        System.out.println("------ Checking String Conversion Methods ------");
        for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
            String methodName = method.getNameAsString();
            if (methodName.equals("valueOf") || methodName.equals("trim") ||
                methodName.equals("split") || methodName.equals("toCharArray")) {
                hasConversionMethods = true;
                System.out.println("✓ Found string conversion method: " + methodName);
            }
        }

        // Output the result for string conversion methods
        if (hasConversionMethods) {
            System.out.println("✓ String conversion methods are present.");
        } else {
            System.out.println("✘ Missing string conversion methods.");
        }

        // Test result
        boolean result = hasComparisonMethods && hasConversionMethods;
        System.out.println("Test result: " + result);

        return result;
    }
}
