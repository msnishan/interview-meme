package interview.string;

public class AnagramChecker {
    /**
     * Checks if two strings are anagrams of each other. Only single type cases
     *
     * @param s First string.
     * @param t Second string.
     * @return true if s and t are anagrams, false otherwise.
     */
    public static boolean isAnagram(String s, String t) {
        // TODO: Implement using HashMap to compare character counts

        if (s.length() != t.length()) return false;
        int[] buffer = new int[26];
        for(int i = 0; i< s.length();i++) {
            buffer[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i< t.length();i++) {
            int res = buffer[t.charAt(i) - 'a'];
            if (res == 0) return false;
            buffer[t.charAt(i) - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(isAnagram("anagram", "nagaram")); // Expected: true

        // Test case 2
        System.out.println(isAnagram("rat", "car")); // Expected: false

        // Test case 3
        System.out.println(isAnagram("listen", "silent")); // Expected: true

        // Test case 4
        System.out.println(isAnagram("aacc", "ccac")); // Expected: false

        // Test case 5
        System.out.println(isAnagram("aabb", "ab")); // Expected: false
    }
}
