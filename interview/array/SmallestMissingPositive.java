
import java.util.*;

public class SmallestMissingPositive {
    
    
    
    /**
     * 3. Find the first missing positive integer (Cyclic Sort)
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

        You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

        

        Example 1:

        Input: nums = [1,2,0]
        Output: 3
        Explanation: The numbers in the range [1,2] are all in the array.
        Example 2:

        Input: nums = [3,4,-1,1]
        Output: 2
        Explanation: 1 is in the array but 2 is missing.
        Example 3:

        Input: nums = [7,8,9,11,12]
        Output: 1
        Explanation: The smallest positive integer 1 is missing.

        [9,7,1,2,0,-1]
        

        Constraints:

        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
     */
    public static int smallestPositiveInteger(int[] input) {
        // cyclic sort
        for(int i = 0; i < input.length; i++) {
            if (input[i] > 0 && input[i] < input.length && input[i] != input[input[i] - 1]) {
                int temp = input[i];
                input[i] = input[temp - 1];
                input[temp - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(input));
        for(int i = 0; i < input.length; i++) {
            if (input[i] != i + 1) {
                return i + 1;
            }
        }


        return input.length + 1;
    }
    
    
    
    public static void main(String[] args) {
        System.out.println(smallestPositiveInteger(new int[] {3,4,-1,1}));
        System.out.println(smallestPositiveInteger(new int[] {7,8,9,11,12}));
        System.out.println(smallestPositiveInteger(new int[] {-5,-1}));
    }
}