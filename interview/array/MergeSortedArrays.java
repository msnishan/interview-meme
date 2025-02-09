
import java.util.Arrays;

public class MergeSortedArrays {

    
    /**
     * Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in 
     * non-decreasing order. Merge them in sorted order. 
     * Modify arr1 so that it contains the first N elements and modify arr2 so that it 
     * contains the last M elements.
     * 
     * input  A = [1, 4, 7, 8, 10]  B = [2, 3, 9]  
     * output A = [1, 2, 3, 4, 7]   B = [8, 9, 10]  
     */
    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int len = m + n;
        int gap = (int) Math.ceil(len/2);
        while(gap > 0) {
            int l = 0;
            int r = l + gap;
            while(r < len) {
                if (l < n && r >= n) {
                    swap(arr1, arr2, l, r - n);
                } else if (l >= n) {
                    swap(arr2, arr2, l - n, r - n);
                } else {
                    swap(arr1, arr1, l, r);
                }
                l++;
                r++;
            }
            if (gap == 1) break;
            gap = (int) Math.ceil(gap/2);

        }
    }

    public static void swap(int[] arrA, int[] arrB, int i, int j) {
        if (arrA[i] > arrB[j]) {
            int temp = arrA[i];
            arrA[i] = arrB[j];
            arrB[j] = temp;
        }
    }    
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 7, 8, 10};
        int[] arr2 = new int[]{2, 3, 9};
        mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}