import java.util.Stack;

public class BasicCalculate {
    public static void main(String[] args) {
        BasicCalculate obj = new BasicCalculate();
        String s = "   (  3 ) ";
        obj.calculate(s);
        System.out.println("===");
    }

    public int calculate(String s) {
        /**
         * recursive
         */
        int n = s.length(), currNum = 0, res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char operator = '+';
        for (int i = 0; i < n; i++) {
            // digital
            if (Character.isDigit(s.charAt(i))) {
                currNum = currNum * 10 + Character.getNumericValue(s.charAt(i));
            }
            // (...
            int j;
            if (s.charAt(i) == '(') {
                int count = 0;
                operator = i > 0 ? s.charAt(i - 1) : '+';
                for (j = i; j < n; j++) {
                    if (s.charAt(j) == '(') {
                        count++;
                    }
                    if (s.charAt(j) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                currNum = calculate(s.substring(i + 1, j));
                if (j == n - 1) {
                    if (operator == '+') {
                        stack.push(currNum);
                    } else if (operator == '-') {
                        stack.push(-currNum);
                    }
                    break;
                }else{
                    i = j + 1;
                }
               

            }
            //
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                if (operator == '+') {
                    stack.push(currNum);
                } else if (operator == '-') {
                    stack.push(-currNum);
                }
                operator = s.charAt(i);
                currNum = 0;
            }

        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}