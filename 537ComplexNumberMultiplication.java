class 537ComplexNumberMultiplication{
    public String complexNumberMultiply(String a, String b) {
        String temp;
        String sum = "";
        int arrayA[] = new int[3];
        arrayA = convert(a);
        int arrayB[] = new int[3];
        arrayB = convert(b);
        return (( arrayA[0] * arrayB[0] - arrayA[1] * arrayB[1] ) + "+" + ( arrayA[0] * arrayB[1] + arrayA[1] * arrayB[0] ) + "i" );
    }

    public int[] convert(String a){
        int a1, a2, type, i;
        int array[] = new int[3];
        for ( i = 0; i < a.length(); i++ )
            if ( a.substring(i,i+1).equals("+") )
                break;//i denotes the position of "+"
        if ( a.substring(0,1).equals("-") ){
            a1 = -Integer.parseInt(a.substring(1,i));
            if ( a.substring(i+1,i+2).equals("-") ){
                a2 = -Integer.parseInt(a.substring(i+2,a.length()-1));
                type = 1; //--
            }
            else{
                a2 = Integer.parseInt(a.substring(i+1,a.length()-1));
                type = 2; // -+
            }
        }
        else{
            a1 = Integer.parseInt(a.substring(0,i));
            if ( a.substring(i+1,i+2).equals("-") ){
                a2 = -Integer.parseInt(a.substring(i+2,a.length()-1));
                type = 3;// +-
            }
            else{
                a2 = Integer.parseInt(a.substring(i+1,a.length()-1)); 
                type = 4;//++
            }
        }
        array[0] = a1;
        array[1] = a2;
        array[2] = type;
        return array;
    }
}