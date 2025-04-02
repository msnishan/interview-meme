public class SearchInSortedRotatedArray {
    
    
    /**
     * Input: nums = [4,5,6,7,0,1,2], target = 0  
     * Output: 4
     * 
     * Input: nums = [3,4,5,6,7,0,1], target = 3  
     * Output: -1  (Not Found)
     * 
     *  
     * @param input
     * @param l
     * @return
     */
    public static int findInRotatedArray(int[] input, int l) {

        int low = 0;
        int high = input.length - 1;
        int mid = (low + high) / 2;
        while(low <= high) {
            mid = (low + high) / 2;
            if (input[mid] == l) {
                return mid;
            }
            if (input[low] <= input[mid]) {
                if (l <= input[mid] && l >= input[low] ) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (l >= input[mid] && l <= input[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }  

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findInRotatedArray(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(findInRotatedArray(new int[] {7, 8, 9, 1, 2, 3, 4, 5, 6}, 1));
    }
}