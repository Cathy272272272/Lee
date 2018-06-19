class 399EvaluateDivision {
    List<String> list = new ArrayList<String>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int n = queries.length;
        double[] res = new double[n];
        for ( String[] i : equations ) {
            if (!list.contains(i[0])) list.add(i[0]);
            if (!list.contains(i[1])) list.add(i[1]);
        }
        int i, j, k = 0;
        int l = list.size();
        double[][] dp = new double[l][l];
          for( String[] e : equations ) {
            i = list.indexOf(e[0]);
            j = list.indexOf(e[1]);
            dp[i][j] = values[k];
            dp[j][i] = 1.0/ values[k];
            k++;
          }
        System.out.println(list);
        for (  i = 0; i < l; i++ ) {
            for (  j = i; j < l; j++ ) {
                if ( dp[i][j] != 0 ) continue;
                if ( i == j ) { dp[i][j] = 1.0; continue; }
                for ( k = 0; k < l; k++ ) {
                    if ( dp[i][k] != 0 && dp[k][j] != 0 ) {
                        dp[i][j] = dp[i][k] * dp[k][j];
                        dp[j][i] = 1.0 / dp[i][k] / dp[k][j];
                        break;
                    }
                }
            }
        }
        k = 0;
        for ( String[] q : queries ) {
            i = list.indexOf(q[0]);
            j = list.indexOf(q[1]); 
            if ( i == -1 || j == -1 ) res[k] = -1.0;
            else {
                if ( dp[i][j] != 0 ) res[k] = dp[i][j];
                else res[k] = -1.0;
            }
            k++;
        }
        return res;
    }
}