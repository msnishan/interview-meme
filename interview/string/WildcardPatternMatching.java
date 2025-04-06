package interview.string;

import java.util.Arrays;

public class WildcardPatternMatching {
    /**
     * Determines if the input string matches the given pattern.
     * Pattern may contain wildcard characters:
     *   '?' matches any single character.
     *   '*' matches any sequence of characters (including the empty sequence).
     *
     * This solution uses Dynamic Programming to check if the entire string matches the pattern.
     *
     * Time Complexity: O(m * n), where m = pattern length, n = string length
     * Space Complexity: O(m * n)
     * 
     * https://www.youtube.com/watch?v=3ZDZ-N0EPV0
     * 
     * 
     *
     * @param s the input string
     * @param p the pattern string (may include '?' and '*')
     * @return true if the string matches the pattern, false otherwise
     */
    public static boolean isMatch(String s, String p) {
        // TODO: Implement dynamic programming solution for wildcard matching


        char[] input = s.toCharArray();
        char[] pattern = new char[p.length()];
        
        boolean first = true;
        int patternLength = 0;
        for (int i = 0; i < p.length();i++) {
            if (p.charAt(i) == '*' && first) {
                pattern[patternLength++] = p.charAt(i);
                first = false;
            } else {
                pattern[patternLength++] = p.charAt(i);
                first = true;
            }
        }

        boolean[][] table = new boolean[s.length() + 1][patternLength + 1];

        table[0][0] = true;
        if (patternLength > 0 && pattern[0] == '*') {
            table[0][1] = true;
        }

        // System.out.println(Arrays.toString(input));
        // System.out.println(Arrays.toString(pattern));
        // System.out.println(Arrays.deepToString(table));


        for(int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                if (input[i - 1] == pattern[j - 1] || pattern[j - 1] == '?') {
                    table[i][j] = table[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    table[i][j] = table[i - 1][j] || table[i][j - 1];
                }
            }
        }
        
        return table[input.length][patternLength];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a*b"));    // true


        System.out.println(isMatch("aa", "a"));          // false
        System.out.println(isMatch("aa", "*"));          // true
        System.out.println(isMatch("cb", "?a"));         // false
        System.out.println(isMatch("acdcb", "a*c?b"));   // false
        System.out.println(isMatch("abcdef", "a*d*f"));  // true
    }
}
