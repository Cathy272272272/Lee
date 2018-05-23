/**
 * haha, jusr need to think, but not simply write recursions.
 */
 class 553OptimalDivision {
    public String optimalDivision(int[] nums) {
        StringBuilder out = new StringBuilder();
        if (nums.length >= 1 && nums.length <= 10 ){
            if ( nums.length == 1 )
                out.append(nums[0]);
            else if ( nums.length == 2 )
                out.append(nums[0]).append("/").append(nums[1]);
            else{
                out.append(nums[0]).append("/(");
                for ( int i = 1; i < nums.length - 1; i++ ){
                    out.append(nums[i]).append("/");
                }
                out.append(nums[nums.length - 1]).append(")");
            }
        }
        return out.toString();
    }
}