package homework2;

import java.util.Arrays;


public class MergeSort {
    /**
     * Wenhan Cai
     * CS 5006 homework 2-2
     *
     * Sort an array using merge sort
     *
     * @param array an arr of integers to be sorted
     * @return a sorted list of Integers
     */
    //Returns the left half of an array
    public static int[] leftHalf(int[] array) {
        int size_lefthalf = array.length / 2;
        int[] left = new int[size_lefthalf];
        for(int i = 0; i < size_lefthalf; i++){
            left[i] = array[i];
        }
        return left;
    }

    //Return the right half of an array
    public static int[] rightHalf(int[] array){
        int size_lefthalf = array.length / 2;
        int size_righthalf = array.length - size_lefthalf;
        int[] right = new int[size_righthalf];
        for(int i = 0; i< size_righthalf; i++){
            right[i] = array[i+size_lefthalf];
        }
        return right;
    }

    public static void merge(int[] result, int[] left, int[] right){
        int i_left = 0;
        int i_right = 0;

        for(int i = 0; i < result.length; i++){
            if(i_right>=right.length || (i_left < left.length && left[i_left] <= right[i_right])){
                result[i] = left[i_left];
                i_left++;
            }else{
                result[i] = right[i_right];
                i_right++;
            }
        }
    }

    public static void mergeSort(int[] array){
        if (array.length > 1){

            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public static void main(String[] args) {

        System.out.println("Test Case 1: ");
        int[] list1 = {1};
        System.out.println("Before sorting: " + Arrays.toString(list1));
        mergeSort(list1);
        System.out.println("After sorting:  " + Arrays.toString(list1));

        System.out.println("Test Case 2: ");
        int[] list2 = {};
        System.out.println("Before sorting: " + Arrays.toString(list2));
        mergeSort(list2);
        System.out.println("After sorting:  " + Arrays.toString(list2));

        System.out.println("Test Case 3: ");
        int[] list3 = {100, 3, 14, 55, 32, 30, 67, 76, 33, 77,
                34, 53, 72, 83, 90, 67, 8, 23, 46, 88,
                41, 65, 58, 85, 99, 54, 24, 87, 2, 10,
                22, 73, 62, 74, 52, 33, 15, 53, 26, 7,
                39, 9, 142, 111, 14, 45, 52, 80, 244, 24};
        System.out.println("Before sorting: " + Arrays.toString(list3));
        mergeSort(list3);
        System.out.println("After sorting:  " + Arrays.toString(list3));
    }

}
