package interview.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /**
     * Finds the minimum window substring in 's' which contains all characters of 't'.
     * Characters in the window must match the count of characters in 't'.
     * Uses a sliding window and HashMap to efficiently find the minimum window.
     *
     * Time Complexity: O(n), where n is the length of s
     * Space Complexity: O(1) (since alphabet size is fixed)
     *
     * @param s the main string to search within
     * @param t the target string with required characters
     * @return the smallest substring of s containing all characters of t
     */
    public static String minWindow(String s, String t) {
        // TODO: Implement Sliding Window + HashMap solution

        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i< t.length();i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = count.size();
        int have = 0;

        int start = 0;

        int[] res = new int[]{-1, -1};
        int minLength = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            window.put(x, window.getOrDefault(x, 0) + 1);
            if (count.containsKey(x)) {
                if (window.get(x) == count.get(x)) {
                    have++;
                }
            }
            while (have == need) {
                int length = i - start + 1;
                if (length < minLength) {
                    minLength = length;
                    res[0] = start;
                    res[1] = i;
                }

                char temp = s.charAt(start); 
                window.put(temp, window.get(temp) - 1);
                if (count.containsKey(temp) && window.get(temp) < count.get(temp)) {
                    have--;
                }
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Expected: "BANC"
        System.out.println(minWindow("a", "a"));                // Expected: "a"
        System.out.println(minWindow("a", "aa"));               // Expected: ""
        System.out.println(minWindow("aa", "aa"));              // Expected: "aa"
        System.out.println(minWindow("abcdebdde", "bde"));      // Expected: "ebd"
    }
}
