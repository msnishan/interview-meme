package interview.string;

import java.util.Arrays;
import java.util.List;

public class WordBreakSolver {
    /**
     * Determines if the input string can be segmented into a sequence of one or more dictionary words.
     * Uses Dynamic Programming to solve the problem efficiently.
     *
     * @param s        The input string.
     * @param wordDict The list of valid dictionary words.
     * @return true if the string can be segmented, false otherwise.
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        // TODO: Implement using Dynamic Programming


        return wordBreak(s, wordDict, 0);
    }



    public static boolean wordBreak(String s, List<String> wordDict, int start) {
        if (s.length() == start) return true;
        for(int i = start; i < s.length(); i++) {
            String substr = s.substring(start, i + 1);
            if (wordDict.contains(substr)) {
                // System.out.println(substr);
                if (wordBreak(s, wordDict, i + 1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> dict1 = Arrays.asList("leet", "code");
        String str1 = "leetcode";
        System.out.println("Test 1: " + wordBreak(str1, dict1)); // Expected: true

        List<String> dict2 = Arrays.asList("apple", "pen");
        String str2 = "applepenapple";
        System.out.println("Test 2: " + wordBreak(str2, dict2)); // Expected: true

        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String str3 = "catsandog";
        System.out.println("Test 3: " + wordBreak(str3, dict3)); // Expected: false

        List<String> dict4 = Arrays.asList("apple", "applepen", "pine", "pineapple");
        String str4 = "pineapplepen";
        System.out.println("Test 3: " + wordBreak(str4, dict4)); // Expected: true
    }
}
