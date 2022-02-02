import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        Rotate obj = new Rotate();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        obj.rotate(matrix);
        System.out.println(Arrays.toString(matrix));

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        int m = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                temp[j][m - i] = matrix[i][j];
            }
        }
        // matrix = res;/内存中地址分配，不可此种改变！！！
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = temp[i][j];
            }
        }

    }
}