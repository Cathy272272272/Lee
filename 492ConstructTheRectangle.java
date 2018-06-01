class 492ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while ( area % w != 0 ) {
            w--;
        }
        int[] res = {area/w, w};
        return res;
    }
}