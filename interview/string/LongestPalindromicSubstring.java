package interview.string;

public class LongestPalindromicSubstring {
    /**
     * Finds the longest palindromic substring within the given input string.
     * A palindrome is a string that reads the same backward as forward.
     * This solution uses the Expand Around Center approach which checks all possible centers
     * (each character and between characters) and expands outward to find the maximum length palindrome.
     *
     * Time Complexity: O(n^2), Space Complexity: O(1)
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        // TODO: Implement the Expand Around Center approach
        
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));   // Expected: "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));    // Expected: "bb"
        System.out.println(longestPalindrome("a"));       // Expected: "a"
        System.out.println(longestPalindrome("ac"));      // Expected: "a" or "c"
        System.out.println(longestPalindrome("racecar")); // Expected: "racecar"
    }
}
