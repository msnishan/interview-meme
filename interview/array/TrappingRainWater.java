public class TrappingRainWater {
    

    /**
     * Given an array height[] of N non-negative integers representing the elevation 
     * map where the width of each bar is 1, compute how much water it can trap after raining.
     * 
     * Input: arr[] = [3, 0, 1, 0, 4, 0, 2]
        Output: 10
        Explanation: The expected rainwater to be trapped is shown in the above image.
        https://www.geeksforgeeks.org/trapping-rain-water/

        Input: arr[] = [3, 0, 2, 0, 4]
        Output: 7
        Explanation: We trap 0 + 3 + 1 + 3 + 0 = 7 units.


        Input: arr[] = [1, 2, 3, 4]
        Output: 0
        Explanation: We cannot trap water as there is no height bound on both sides


        Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
        Output: 9
        Explanation : We trap 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units of water.  
     * 
     * @param input
     * @return
     */
    public static int maxWater(int[] input) {

        int sum = 0;
        int lM = input[0];
        int rM = input[input.length - 1];
        int left = 1;
        int right = input.length - 2;
        while(left <= right) {
            if (rM < lM) {
                sum += input[right] < rM ? rM - input[right] : 0;
                rM = Math.max(rM, input[right]);
                right--;
            } else {
                sum += input[left] < lM ? lM - input[left] : 0;
                lM = Math.max(lM, input[left]);
                left++;
            }
        }
        
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(maxWater(new int []{3, 0, 1, 0, 4, 0, 2}));
    }
}
