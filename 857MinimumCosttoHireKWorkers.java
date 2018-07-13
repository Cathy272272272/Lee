/*
 * Let's read description first and figure out the two rules:

"1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group."
So for any two workers in the paid group,
we have wage[i] : wage[j] = quality[i] : quality[j]
So we have wage[i] : quality[i] = wage[j] : quality[j]
We pay wage to every worker in the group with the same ratio compared to his own quality.

"2. Every worker in the paid group must be paid at least their minimum wage expectation."
For every worker, he has an expected ratio of wage compared to his quality.

So to minimize the total wage, we want a small ratio.
So we sort all workers with their exoected ratio, and pick up K first worker.
Now we have a minimum possible ratio for K worker and we their total quality.

As we pick up next worker with bigger ratio, we increase the ratio for whole group.
Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
We calculate the current ratio * total quality = total wage for this group.

We redo the process and we can find the minimum total wage.
Because workers are sorted by ratio of wage/quality.
For every ratio, we find the minimum possible total quality of K workers.

Time Complexity
O(NlogN) for sort.
O(NlogK) for priority queue.

C++:

    double mincostToHireWorkers(vector<int> q, vector<int> w, int K) {
        vector<vector<double>> workers;
        for (int i = 0; i < q.size(); ++i)
            workers.push_back({(double)(w[i]) / q[i], (double)q[i]});
        sort(workers.begin(), workers.end());
        double res = DBL_MAX, qsum = 0;
        priority_queue<int> pq;
        for (auto worker: workers) {
            qsum += worker[1], pq.push(worker[1]);
            if (pq.size() > K) qsum -= pq.top(), pq.pop();
            if (pq.size() == K) res = min(res, qsum * worker[0]);
        }
        return res;
    }
Java:

    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
Python:

    def mincostToHireWorkers(self, quality, wage, K):
        workers = sorted([float(w) / q, q] for w, q in zip(wage, quality))
        res = float('inf')
        qsum = 0
        heap = []
        for r, q in workers:
            heapq.heappush(heap, -q)
            qsum += q
            if len(heap) > K: qsum += heapq.heappop(heap)
            if len(heap) == K: res = min(res, qsum * r)
        return res
FAQ:
Question: "However, it is possible that current worker has the highest quality, so you removed his quality in the last step, which leads to the problem that you are "using his ratio without him".
Answer: It doesn't matter. The same group will be calculated earlier with smaller ratio.
And it doesn't obey my logic here: For a given ratio of wage/quality, find minimum total wage of K workers
*/
class 857MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = wage.length;
        if ( K > n ) return 0;
        double[] r = new double[n];
        TreeMap<Double, List<Double>> map = new TreeMap<Double, List<Double>>();
        double sum = 0, min = Double.MAX_VALUE;
        for ( int i = 0; i < n; i++ ) {
            r[i] = (double)wage[i] / (double)quality[i];
            List<Double> list = map.getOrDefault(r[i], new ArrayList<Double>());
            list.add((double)quality[i]);
            map.put(r[i], list);
            sum += quality[i];
            min = Math.min(min, wage[i]);
        }
        if ( K == 1 ) return min;
        if ( K == n ) return sum * map.lastKey();
        double pay = Double.MAX_VALUE;
        Double key = map.lastKey();
        System.out.println(map);
        List<Double> v = new ArrayList<Double>();
        for ( List<Double> i : map.values() ) v.addAll(i);
        Collections.sort(v);
        while ( key != null ) {
            List<Double> t = map.get(key);
            Collections.sort(t);
            double tmp = t.get(0);
            int j = 0;
            sum = 0;
            for ( j = 0; j < K - 1; j++ ) sum += v.get(j);
            if (v.get(j-1) >= tmp ) sum += v.get(j);
            else sum += tmp;
            pay = Math.min(pay, key * sum);
            for ( double i : t ) v.remove(i);
            key = map.lowerKey(key);
            map.remove(map.higherKey(key));
            if ( v.size() < K ) break;
        }
        return pay;
    }
}