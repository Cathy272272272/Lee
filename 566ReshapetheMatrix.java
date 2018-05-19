class 566ReshapetheMatrix{
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] array = new int[r][c];
        int x = 0;
        int y = 0;
        if ( nums.length <= 100 && nums[0].length >= 0 && nums.length >= 0 && nums[0].length <= 100 ){
            if ( r * c != nums.length * nums[0].length )
                return nums;
            else{
                for ( int i = 0; i < nums.length; i++ )
                    for ( int j = 0; j < nums[0].length; j++ ){
                        if ( x + 1 > c ){
                            x = 0;
                            y++;
                        }
                        array[y][x] = nums[i][j];
                        x++;
                    }
            }
        }
        return array;
    }
}