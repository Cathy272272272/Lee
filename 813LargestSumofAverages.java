/*search return the result for n first numbers to k groups.
It's top-down solution and it keeps all process to memory.
So it's like a DP solution while DP is bottom-up.
I took suggestion from @MonnaGotIt and added a prunting: if (n < k) return 0;

Time complexity: O(KN^2)

idea is similar to mine, but I use map, so slow...... I couldn't think of 2D array......
 *     public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[][] memo = new double[N+1][N+1];
        double cur = 0;
        for (int i = 0; i < N; ++i) {
            cur += A[i];
            memo[i + 1][1] = cur / (i + 1);
        }
        return search(N, K, A, memo);
    }

    public double search(int n, int k, int[] A, double[][] memo) {
        if (memo[n][k] > 0) return memo[n][k];
        if (n < k) return 0;
        double cur = 0;
        for (int i = n - 1; i > 0; --i) {
            cur += A[i];
            memo[n][k] = Math.max(memo[n][k], search(i, k - 1, A, memo) + cur / (n - i));
        }
        return memo[n][k];
    }
    */
class 813LargestSumofAverages {
    Map<List<Integer>,Double> map = new HashMap<List<Integer>, Double>();
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        if ( n == 0 ) return 0.0;
        double sum = 0.0, avg = 0.0; 
        double a = help(A, 0, K);
        return a;
    }
    public double help(int[] A, int start, int K) {
        int n = A.length;
        if ( n == 0 ) return 0.0;
        double sum = 0.0, avg = 0.0; 
        List<Integer> list = new ArrayList<Integer>();
        list.add(start);
        list.add(K);
        if ( map.containsKey(list)) return map.get(list);
        if ( K == 1 ) {
            for ( int i = start; i < n; i++ ) sum += A[i];
            map.put(list, sum / (n - start));
            return sum / (n - start);
        }
        double tmp = help(A, start + 1, K-1) + A[start];
        sum += A[start];
        for ( int i = start + 1; i < n - K + 1; i++ ) {
            sum += A[i];
            tmp = Math.max(tmp, sum / (i+1 - start) + help(A, i+1, K - 1));
        }
        map.put(list, tmp);
        return tmp;  
    }
}