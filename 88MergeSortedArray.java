/*
 * class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr = m + n -1;
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[ptr] = nums1[ptr1];
                ptr1--;
            }
            else {
                nums1[ptr] = nums2[ptr2];
                ptr2--;
            }
            ptr--;
        }
        while (ptr2 >= 0) {
            nums1[ptr] = nums2[ptr2];
            ptr2--;
            ptr--;
        }
    }
}
*/
class 88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = 0, tmp = 0;
        if ( n == 0 ) return;
        for ( int i = 0; i < m + n; i++ ) {
            if ( i >= m ) nums1[i] = nums2[idx++];
            else if ( nums1[i] > nums2[idx] ) {
                tmp = nums2[idx];
                nums2[idx] = nums1[i];
                nums1[i] = tmp;  
                Arrays.sort(nums2);
            }
        }
    }
}