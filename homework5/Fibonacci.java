package homework5;

import java.util.HashMap;
import java.util.Map;

/**
 * Wenhan Cai
 * CS 5006 homework 5
 * Fibonacci using memoization
 */
public class Fibonacci{

    int n;
    Map<Integer, Integer> cache;

    public Fibonacci(int n, Map<Integer, Integer> cache){
        this.n = n;
        this.cache = cache;
    }

    public int fib(int n) {
        if(n<0){
            System.out.println("A return value of -9999 means illegal input number.");
            return -9999;
        }
        if(n <= 1) return n;
        if(this.cache.containsKey(n)) return cache.get(n);
        int res = fib(n-1) + fib(n-2);
        this.cache.put(n, res);
        return res;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> cache = new HashMap<>();
        Fibonacci fibonacci = new Fibonacci(0, cache);

        System.out.println("-----------------fib 0 to 10----------------------");

        for(int i = 0; i <= 10; i++){
            System.out.println("The fib of "+ i +" is " + fibonacci.fib(i));
        }

        int[] set = {2, 4, 6, 10, 5, 9, 13, 7, -1, 21, 17, 11};
        System.out.println("--------------------------Provided test cases---------------------------");

        for(int i = 0; i < set.length; i++){
            System.out.println("The fib of "+set[i]+" is " + fibonacci.fib(set[i]));
        }
    }
}
