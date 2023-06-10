import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Search {

    // Function to generate random numbers
    //new line added
    public static List<Integer> generateRandomNumbers(int start, int end, int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {  
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, count);
    }

    public static void main(String[] args) {
        int startNumber = 1;
        int endNumber = 1000;
        int count = 100;

        List<Integer> randomNumbers = generateRandomNumbers(startNumber, endNumber, count);
        Collections.sort(randomNumbers); // Sort the numbers
        System.out.println(randomNumbers);

        // To search for an element in array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an element to search: ");
        int key = scanner.nextInt();

        // Linear search
        long startTime = System.nanoTime();
        boolean found = false;
        int linearIndex = -1;
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) == key) {
                found = true;
                linearIndex = i;
                break;
            }
        }
        long endTime = System.nanoTime();

        // Binary search
        long startTime1 = System.nanoTime();
        boolean flag = false;
        int low = 0;
        int high = randomNumbers.size() - 1;
        int binaryIndex = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (randomNumbers.get(mid) == key) {
                flag = true;
                binaryIndex = mid;
                break;
            } else if (randomNumbers.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long endTime1 = System.nanoTime();

        if (found) {
            System.out.println("The element " + key + " is present at index " + linearIndex + " (Linear search)");
        } else {
            System.out.println(key + " not found (Linear search)");
        }

        if (flag) {
            System.out.println("The element " + key + " is present at index " + binaryIndex + " (Binary search)");
        } else {
            System.out.println(key + " not found (Binary search)");
        }

        // Time for linear search
        double executionTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Execution time for linear search: " + executionTime + " ms");

        // Time for binary search
        double executionTime1 = (endTime1 - startTime1) / 1_000_000.0;
        System.out.println("Execution time for binary search: " + executionTime1 + " ms");
    }
}
