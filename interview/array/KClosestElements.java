import java.util.*;

public class KClosestElements {
    /**
     * Finds the K closest elements to a given number X in a sorted array.
     * 
     * Approach:
     * - Use binary search to find the closest starting point for X.
     * - Use two pointers to expand left and right to find the K closest elements.
     * - Return the result sorted in ascending order.
     * 
     * Time Complexity: O(log N + K), where log N is for binary search, and K for two-pointer expansion.
     * Space Complexity: O(K), since we store only K elements.
     *
     * @param nums The sorted input array.
     * @param k Number of closest elements to find.
     * @param x The target number.
     * @return A list of K closest elements sorted in ascending order.
     */
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        // Implement the logic here

        int closestRight = Arrays.binarySearch(nums, x);
        if (closestRight < 0)
            closestRight = -closestRight - 1;
        int closetLeft = closestRight - 1;

        // System.out.println(closetLeft);
        // System.out.println(closestRight);

        List<Integer> result = new ArrayList<>();
        while(k > 0) {
            if (closetLeft < 0)
                closestRight++;
            else if (closestRight >= nums.length) 
                closetLeft--;
            else if (Math.abs(x - nums[closetLeft]) < Math.abs(x - nums[closestRight]))
                closetLeft--;
            else 
                closestRight++;
            k--;
        }        
        for(int i = closetLeft + 1; i < closestRight; i++) {
            result.add(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Closest Elements: " + findClosestElements(nums1, 3, 3)); // Expected: [2, 3, 4]

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Closest Elements: " + findClosestElements(nums2, 4, -1)); // Expected: [1, 2, 3, 4]

        int[] nums3 = {1, 3, 5, 7, 9};
        System.out.println("Closest Elements: " + findClosestElements(nums3, 2, 6)); // Expected: [5, 7]
    }
}
