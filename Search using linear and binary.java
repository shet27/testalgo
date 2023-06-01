package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        long startTime1, startTime2, endTime1, endTime2, executionTime1, executionTime2;

        int count = 100; // Number of random numbers to generate
        int min = 1; // Minimum random number
        int max = 1000; // Maximum random number

        // Generate random numbers until the set has the desired count
        while (numbers.size() < count) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            numbers.add(randomNumber);
        }

        // Print the generated numbers
        System.out.println(numbers);

        // Convert the set to an array
        Integer[] numbersArray = numbers.toArray(new Integer[0]);

        // Sort the array for binary search
        java.util.Arrays.sort(numbersArray);

        // Perform a linear search
        startTime1 = System.nanoTime();
        System.out.print("Enter the element you want to find: ");
        int searchNumber = scanner.nextInt(); // Number to search
        int linearSearchIndex = linearSearch(numbersArray, searchNumber);
        endTime1 = System.nanoTime();
        if (linearSearchIndex != -1) {
            System.out.println("Linear search: Found " + searchNumber + " at index " + linearSearchIndex);
        } else {
            System.out.println("Linear search: " + searchNumber + " not found");
        }

        // Perform a binary search
        startTime2 = System.nanoTime();
        int binarySearchIndex = binarySearch(numbersArray, searchNumber);
        endTime2 = System.nanoTime();

        if (binarySearchIndex != -1) {
            System.out.println("Binary search: Found " + searchNumber + " at index " + binarySearchIndex);
        } else {
            System.out.println("Binary search: " + searchNumber + " not found");
        }

        executionTime1 = endTime1 - startTime1;
        System.out.println("Execution time for linear search: " + executionTime1 + " ns");

        executionTime2 = endTime2 - startTime2;
        System.out.println("Execution time for binary search: " + executionTime2 + " ns");
    }

    // Linear search implementation
    private static int linearSearch(Integer[] numbers, int searchNumber) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchNumber) {
                return i;
            }
        }
        return -1; // Number not found
    }

    // Binary search implementation
    private static int binarySearch(Integer[] numbers, int searchNumber) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == searchNumber) {
                return mid; // Number found
            }

            if (numbers[mid] < searchNumber) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return -1; // Number not found
    }
}
