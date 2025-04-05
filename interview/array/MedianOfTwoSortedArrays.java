public class MedianOfTwoSortedArrays {
    /**
     * Finds the median of two sorted arrays using Binary Search.
     *
     * Approach:
     * - Perform binary search on the smaller array.
     * - Partition the arrays to balance left and right halves.
     * - Use conditions to find the correct partitioning point.
     *
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     * 
     * https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
     *
     * @param nums1 The first sorted array.
     * @param nums2 The second sorted array.
     * @return The median value.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TODO: Implement the logic using Binary Search

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = nums1.length;
        int n = nums1.length + nums2.length;

        while(low <= high) {
            int partA = (low + high)/2;
            int partB = (n + 1)/2 - partA;

            int partAl = partA == 0 ? Integer.MIN_VALUE : nums1[partA - 1];
            int partAr = partA == nums1.length ? Integer.MAX_VALUE : nums1[partA];

            int partBl = partB == 0 ? Integer.MIN_VALUE : nums2[partB - 1];
            int partBr = partB == nums2.length ? Integer.MAX_VALUE : nums2[partB];

            if (partAl <= partBr && partBl <= partAr) {
                if (n % 2 == 0) {
                    return (Math.max(partAl, partBl) + Math.min(partAr, partBr)) / 2.0;
                } else {
                    return Math.max(partAl, partBl);
                }
            }

            else if (partAl > partBr) {
                high = partA - 1;
            } else {
                low = partA + 1;
            }

        }



        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2)); // Expected: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median: " + findMedianSortedArrays(nums3, nums4)); // Expected: 2.5

        int[] nums5 = {1, 5, 8, 10, 15, 18};
        int[] nums6 = {2, 3, 7, 12, 14, 20, 22, 25};
        System.out.println("Median: " + findMedianSortedArrays(nums5, nums6)); // Expected: 11

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums8 = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109};
        System.out.println("Median: " + findMedianSortedArrays(nums7, nums8)); // Expected: 55
    }
}
