/* boolean[][] check is a waste, I could use a line to escape the case that the newcolor = color......
 * See  below
 * class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
 */
 class 733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if ( image.length < 1 || image.length > 50 ) return null;
        if ( image[0].length < 1 || image[0].length > 50 ) return null;
        if ( sr > image.length|| sr < 0 ) return null;
        if ( sc > image[0].length|| sc < 0 ) return null;
        if ( newColor < 0 || newColor > 65535 ) return null;
        int row = image.length;
        int col = image[0].length;
        boolean[][] check = new boolean[row][col];
        int color = image[sr][sc];
        fill(image, check, sr, sc, newColor, color);
        return image;
    }
    public void fill(int[][] image, boolean check[][], int i, int j, int newColor, int color ) {
        if ( i < image.length && i >= 0 && j < image[0].length && j >= 0 ) {
            if ( !check[i][j] && image[i][j] == color ) {
                image[i][j] = newColor;
                check[i][j] = true;
                fill(image, check, i+1, j, newColor, color);
                fill(image, check, i-1, j, newColor, color);
                fill(image, check, i, j+1, newColor, color);
                fill(image, check, i, j-1, newColor, color);
            }
        }
    }
}