package homework4;

/**
 * Wenhan Cai
 * CS 5006 homework 4-1
 * Build a Max Heap
 */
public class MaxHeap {

    private int[] heap;
    private int size;  //size points to the last element in the array
    private int capacity;

    /**
     * constructor
     * @param capacity
     */
    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity+1];  //due to the placeholder at the front, the actually size should be capacity+1
        this.size = 0;  //size points to the placeholder when initialize, and move to next every time a new element is pushed into array
        heap[0] = Integer.MAX_VALUE;  //occupy the front of the array with a placeholder when initialize; the placeholder will be left untouched throughout the process
    }

    /**
     * create a heap with a given array
     * @param arr
     */
    public void createHeap(int[] arr){
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++){
                push(arr[i]);
            }
        }
    }

    /**
     * display heap
     */
    public void print(){
        for(int i = 1; i < heap.length; i++){
            System.out.print(heap[i]+" ");
        }
    }

    /**
     * utility method: get the index of the left child of the give index
     * @param index
     * @return int
     */
    private int leftChild(int index){
        return 2 * index;
    }

    /**
     * utility method: get the index of the right child of the give index
     * @param index
     * @return int
     */
    private int rightChild(int index){
        return 2 * index + 1;
    }

    /**
     * utility method: get the index of the parent of the give index
     * @param index
     * @return int
     */
    private int parent(int index){
        return index / 2;
    }

    /**
     * utility method: swap two elements of the given indexes in the array
     * @param a
     * @param b
     */
    private void swap(int a, int b){
        int  temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    /**
     * utility method: after pushing an element into the heap, bubble up the element if it violates heap property
     * @param index
     */
    private void siftUp(int index){
        while(index > 0 && heap[parent(index)] < heap[index]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * return true if the heap is empty, otherwise false
     * @return boolean
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * push a new element into the heap, return true if successful, false otherwise
     * @param x
     * @return boolean
     */
    public boolean push(int x){
        if(size == capacity){
            System.out.println("Heap is full.");
            return false;
        }
        size++;
        heap[size] = x;
        siftUp(size);
        return true;
    }

    /**
     * utility method: after popping the maximum element in heap and replace it with the last element, shift down the
     * element if it violates heap property
     * @param index
     */
    private void siftDown(int index){
        while(leftChild(index) <= size ){  //while heap[index] is not a leaf in heap
            int temp = leftChild(index);
            if(temp + 1 < size && heap[temp+1] > heap[temp]){
                temp = rightChild(index);  //at this point, temp is the index of leftChild or rightChild of index, whichever is bigger
            }
            if(heap[index]> heap[temp]){
                break;
            }
            swap(index, temp);
            index = temp;
        }
    }

    /**
     * extract the root of heap and replace it with the last element in array, then shift down the new root element if
     * it violates heap property
     * @return the maximum element in the array (also the root of heap)
     */
    public int pop(){
        if(size < 1){
            throw new IllegalArgumentException("Pop failed because the heap is empty.");
        }
        int max = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        siftDown(1);
        size--;
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,56,5,33,7,10,20,30};
        MaxHeap testHeap = new MaxHeap(10);
        System.out.println("-----MaxHeapTestResult isEmpty()-----");
        System.out.println(testHeap.isEmpty());
        System.out.println("-----Build a Max Heap with the given array: {2,4,1,56,5,33,7,10,20,30} -----(capacity: 10)");
        testHeap.createHeap(arr);
        testHeap.print();
        System.out.println("\n-----MaxHeapTestResult pop()-----");
        System.out.println("popped element: "+testHeap.pop());
        System.out.print("Heap after pop: ");
        testHeap.print();
        System.out.println("\n-----MaxHeapTestResult push()-----");
        testHeap.push(1);
        System.out.println("Element to be pushed: 1");
        System.out.println("Heap after pushing a new element: ");
        testHeap.print();
        System.out.println("\n-----MaxHeapTestResult push element into a full heap-----");
        testHeap.push(100);
        System.out.println("-----MaxHeapTestResult pop an empty heap-----");
        MaxHeap emptyHeap = new MaxHeap(0);
        System.out.println(emptyHeap.pop());
    }
}
