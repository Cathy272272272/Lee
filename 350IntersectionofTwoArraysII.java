What if elements of nums2 are stored on disk, and the memory is
limited such that you cannot load all elements into the memory at
once?

If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.

    
    /*
     * public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }
    
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
    
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
    
       return r;
    }
}
*/
class 350IntersectionofTwoArraysII {
    List<Integer> list = new ArrayList<Integer>();
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if ( n1 == 0 || n2 == 0 ) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        //List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        help(nums1, nums2, 0, 0);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void help(int[] nums1, int[] nums2, int i1, int i2) {
        int n1 = nums1.length, n2 = nums2.length;
        if ( i2 == n2 || i1 == n1 ) return;
        if ( nums1[i1] > nums2[i2] ) 
            help(nums1, nums2, i1, i2+1);
        else if ( nums1[i1] < nums2[i2] ) 
            help(nums1, nums2, i1 + 1, i2);
        else {
            list.add(nums1[i1]);
            help(nums1, nums2, i1 + 1, i2 + 1);
        }
    } 
}