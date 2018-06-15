/*
 * If we sort all the numbers into buckets indexed by these numbers, this is essentially asking you to repetitively take an bucket while giving up the 2 buckets next to it. (the range of these numbers is [1, 10000])

The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

DP formula:
take[i] = skip[i-1] + values[i];
skip[i] = Math.max(skip[i-1], take[i-1]);
take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;

/**
 * for numbers from [1 - 10000], each has a total sum sums[i]; if you earn sums[i], you cannot earn sums[i-1] and sums[i+1]
 * kind of like house robbing. you cannot rob 2 connected houses.
 * 
 *
Java

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}
*/
    class 740DeleteandEarn {
    Map<Integer, Integer> val = new HashMap<Integer, Integer>();
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for ( int i : nums ) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        return help(map, list.get(0), list.get(map.size()-1));
    }
    public int help(Map map, int mark, int end) {
        if ( mark > end) return 0;
        int m1 = 0, m2 = 0;
        Integer mm1 = (Integer)map.getOrDefault(mark, 0), mm2 = (Integer)map.getOrDefault(mark+1, 0);
        if ( !val.containsKey(mark+2)) val.put(mark+2, help(map, mark+2, end));
            m1 = mm1 * mark + val.get(mark+2);
        if ( !val.containsKey(mark+3)) val.put(mark+3, help(map, mark + 3, end));
            m2 = mm2 * ( mark + 1) + val.get(mark+3);
        return Math.max(m1, m2);
    }
}