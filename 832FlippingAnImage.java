class 832FlippingAnImage  {
    public int[][] flipAndInvertImage(int[][] A) {
        //boolean check = true;
        int temp;
        int half;
        if ( A.length == A[0].length && A.length >= 1 && A.length <= 20 ){ //chenk 1st condition
            for ( int i = 0; i < A.length; i++ )
                for ( int j = 0; j < A.length; j++ )
                    if ( A[i][j] < 0 || A[i][j] > 1 )//check 2nd condition
                        break;
                    else{
                        if ( A.length % 2 == 1)
                            half = A.length / 2 + 1;
                        else
                            half = A.length / 2;
                            if ( j < half ){
                            if ( A[i][j] == 0 )
                                temp = 1;
                            else 
                                temp = 0;
                            if ( A[i][A.length - 1 - j] == 0 )
                                A[i][j] = 1;
                            else
                                A[i][j] = 0;
                            A[i][A.length - 1 - j] = temp;                                
                        }
                        else
                            break;
                    }
        }
    return A;
    }
}