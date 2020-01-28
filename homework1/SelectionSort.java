package homework1;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class SelectionSort {
    /**
     * Wenhan Cai
     * CS 5006 homework 1-1
     *
     * Sort an array using selection sort
     *
     * @param arr an arr of integers to be sorted
     * @return a sorted list of Integers
     */
    public static ArrayList<Integer> selectionSort(List<Integer> arr) {
        for(int i = 0; i<arr.size() - 1; i++){
            int minIndex = i;
            for (int j = i+1; j<arr.size(); j++){
                if(arr.get(minIndex) > arr.get(j)){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
        return (ArrayList<Integer>) arr;
    }
    /**
     * This method tests the Selection Sort by generating 100 integers randomly (from -500 to 500) and sort them
     *
     * @param args unused
     */
    public static void main(String[] args) {

        List<Integer> testArr = new ArrayList<Integer>();
        for (int i = 1; i<= 100; i++){
            Random random = new Random();
            int r = random.nextInt(1000) -500;
            testArr.add(r);
        }
        System.out.println("------Randomly generated array: -----------");
        System.out.println(testArr);

        System.out.println("--------------Sorted Array: ---------------");
        ArrayList<Integer> resultArr = selectionSort(testArr);
        System.out.print(resultArr);
        for (int i = 0; i < resultArr.size()-1; i++){
            if (resultArr.get(i) - resultArr.get(i+1) > 0){ // Check if the previous integer is larger than the following one
                System.out.println("The array is not sorted.");
            }
        }
        System.out.println(" ");
        System.out.println("The array is sorted.");
    }
}
