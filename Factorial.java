public class Factorial {
    /**
     * Return the factorial of a number
     *
     * @param n the number to compute factorial for
     * @return the factorial of the number
     */
    public static int factorial(int n) {
        if (n<=0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    /**
     * This method tests the factorial function.
     * @param args unused
     */
    public static void main(String[] args) {
        int value = 5;
        int factVal = factorial(value);
        System.out.println(factVal);
        System.out.printf("The value of %d! is %d\n", value, factVal);
    }
}
