package interview.string;

public class LongestPalindromicSubstring {
    /**
     * Finds the longest palindromic substring within the given input string.
     * A palindrome is a string that reads the same backward as forward.
     * This solution uses the Expand Around Center approach which checks all possible centers
     * (each character and between characters) and expands outward to find the maximum length palindrome.
     *
     * Time Complexity: O(n^2), Space Complexity: O(n)
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        // TODO: Implement the Expand Around Center approach

        int[] longest = new int[] {0, 0};
        
        for(int i = 1; i < s.length(); i++) {
            int[] oddPal = getLongestPalindrome(s, i - 1, i + 1);
            int[] evenPal = getLongestPalindrome(s, i - 1, i);

            int[] currentLongest = 
                (oddPal[1] - oddPal[0]) > (evenPal[1] - evenPal[0]) ? oddPal : evenPal;

            longest = (currentLongest[1] - currentLongest[0]) > (longest[1] - longest[0]) ?
                                currentLongest : longest;
        }

        return s.substring(longest[0], longest[1] + 1);
    }




    public static int[] getLongestPalindrome(String str, int left, int right) {
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new int[] {left + 1, right - 1}; 
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));   // Expected: "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));    // Expected: "bb"
        System.out.println(longestPalindrome("a"));       // Expected: "a"
        System.out.println(longestPalindrome("ac"));      // Expected: "a" or "c"
        System.out.println(longestPalindrome("racecar")); // Expected: "racecar"
        System.out.println(longestPalindrome("cbbd"));    // Expected: "bb"

    }
}
