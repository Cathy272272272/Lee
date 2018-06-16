//My first dp attempt......
class 746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] help = new int[n+1];
        return help(cost, 0, help);
    }
    public int help(int[] cost, int s, int[] help) {
        int n = cost.length;
        if ( s >= n - 1 ) return 0;
        if ( help[s] == 0 ) help[s] = Math.min(cost[s] + help(cost, s+1, help), cost[s+1] + help(cost, s+2, help));
        return help[s];
    }
}