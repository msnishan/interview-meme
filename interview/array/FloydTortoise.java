public class FloydTortoise {

    /**
     * Given array: [1, 3, 4, 2, 2]
     * return 2
     * 
     * array to linkedlist
     * 1 -> 3 -> 2 -> 4 -> 2
     */
    public static int findDuplicate(int[] input) {

        int slow = input[0];
        int fast = input[0];

        do {
            slow = input[slow];
            fast = input[input[fast]];
        } while(slow != fast);
        slow = input[0];

        while(slow != fast) {
            slow = input[slow];
            fast = input[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1, 3, 4, 2, 3}));
    }
}
