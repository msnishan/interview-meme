package interview.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakSolverOptimized {
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

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        var wordSet = new HashSet<>(wordDict);

        for(int i = 1; i< s.length() + 1;i++) {
            for(int j = 0; j < i;j++) {
                if (dp[j] && wordSet.contains(s.substring(j , i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

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
