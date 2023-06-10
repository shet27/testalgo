 package org.example;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.Random;
 import java.util.Scanner;

 public class Main {

     public static void main(String[] args) {
         // TODO Auto-generated method stub
         //comment

         ArrayList<Integer> numbers = new ArrayList<>();
         Random random = new Random();
         Scanner SC = new Scanner(System.in);

         long startTime1,startTime2,endTime1,endTime2,executionTime1,executionTime2;

         // Generate 100 random double values and add them to the ArrayList
         for (int i = 0; i < 1000; i++) {
             numbers.add(random.nextInt(100));
         }
         //Collections.shuffle(Arrays.asList(numbers));

         // Sort the ArrayList for binary search
         Collections.sort(numbers);

         System.out.println(numbers);

         // Perform a linear search
         startTime1 = System.nanoTime();
         System.out.print("Enter the element you want to find:");
         int searchNumber =SC.nextInt(); // Number to search
         int linearSearchIndex = linearSearch(numbers, searchNumber);
         endTime1 = System.nanoTime();
         if (linearSearchIndex != -1) {
             System.out.println("Linear search: Found " + searchNumber + " at index " + linearSearchIndex);
         } else {
             System.out.println("Linear search: " + searchNumber + " not found");
         }

         // Perform a binary search
         startTime2 = System.nanoTime();
         int binarySearchIndex = binarySearch(numbers, searchNumber);
         endTime2 = System.nanoTime();

         if (binarySearchIndex != -1) {
             System.out.println("Binary search: Found " + searchNumber + " at index " + binarySearchIndex);
         } else {
             System.out.println("Binary search: " + searchNumber + " not found");
         }

         executionTime1 = (endTime1 - startTime1);
         System.out.println("Execution time for linear search : " + executionTime1 + " s");

         executionTime2 = (endTime2 - startTime2);
         System.out.println("Execution time for binary search : " + executionTime2 + " s");

     }

     // Linear search implementation

     private static int linearSearch(ArrayList<Integer> numbers, int searchNumber) {

         for (int i = 0; i < numbers.size(); i++) {
             if (numbers.get(i) == searchNumber) {
                 return i;
             }
         }
         return -1; // Number not found
     }
     // Binary search implementation
     private static int binarySearch(ArrayList<Integer> numbers, int searchNumber) {
         int left = 0;
         int right = numbers.size() - 1;

         while (left <= right) {
             int mid = left + (right - left) / 2;

             if (numbers.get(mid) == searchNumber) {
                 return mid; // Number found
             }

             if (numbers.get(mid) < searchNumber) {
                 left = mid + 1; // Search the right half
             } else {
                 right = mid - 1; // Search the left half
             }
         }

         return -1; // Number not found
     }

 }