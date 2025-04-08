package interview.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {


    /**
     * Generates all unique permutations of the input string.
     * Uses backtracking to explore all possibilities.
     *
     * @param s Input string (may contain duplicate characters)
     * @return List of unique permutations
     */
    public static List<String> generatePermutations(String s) {
        // TODO: Implement this using backtracking
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<String> result1 = generatePermutations("abc");
        System.out.println("Permutations of 'abc': " + result1);
        // Expected Output (in any order):
        // ["abc", "acb", "bac", "bca", "cab", "cba"]

        List<String> result2 = generatePermutations("aab");
        System.out.println("Permutations of 'aab': " + result2);
        // Expected Output (in any order):
        // ["aab", "aba", "baa"]

        List<String> result3 = generatePermutations("aaa");
        System.out.println("Permutations of 'aaa': " + result3);
        // Expected Output:
        // ["aaa"]
    }
}
