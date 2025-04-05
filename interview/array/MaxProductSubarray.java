public class MaxProductSubarray  {
    
    

    /**
     * Finds the maximum product subarray in a given integer array.
     * The function computes the maximum product of any contiguous subarray.
     * 
     * Approach:
     * - Uses dynamic programming with two variables:
     *   1. maxProd: Tracks the maximum product ending at the current index.
     *   2. minProd: Tracks the minimum product (to handle negatives).
     * - Iterates through the array once in O(N) time complexity.
     * 
     * @param nums The input array of integers.
     * @return The maximum product of any contiguous subarray.
     */
    // Method to find the maximum product subarray
    public static int maxProduct(int[] nums) {
        // Implement the logic here
        int max = nums[0];
        int min = nums[0];
        for(int x : nums) {
            int tempMax = Math.max(max * x, x);
            tempMax = Math.max(tempMax, min * x);

            int tempMin = Math.min(max * x, x);
            tempMin = Math.min(tempMin, min * x);

            max = tempMax;
            min = tempMin;
        }
        return max;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Max Product: " + maxProduct(nums1)); // Expected: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println("Max Product: " + maxProduct(nums2)); // Expected: 0

        int[] nums3 = {1, -2, -3, 4};
        System.out.println("Max Product: " + maxProduct(nums3)); // Expected: 24
    }
}
