package interview.string;

import java.util.*;

public class GroupAnagrams {
    /**
     * Groups anagrams from the input array of strings.
     *
     * @param strs The array of strings.
     * @return A list of grouped anagram lists.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // TODO: Implement using HashMap with sorted key

        Map<String, List<String>> buffer = new HashMap<>();
        for(String x: strs) {
            int[] code = new int[26];
            for(Character y: x.toCharArray()) {
                code[y - 'a']++;
            }
            StringBuilder hash = new StringBuilder();
            for(int ch: code) {
                hash.append('#');
                hash.append(ch);
            }
            buffer.computeIfAbsent(hash.toString(), k -> new ArrayList<>()).add(x);
        }

        return new ArrayList<>(buffer.values());
    }

    public static void main(String[] args) {
        // Test case 1
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input1));
        // Expected: [["eat","tea","ate"], ["tan","nat"], ["bat"]]

        // Test case 2
        String[] input2 = {""};
        System.out.println(groupAnagrams(input2));
        // Expected: [[""]]

        // Test case 3
        String[] input3 = {"a"};
        System.out.println(groupAnagrams(input3));
        // Expected: [["a"]]
    }
}
