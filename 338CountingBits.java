class 338CountingBits{
    public int[] countBits(int num) {
        int array[] = new int[num + 1];
        int count, temp, j;
        for ( int i = 0; i < num + 1; i++ ){
            temp = i;
            count = 0;
            while ( temp != 0 ){
                for ( j = 0; Math.pow(2,j) <= temp; j++ )
                    continue; //find the maximum 2^j for i
                temp -= Math.pow(2, j - 1);
                count++;
            }
            array[i] = count;            
        }
        return array;
            
        
    }
}
/*
 * Other solution
 * This uses the hint from the description about using ranges. Basically, the numbers in one range are equal to 1 plus all of the numbers in the ranges before it. If you write out the binary numbers, you can see that numbers 8-15 have the same pattern as 0-7 but with a 1 at the front.

My logic was to copy the previous values (starting at 0) until a power of 2 was hit (new range), at which point we just reset the t pointer back to 0 to begin the new range.

public int[] countBits(int num) {
    int[] ret = new int[num+1];
    ret[0] = 0;
    int pow = 1;
    for(int i = 1, t = 0; i <= num; i++, t++) {
        if(i == pow) {
            pow *= 2;
            t = 0;
        }
        ret[i] = ret[t] + 1;
    }
    return ret;
}
 */