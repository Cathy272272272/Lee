//Arrays.sort(nums);
class 462MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
    int N = nums.length;
    int sum = 0;
    /*for (int i = 0; i < N; i++)
        for (int j = i; j > 0; j--)
            if (nums[j] < nums[j-1]){
                temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
            else break;*/
    Arrays.sort(nums);
    for ( int i = 0; i < N; i++ )
        sum += Math.abs(nums[i] - nums[N/2]);
    return sum;
    }
}
