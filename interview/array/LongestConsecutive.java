import java.util.*;
import java.util.stream.Collectors;
public class LongestConsecutive {
    
    /**
     * Input: nums = [2,20,4,10,3,4,5]
     * Output: 4
     *
     * Input: nums = [0,3,2,5,4,6,1,1]
     * Output: 7
     * 
     * 
     */
    public static int findConsecutive(int[] input) {
        Set<Integer> inputSet = Arrays.stream(input).boxed()
                                    .collect(Collectors.toSet());
        int maxLength = 0;
        for(Integer x: inputSet) {
            if (!inputSet.contains(x - 1)) {
                int y = x;
                int temp = 0;
                while(inputSet.contains(y)) {
                    temp++;
                    y++;
                }
                if (temp > maxLength) {
                    maxLength = temp;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findConsecutive(new int[] {2,20,4,10,3,4,5}));
        System.out.println(findConsecutive(new int[] {0,3,2,5,4,6,1,1}));
    }
}
