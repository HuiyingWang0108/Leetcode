import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {
        Calculate obj = new Calculate();
        String s = "3+2*5";
        obj.calculate(s);
        System.out.println("===");
    }

    public int calculate(String s) {
        /**
         * 1, for i = [0,s.length) do
         *       if (s[i] is digital) 
         *          then get the digital
         *          let flag = before the digital's operator(let before the first digital's operator is '+' )
         *          if (flag is '+') 
         *             then stack.push(s[i]) 
         *          else if (flag is '-')
         *             then stack.push(-s[i])
         *          else if (flag is '*')
         *             then stack.push(stack.pop() * s[i])
         *          else if (flag is '/')
         *             then stack.push(stack.pop() / s[i])
         *    end
         * 2, let res = 0
         * 3, while (!stack.empty()) do
         *      res += stack.pop()
         *    end
         * 4, return res
         * 5, quit
         * 
         */
        int n = s.length();
        int currNum = 0;
        int res = 0;
        char operator = '+';
        Stack<Integer> stack_operand = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + Character.getNumericValue(ch);
            }
            // operator or last index
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                if(operator == '+'){
                    stack_operand.push(currNum);
                }else if(operator == '-'){
                    stack_operand.push(-currNum);
                }else if(operator == '*'){
                    stack_operand.push(stack_operand.pop() * currNum);
                }else if(operator == '/'){
                    stack_operand.push(stack_operand.pop() / currNum);
                }
                currNum = 0;
                operator = ch;

            }
        }
        while(!stack_operand.isEmpty()){
            res += stack_operand.pop();
        }
        return res;

    }
}