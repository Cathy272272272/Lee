Intuition:

Count number of different cards to a map c
Loop from the smallest card number.
Everytime we meet a new card i, we cut off i - i + W - 1 from the counter.
Time Complexity:
O(MlogM + MW), where M is the number of different cards.

C++:

    bool isNStraightHand(vector<int> hand, int W) {
        map<int, int> c;
        for (int i : hand) c[i]++;
        for (auto it : c)
            if (c[it.first] > 0)
                for (int i = W - 1; i >= 0; --i)
                    if ((c[it.first + i] -= c[it.first]) < 0)
                        return false;
        return true;
    }
Java:

    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = W - 1; i >= 0; --i) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }
Python:

    def isNStraightHand(self, hand, W):
        c = collections.Counter(hand)
        for i in sorted(c):
            if c[i] > 0:
                for j in range(W)[::-1]:
                    c[i + j] -= c[i]
                    if c[i + j] < 0:
                        return False
        return True
Follow Up
We just got lucky AC solution. Because W <= 10000.
What if W is huge, should we cut off card on by one?

Explanation:

Count number of different cards to a map c
Cur represent openedrent open straight groups.
In a deque start, we record when start a straight group, and the number of groups.
Loop from the smallest card number.
For example, hand = [1,2,3,2,3,4], W = 3
We meet one 1:
opened = 0, we open a new straight groups starting at 1, push (1,1) to start.
We meet two 2:
opened = 1, we need open another straight groups starting at 1, push (2,1) to start.
We meet two 3:
opened = 2, it match openedrent open groups.
We open one group at 1, now we close it. opened = opened - 1 = 1
We meet one 4:
opened = 1, it match openedrent open groups.
We open one group at 2, now we close it. opened = opened - 1 = 0

return if no more open groups.
Time Complexity:
O(MlogM), where M is the number of different cards.

C++:

    bool isNStraightHand(vector<int> hand, int W) {
        map<int, int> c;
        for (int i : hand) c[i]++;
        queue<int> start;
        int last_checked = -1, opened = 0;
        for (auto it : c) {
            int i = it.first;
            if (opened > 0 && i > last_checked + 1 || opened > c[i]) return false;
            start.push(c[i] - opened);
            last_checked = i, opened = c[i];
            if (start.size() == W) {
                opened -= start.front();
                start.pop();
            }
        }
        return opened == 0;
    }
Java

    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : c.keySet()) {
            if (opened > 0 && i > last_checked + 1 || opened > c.get(i)) return false;
            start.add(c.get(i) - opened);
            last_checked = i; opened = c.get(i);
            if (start.size() == W) opened -= start.remove();
        }
        return opened == 0;
    }
Python:

    def isNStraightHand(self, hand, W):
        c = collections.Counter(hand)
        start = collections.deque()
        last_checked, opened = -1, 0
        for i in sorted(c):
            if opened > c[i] or opened > 0 and i > last_checked + 1: return False
            start.append(c[i] - opened)
            last_checked, opened = i, c[i]
            if len(start) == W: opened -= start.popleft()
        return opened == 0
Update 2018-06-03:
Thanks to suggeestion from @cliuzh, I check whether the cards in the map are consecutive.
And I add only opened group number to queue.
    class 846HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if ( n % W != 0 ) return false;
        if ( n == 1 || W == 1) return true;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for ( int i : hand ) map.put(i, map.getOrDefault(i, 0) + 1);
        int zero, one, two, t0, t1, t2;
        while ( W - 1 <= map.size() ) {
            zero = map.firstKey();
            t0 = map.get(zero);
            one = zero;
            two = zero;
            map.remove(zero);
            for ( int i = 1; i < W; i++ ) {
                if ( map.higherKey(one) == null ) return false;
                one = map.higherKey(one);
                t1 = map.get(one);
                if ( t0 > t1 || one - two != 1) return false;
                if ( t0 == t1 ) map.remove(one);
                else map.put(one, t1 - t0);
                two = one;
                t2 = t1;
            }
        }
            if ( map.size() > 0 ) return false;
        return true;
    }
}