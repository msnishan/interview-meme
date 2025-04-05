

import java.util.*;

public class SubarraySumEqualsK {
    /**
     * Finds the number of subarrays that sum to k using Prefix Sum + HashMap.
     *
     * @param nums The input array.
     * @param k The target sum.
     * @return The number of subarrays whose sum equals k.
     */
    public static int subarraySum(int[] nums, int k) {
        // TODO: Implement the logic using Prefix Sum + HashMap

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prfix = 0;
        int count = 0;

        for(int i = 0; i< nums.length; i++) {
            prfix += nums[i];

            int offset = prfix - k;
            if (map.containsKey(offset)) {
                count += map.get(offset);   
            }
            map.put(prfix, map.getOrDefault(prfix, 0) + 1);

        }

        return count;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 1, 1};
        System.out.println("Result: " + subarraySum(nums1, 2)); // Expected: 2

        int[] nums2 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println("Result: " + subarraySum(nums2, 7)); // Expected: 4
        // [3,4], [7], [7,2,-3,1], [1,4,2]

        int[] nums3 = {1, 2, 3};
        System.out.println("Result: " + subarraySum(nums3, 3)); // Expected: 2
    }
}
