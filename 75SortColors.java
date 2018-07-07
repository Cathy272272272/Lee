class 75SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int end = n - 1, start = 0, i = 0, tmp = 0;
        while ( i <= end && i >= start - 1 ) {
            if ( nums[i] == 2 ) {
                if ( i == end ) break;
                if ( nums[end] == 0 ) {
                    nums[i] = nums[start];
                    nums[start] = 0;
                    nums[end] = 2;
                    start++;
                    i = start + 1;
                    end--;
                }
                else if ( nums[end] == 1 ) {
                    nums[end] = 2;
                    nums[i] = nums[end - 1];
                    nums[end - 1] = 1;
                    end--;
                }
                else {
                    nums[i] = nums[end - 1];
                    nums[end - 1] = 2;
                    end -= 2;
                }
            }
            else if ( nums[i] == 0 ) {
                if ( i <= start - 1 ) i++;
                else if ( nums[start] == 0 ) {
                    start++;
                }
                else {
                    nums[i] = nums[start];
                    nums[start] = 0;
                    start++;
                }
            }
            else i++;
        }
    }
}