/*
 * vector<int> twoSum(vector<int>& numbers, int target) {
    int lo=0, hi=numbers.size()-1;
    while (numbers[lo]+numbers[hi]!=target){
        if (numbers[lo]+numbers[hi]<target){
            lo++;
        } else {
            hi--;
        }
    }
    return vector<int>({lo+1,hi+1});
}
*/
class 167TwoSumII-InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int lo = 0;
        int hi = n - 1;
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        int[] res = new int[2];
        if ( find(list.subList(1, n), target - list.get(0)) != -1 ) {
            res[0] = 1;
            res[1] = find(list.subList(1, n), target - list.get(0)) + 2;
            return res;
        }
        if ( find(list.subList(0,n - 1), target - list.get(n - 1)) != -1 ) {
            res[1] = n;
            res[0] = find(list.subList(0, n - 1), target - list.get(n - 1)) + 1;
            return res;
        }
        for ( int i = 1; i < n - 1; i++ ) {
            int first = find(list.subList(0,i), target - numbers[i]) + 1;
            int second = find(list.subList(i+1,n), target - numbers[i]) + 2 + i;
            if ( first == 0 && second == i + 1) continue;
            res[0] = i + 1;
            res[1] = first + second;
            return res;
        }
        return res;
    }
    public int find(List<Integer> list, int tar ) {
        int n = list.size();
        int lo = 0, hi = n - 1;
        while ( lo <= hi ) {
            if ( tar < list.get((lo+hi)/2) ) {
                hi = (lo+hi)/2 - 1;
            }
            else if ( tar > list.get((lo+hi)/2) ) {
                lo = (lo+hi)/2 + 1;
            }
            else
                return (lo+hi)/2;
        }
        return -1;
    }
}