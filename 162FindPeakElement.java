/* This is O(logn), mine is O(n)......
 * This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.

If num[i-1] < num[i] > num[i+1], then num[i] is peak
If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
If num[i-1] > num[i] < num[i+1], then both sides have peak
(n is num.length)
Here is the code

public int findPeakElement(int[] num) {    
    return helper(num,0,num.length-1);
}

public int helper(int[] num,int start,int end){
    if(start == end){
        return start;
    }else if(start+1 == end){
        if(num[start] > num[end]) return start;
        return end;
    }else{
        
        int m = (start+end)/2;
        
        if(num[m] > num[m-1] && num[m] > num[m+1]){

            return m;

        }else if(num[m-1] > num[m] && num[m] > num[m+1]){

            return helper(num,start,m-1);

        }else{

            return helper(num,m+1,end);

        }
        
    }
}
*/
class 162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 0;
        if ( nums[0] > nums[1] ) return 0;
        if ( nums[n-2] < nums[n-1] ) return n-1;
        for ( int i = 1; i < n - 1; i++ ) {
            if ( nums[i] > nums[i-1] && nums[i] > nums[i+1] ) return i;
        }
        return 0;
    }
}