import java.util.Arrays;

public class MoveKElementsReversalAlgorithm {
    

    /**
     * Input: nums = [1, 2, 3, 4, 5, 6, 7], K = 3  
     * Output: [5, 6, 7, 1, 2, 3, 4]  
     * @param input
     * @param k
     */
    public static void moveByKElements(int[] input, int k) {
        reverse(input, 0, input.length - 1);
        reverse(input, 0, k - 1);
        reverse(input, k, input.length - 1);        
    }


    public static void reverse(int[] input, int start, int end) {
        while(start < end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;            
        }
    }



    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        moveByKElements(input, 3);
        System.out.println(Arrays.toString(input));
    }

}
