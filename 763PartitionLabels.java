/* So So Soooooooo cleverrrrrrrrrr!!!!!!!!!
 * public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
    */
class 763PartitionLabels{
    public List<Integer> partitionLabels(String S) {
        List<Integer> out = new ArrayList<Integer>();
        int mark = 0;
        int range = S.length();
        int i, j, k;
        if ( S.length() <= 500 && S.length() >= 1 ){
            for ( k = 0; k < S.length(); k++ ){
                range = S.length();
                mark = k;
                for ( i = k; i < range; i++ ){
                    for ( j = S.length() - 1; j > mark; j-- ){
                        if ( S.charAt(i) == S.charAt(j) ){
                                mark = j;
                                break;
                            }
                        }
                    range = mark + 1;
                    }
                out.add(mark + 1 - k);
                k = mark;
                }
        }
        return out;
    }
}