/*
 *     public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
    */
class 496NextGreaterElementI{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length];
        int mark;
            if ( nums2.length == 0 )
                for ( int i = 0; i < nums1.length; i++ )
                    array[i] = -1;
            else {                                 
                for ( int i = 0; i < nums1.length; i++ )
                    for ( int j = 0; j < nums2.length; j++ )
                        if ( nums1[i] == nums2[j] ){
                            if ( j == nums2.length - 1 )
                                array[i] = -1;
                            else {
                                mark = j + 1;
                                while ( nums2[mark] <= nums2[j] ){
                                    mark++;
                                    if ( mark == nums2.length )
                                        break;
                                }
                                if ( mark != nums2.length )
                                    array[i] = nums2[mark];
                                else
                                    array[i] = -1;
                            }
                            break;
                        }
                }
        return array;
    }
}