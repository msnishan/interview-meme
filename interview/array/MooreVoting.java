public class MooreVoting {
    

    
    /**
     * 4. You are given an array of N integers. A majority element is an element that 
     * appears more than ⌊N/2⌋ times in the array. Your task is to find and return 
     * the majority element. If no such element exists, return -1.
     * 
     * Input: nums = [3, 3, 4, 2, 3, 3, 3, 1]  
     * Output: 3  
     * Explanation: 3 appears 5 times, which is more than ⌊8/2⌋ = 4.
     * 
     * 
     * Input: nums = [1, 2, 3, 4, 5]  
     * Output: -1  
     * Explanation: No element appears more than ⌊5/2⌋ = 2 times.  
     * 
     * @param input
     * @return
     */
    
    public static int findMajority(int[] input) {
        int maxElement = input[0];
        int maxCount = 0;
        for(int i = 0; i < input.length; i++) {
            if (maxCount == 0) {
                maxElement = input[i];
                maxCount = 1;
            } else {
                if (maxElement == input[i]) {
                    maxCount++;
                } else {
                    maxCount--;
                }     
            }
        }
        maxCount = 0;
        for(int x: input) {
            if (x == maxElement) {
                maxCount++;
            }
        }
        return maxCount > input.length / 2 ? maxElement : -1;
    }


    public static void main(String[] args) {
        System.out.println(findMajority(new int[]{3, 3, 4, 2, 3, 3, 3, 1}));
        System.out.println(findMajority(new int[]{1, 2, 3, 4, 5}));
    }
}
