class 811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        String[][] array = new String[cpdomains.length][4];
        List<String> out = new ArrayList<String>();
        String[] temp;
        StringBuilder help = new StringBuilder();
        if ( cpdomains.length <= 100 ){
            for ( int i = 0; i < cpdomains.length; i++ ){
                temp = cpdomains[i].split("[\\s]+");
                array[i][0] = temp[0];
                temp = temp[1].split("[.]");
                array[i][1] = temp[temp.length - 1];
                for ( int j = 2; j <= temp.length; j++ ){
                    array[i][j] = help.append(temp[temp.length - j]).append(".").append(array[i][j - 1]).toString();
                    help.delete(0, help.length());
                }
            }
            int sum;
            boolean[][] check = new boolean[cpdomains.length][4];
            for ( int i = 0; i < cpdomains.length; i++ )
                for ( int j = 1; j < array[i].length; j++ )
                    if ( array[i][j] != null && check[i][j] == false ){
                        sum = Integer.parseInt(array[i][0]);
                        check[i][j] = true;
                        for ( int k = i + 1; k < cpdomains.length; k++ )
                            for ( int l = 1; l < array[k].length; l++ )
                                if( array[k][l] != null )
                                    if ( array[i][j].equals(array[k][l]) && check[k][l] == false ) {
                                        check[k][l] = true;
                                        sum += Integer.parseInt(array[k][0]);
                                    }
                            out.add(Integer.toString(sum) + " " + array[i][j] );                    
                        }
                    }
        return out;
    }
}