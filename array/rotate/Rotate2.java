import java.util.Arrays;

public class Rotate2 {
    public static void main(String[] args) {
        Rotate2 obj = new Rotate2();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        obj.rotate(matrix);
        System.out.println(Arrays.toString(matrix));

    }

    public void rotate(int[][] matrix) {
        /**
         *  from top left to down right 对角线对折
         * from left to right for matrix[i][]列 夹逼
         */
        int n = matrix.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            int left = 0, right = n - 1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}