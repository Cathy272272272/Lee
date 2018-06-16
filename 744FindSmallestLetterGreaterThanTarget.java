class 744FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int max = 26, mark = 0;
        for ( int i = 0; i < n; i++ ) {
            int tmp = letters[i]-target > 0 ? letters[i] - target: 26 + letters[i] - target;
            if ( max > tmp && tmp > 0) {
                max = tmp;
                mark = i;
            }
        }
        return letters[mark];
    }
}