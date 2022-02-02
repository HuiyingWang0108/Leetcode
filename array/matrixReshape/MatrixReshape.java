public class MatrixReshape {
    public static void main(String[] args) {

    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int s = m * n;
        if (s != r * c) {
            return mat;
        }
        // int[] temp = new int[s];
        int[][] res = new int[r][c];
        int k = 0, l = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[k][l] = mat[i][j];
                if(l == c - 1){//列走完了
                    k++;
                    l = 0;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
}