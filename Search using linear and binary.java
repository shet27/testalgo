//Program to assign 100 values and search using binary and linear
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SearchArrayList {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(rand.nextDouble());
        }
        double searchValue = 0.5;
        int linearIndex = linearSearch(list, searchValue);
        System.out.println("Linear search: " + linearIndex);
        Collections.sort(list);
        int binaryIndex = binarySearch(list, searchValue);
        System.out.println("Binary search: " + binaryIndex);
    }

    public static int linearSearch(ArrayList<Double> list, double value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(ArrayList<Double> list, double value) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == value) {
                return mid;
            } else if (list.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
