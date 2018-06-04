class 477TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int mask, count, sum = 0;
      for ( int i = 31; i >= 0; i-- ) {
          mask = 1 << i;
          count = 0;
          for ( int j : nums ) {
              if ( (mask & j) != 0 )
                  count++;
          }
          sum += count * ( nums.length - count);
      }
        return sum;
    }
}