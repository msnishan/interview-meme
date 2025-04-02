

/**
 * 1. Find the subarray with the maximum sum (Kadane’s Algorithm)
 * Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

public class Kadane {

    public static int maxSubArray(int[] input) {

        int curr = input[0];
        int sum = input[0];
        for(int i = 1; i < input.length;i++) {
            if (curr + input[i] > input[i]) {
                curr = curr + input[i];
            } else {
                curr = input[i];
            }

            if (curr > sum) {
                sum = curr;
            }
        }

       return sum;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));

    }



}