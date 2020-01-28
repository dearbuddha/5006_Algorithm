package homework1;

public class StringMatching {
    /**
     * Wenhan Cai
     * CS 5006 homework 1-2
     *
     * Check if candidate string appears anywhere in the corpus string
     *
     * @param corpus a string to be searched for
     * @param candidate a string to be searched in
     * @return boolean
     */
    public static boolean stringMatching(String corpus, String candidate){
        return corpus.contains(candidate);
    }

    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {
        String corpus = "computerscienceissomuchfunhaha"; // a string of 30 characters
        String candidate = "hah"; // a string of 3 characters
        System.out.println(stringMatching(corpus,candidate));
    }
}

/*
• What might break a string matching function? [Give at least 2 reasons]
- The candidate string is longer than the corpus string
- The corpus string is simply too large to be searched in.

• What is the big O time complexity of your string matching? (in terms of n and m)
- O(mn)

• Your boss wants a more powerful string matcher – what 3 things might they ask for and how would you handle the requests?
1. They might want to know the position where the candidate string starts to match the corpus string
 - Integrate .indexof() into the method.
2. They might want a faster searching algorithm - say O(logn) or even O(n)
 - One possible way is to use a more advanced data structure to store the corpus string.
3. They might want to know how many times does the pattern of the candidate string appears in the corpus string
 - have to rewrite the method and use a variable to record each time a match appears.
 */
