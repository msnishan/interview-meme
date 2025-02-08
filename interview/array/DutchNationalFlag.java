
import java.util.*;

public class DutchNationalFlag {
    
    

    

    /**
     * Given an array consisting of only 0s, 1s, and 2s. The task is to sort the given array. The solution should put all 0s first, then all 1s and all 2s in last.
        [1,2,0,1,0,2,2,1,0] => [0,0,0,1,1,1,2,2,2]



     */
    public static void dnf(int[] input) {
        
        int low = 0, mid = 0;
        int high = input.length - 1;

        while(mid < high) {
            if (input[mid] == 0) {
                input[mid] = input[low];
                input[low] = 0;
                low++;
                mid++;
            } else if (input[mid] == 1) {
                mid++;
            } else if (input[mid] == 2) {
                input[mid] = input[high];
                input[high] = 2;
                high--;
            }
        }
    }



    public static void main(String[] args) { 
        var input = new int[] {1,2,0,1,0,2,2,1,0};
        dnf(input);
        System.err.println(Arrays.toString(input));
    }
}