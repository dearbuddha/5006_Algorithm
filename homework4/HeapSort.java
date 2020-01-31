package homework4;

import java.util.Arrays;

/**
 * Wenhan Cai
 * CS 5006 homework 4-2
 * Build a Max Heap
 */
public class HeapSort {
    /**
     * Use Max Heap to sort a given arr
     * @param arr
     * @return arr[]
     */
    public static int[] heapSort(int[] arr){
        MaxHeap heap = new MaxHeap(arr.length);
        heap.createHeap(arr);
        for(int i = arr.length-1; i>=0; i--){
            arr[i] = heap.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr= {15, 17, 5, 32, 16, 29, 32, 41, 22, 34, 19, 31, 50, 11, 10, 2, 40, 41, 29, 37};
        System.out.println(Arrays.toString(heapSort(arr)));
    }
}
