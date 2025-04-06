package interview.string;

public class LongestRepeatingCharReplacement {



    /**
     * Finds the length of the longest substring containing the same letter after at most k replacements.
     * https://www.youtube.com/watch?v=gqXU1UyA8pk
     * @param s The input string consisting of uppercase English letters.
     * @param k The maximum number of characters that can be replaced.
     * @return The length of the longest valid substring.
     */
    public static int characterReplacement(String s, int k) {
        // TODO: Implement sliding window logic here

        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        int[] buffer = new int[26];
        for(int i = 0; i < s.length(); i++) {
            buffer[s.charAt(i) - 'A'] = buffer[s.charAt(i) - 'A'] + 1;
            maxCount = Math.max(maxCount, buffer[s.charAt(i) - 'A']);
            int size = i - start + 1;
            if (size - maxCount > k) {
                buffer[s.charAt(start) - 'A'] = buffer[s.charAt(start) - 'A'] - 1;
                start++;
            } else {
                maxLength = Math.max(maxLength, size);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(characterReplacement("ABAB", 2));      // Expected: 4
        System.out.println(characterReplacement("AABABBA", 1));   // Expected: 4
        System.out.println(characterReplacement("AAAA", 2));      // Expected: 4
        System.out.println(characterReplacement("ABCDE", 1));     // Expected: 2
    }
}
