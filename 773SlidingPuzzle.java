/* Finaally make it, though not written by me lol......
 * Just A* algorithm, the thing I learnt is nested class......
 */
/*import java.util.HashMap;
import java.util.PriorityQueue;

class EightPuzzleAssist implements Comparable<EightPuzzleAssist> {
 public int[][] board;
 public int row;
 public int col;
 public int gn;
 public int hn;
 public int fn;
 public EightPuzzleAssist(int[][] board, int row, int col, int gn, int hn) {
  super();
  this.board = board;
  this.row = row;
  this.col = col;
  this.gn = gn;
  this.hn = hn;
  this.fn = gn + hn;
 }
 @Override
 public int compareTo(EightPuzzleAssist o) {
  return this.fn - o.fn;
 }

}
public class Solution {
 private final int[] dRow = {0, 0, -1, 1};
 private final int[] dCol = {1, -1, 0, 0};
 private final int[][] target = {{1, 2, 3}, {4, 5, 0}};
 private int M = 2;
 private int N = 3;
 public int slidingPuzzle(int[][] board) {
  int nixuCnt = getNixu(board);
  if ((nixuCnt & 1) != 0) {
   return -1;
  }
  PriorityQueue<EightPuzzleAssist> queue = new PriorityQueue<EightPuzzleAssist>();
  HashMap<String, EightPuzzleAssist> set = new HashMap<String, EightPuzzleAssist>();
  int[] startIndex = getZeroIndex(board);
  queue.offer(new EightPuzzleAssist(deepClone(board), startIndex[0],
    startIndex[1], 0, computeHn(board)));
  set.put(boardToHashKey(board), queue.peek());
  while (!queue.isEmpty()) {
   EightPuzzleAssist p = queue.poll();
   if (p.hn == 0) {
    return p.gn;
   } else {
    for (int i = 0; i < dRow.length; i++) {
     if (checkIndexBounds(p.row + dRow[i], p.col + dCol[i])) {
      int[][] matrix = deepClone(p.board);
      swap(matrix, p.row, p.col, p.row + dRow[i], p.col
        + dCol[i]);
      String key = boardToHashKey(matrix);
      int childHn = computeHn(matrix);
      if (!set.containsKey(key)) {
       EightPuzzleAssist child = new EightPuzzleAssist(
         matrix, p.row + dRow[i], p.col + dCol[i],
         p.gn + 1, childHn);
       queue.offer(child);
       set.put(key, child);
      }
     }
    }
   }
  }
  return -1;
 }
 private void swap(int[][] board, int row1, int col1, int row2, int col2) {
  int t = board[row1][col1];
  board[row1][col1] = board[row2][col2];
  board[row2][col2] = t;
 }
 private int[][] deepClone(int[][] board) {
  int[][] matrix = new int[M][N];
  for (int i = 0; i < M; i++) {
   for (int j = 0; j < N; j++) {
    matrix[i][j] = board[i][j];
   }
  }
  return matrix;
 }
 private int[] getZeroIndex(int[][] board) {
  for (int i = 0; i < M; i++) {
   for (int j = 0; j < N; j++) {
    if (board[i][j] == 0) {
     return new int[]{i, j};
    }
   }
  }
  return new int[2];
 }
 private int getNixu(int[][] board) {
  int[] array = new int[M * N - 1];
  int index = 0;
  for (int i = 0; i < M; i++) {
   for (int j = 0; j < N; j++) {
    if (board[i][j] != 0) {
     array[index] = board[i][j];
     index++;
    }
   }
  }
  int cnt = 0;
  for (int i = 0; i < array.length - 1; i++) {
   for (int j = i + 1; j < array.length; j++) {
    if (array[i] > array[j]) {
     cnt++;
    }
   }
  }
  return cnt;
 }
 private int computeHn(int[][] board) {
  int cnt = 0;
  for (int i = 0; i < M; i++) {
   for (int j = 0; j < N; j++) {
    if (board[i][j] != target[i][j]) {
     cnt++;
    }
   }
  }
  return cnt;
 }
 private String boardToHashKey(int[][] board) {
  String str = "";
  for (int i = 0; i < M; i++) {
   for (int j = 0; j < N; j++) {
    str += board[i][j] + "_";
   }
  }
  return str;
 }
 private boolean checkIndexBounds(int row, int col) {
  if (row >= 0 && row < M && col >= 0 && col < N) {
   return true;
  } else {
   return false;
  }
 }

}
*/
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class 773SlidingPuzzle {
    public class Board {
    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    private int[][] board;
    private int r,c;
    public Board(int[][] blocks) {
        r = blocks.length;
        c = blocks[0].length;
        board = new int[r][c];
        for ( int i = 0; i < r; i++ )
            for ( int j = 0; j < c; j++ ) {
                board[i][j] = blocks[i][j];
            }
    }
    
    // number of blocks out of place
    public int hamming() {
        int sum = 0;
        for ( int i = 0; i < r; i++ ){
            for ( int j = 0; j < c; j++ ) {
                if ( board[i][j] == 0 ) continue;
                if ( board[i][j] != c * i + j + 1 ) sum++;
            }
        }
        return sum;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int sum = 0;
        int help;
        int y, x;
        for ( int i = 0; i < r; i++ ) {
            for ( int j = 0; j < c; j++ ) {
                if ( board[i][j] == 0 ) continue;
                if ( i == r - 1 && j == c - 1 ) help = 0;
                else help = c * i + j + 1;
                if ( board[i][j] != help ){
                    y = (board[i][j] - 1 ) / c;
                    x = (board[i][j] - 1) % c;
                    sum += Math.abs(y - i) + Math.abs(x - j);
                }
            }
        }
        return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return this.hamming() == 0;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        Board twin = new Board(board);
        int x, y, temp;
        temp = 0;
        x = 0;
        y = 0;
        boolean visited = false;
        for ( int i = 0; i < r; i++ ){
            for ( int j = 0; j < c; j++ ){
                if ( !visited) {
                    if (board[i][j] != 0) {
                        x = j;
                        y = i;
                        temp = board[y][x];
                        visited = true;
                    }
                }
                else {
                   if ( board[i][j] != 0 ) {
                       twin.board[y][x] = twin.board[i][j];
                       twin.board[i][j] = temp;
                       return twin;
                   }
                }
            }
        }
        return twin;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null)
            return false;
        if (y == this)
            return true;
        if (y.getClass().isInstance(this)) {
            Board yb = (Board) y;
            if (yb.r != this.r || yb.c != this.c)
                return false;
            else {
                for (int row = 0; row < r; row++)
                    for (int col = 0; col < c; col++)
                        if (yb.board[row][col] != board[row][col])
                            return false;
                return true;
            }
        } else
            return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<Board>();
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (board[row][col] == 0) {
                    if (row > 0) {
                        Board neighborT = new Board(board);
                        neighborT.board[row][col] = neighborT.board[row - 1][col];
                        neighborT.board[row - 1][col] = 0;
                        neighbors.add(neighborT);
                    }
                    if (row < r - 1) {
                        Board neighborB = new Board(board);
                        neighborB.board[row][col] = neighborB.board[row + 1][col];
                        neighborB.board[row + 1][col] = 0;
                        neighbors.add(neighborB);
                    }
                    if (col > 0) {
                        Board neighborL = new Board(board);
                        neighborL.board[row][col] = neighborL.board[row][col - 1];
                        neighborL.board[row][col - 1] = 0;
                        neighbors.add(neighborL);
                    }
                    if (col < c - 1) {
                        Board neighborR = new Board(board);
                        neighborR.board[row][col] = neighborR.board[row][col + 1];
                        neighborR.board[row ][col + 1] = 0;
                        neighbors.add(neighborR);
                    }
                }
            }
        }
        return neighbors;
    }
}
    public class MinPQ<Key> implements Iterable<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MinPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMin() {
        //if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }


   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

   /***************************************************************************
    * Helper functions for compares and swaps.
    ***************************************************************************/
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }


    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        // create a new pq
        private MinPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MinPQ<Key>(size());
            else                    copy = new MinPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
    }
    
    public class Solver {

    private SearchNode currentNode;
    private SearchNode twincurrentNode;
    //private Stack<Board> solution;

    private class SearchNode implements Comparable<SearchNode>{
        public Board board;
        public int moves;
        public SearchNode preSearchNode;

        public final int priority;

        public SearchNode(Board inboard, SearchNode inPreSearchNode){
            board = inboard;
            preSearchNode = inPreSearchNode;
            if(inPreSearchNode == null) moves = 0;
            else moves = inPreSearchNode.moves + 1;
            priority = moves + board.manhattan();
        }

        @Override
        public int compareTo(SearchNode o) {
            return Integer.compare(this.priority, o.priority);
        }
    }


    public Solver(Board initial) {
        // find a solution to the initial board (using the A* algorithm)
        if(initial == null)
            throw new IllegalArgumentException("Constructor argument Board is null!");
        currentNode = new SearchNode(initial,null);
        twincurrentNode = new SearchNode(initial.twin(),null);
        MinPQ<SearchNode> priorityQueue = new MinPQ<SearchNode>();
        MinPQ<SearchNode> twinPriorityQueue = new MinPQ<SearchNode>();
        priorityQueue.insert(currentNode);
        twinPriorityQueue.insert(twincurrentNode);
        currentNode = priorityQueue.delMin();
        if( !currentNode.board.isGoal()) {
            twincurrentNode = twinPriorityQueue.delMin();
            if (!twincurrentNode.board.isGoal()) {
                SearchNode temp;
                Search:
                while (true) {
                    Iterable<Board> neighbors = currentNode.board.neighbors();
                    for (Board neighbor : neighbors) {
                        if (currentNode.preSearchNode == null || !neighbor.equals(currentNode.preSearchNode.board)) {
                            if (neighbor.isGoal()) {
                                currentNode = new SearchNode(neighbor, currentNode);
                                priorityQueue = null;
                                twinPriorityQueue = null;
                                break Search;
                            }
                            priorityQueue.insert(new SearchNode(neighbor, currentNode));
                        }
                    }
                    currentNode = priorityQueue.delMin();
                    neighbors = twincurrentNode.board.neighbors();
                    for (Board neighbor : neighbors) {
                        if (twincurrentNode.preSearchNode == null || !neighbor.equals(twincurrentNode.preSearchNode.board)) {
                            if (neighbor.isGoal()) {
                                priorityQueue = null;
                                twinPriorityQueue = null;
                                break Search;
                            }
                            twinPriorityQueue.insert(new SearchNode(neighbor, twincurrentNode));
                        }
                    }
                    twincurrentNode = twinPriorityQueue.delMin();
                }
                temp = null;
            }
        }
    }
    public int moves() {
        // min number of moves to solve initial board; -1 if unsolvable
        if(currentNode.board.isGoal())
            return currentNode.moves;
        else
            return -1;
    }
}
    public int slidingPuzzle(int[][] board) {
        Solver s = new Solver(new Board(board));
        return s.moves();
}
}