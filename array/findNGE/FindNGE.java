import java.util.Arrays;
import java.util.Stack;

public class FindNGE {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 1, 3};
        int[] res = findNGE(arr);
        System.out.println(Arrays.toString(res));
    }
    static int[] findNGE(int[] arr) {
        int[] ret = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            ret[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return ret;
    }
}