class 826MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> {
            int cmp = y[1] - x[1];
            if ( cmp == 0 ) cmp = x[0] - y[0];
            return cmp;
        });
        for ( int i = 0; i < n; i++ ) pq.offer(new int[]{difficulty[i], profit[i]});
        Arrays.sort(worker);
        int w = worker.length;
        int total = 0;
        Search:
        for ( int i = w - 1; i >= 0; i-- ) {
            while ( pq.peek()[0] > worker[i] ) {
                pq.poll();
                if ( pq.size() == 0 ) break Search;
            }
            total += pq.peek()[1];
        }
        return total;
    }
}