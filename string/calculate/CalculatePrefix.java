import java.util.Stack;

public class CalculatePrefix {
    public static void main(String[] args) {
        CalculatePrefix obj = new CalculatePrefix();
        String s = "1+1";
        // String s = "-2+6";
        // String s = "(1+(4+5+2)-3)+(6+8)";
        // String s = "   (  3 ) ";
        obj.calculate(s);
        System.out.println("===");
    }

    public int calculate(String s) {
        Stack<String> stack_operand = new Stack<String>();
        Stack<String> stack_operator = new Stack<String>();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            String num_s = "";
            if (Character.isDigit(s.charAt(i))) {
                while( i >= 0 && Character.isDigit(s.charAt(i))){
                    num_s = s.charAt(i) + num_s;
                    i--;
                }
                stack_operand.push(num_s);
                i++;
                
                continue;
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
                if (s.charAt(i) == '+') {
                    stack_operator.push("+");
                    continue;
                } else if (s.charAt(i) == '-') {
                    stack_operator.push("-");
                    if(i == 0){
                        stack_operand.push("0");
                    }
                    continue;
                } else if (s.charAt(i) == ')') {
                    stack_operator.push(")");
                    continue;
                } else if (s.charAt(i) == '(') {
                    String popOperator = stack_operator.pop();
                    while(popOperator != ")"){
                        stack_operand.push(popOperator);// operator
                        popOperator = stack_operator.pop();
                    }
                    continue;
                }

            }
        }
        if(stack_operand.size() == 1){
            return Integer.parseInt(stack_operand.pop());
        }
        while (!stack_operator.isEmpty()) {
            String pop = stack_operator.pop();
            if(pop != ")"){
                stack_operand.push(pop);
            }
        }
        //reverse stack_operand 
        while(!stack_operand.isEmpty()){
            stack_operator.push(stack_operand.pop());
        }
        /**
         * EVALUATE_PREFIX(STRING)
         * Step 1: Put a pointer P at the end of the end
         * Step 2: If character at P is an operand push it to Stack
         * Step 3: If the character at P is an operator pop two 
         *         elements from the Stack. Operate on these elements
         *         according to the operator, and push the result 
         *         back to the Stack
         * Step 4: Decrement P by 1 and go to Step 2 as long as there
         *         are characters left to be scanned in the expression.
         * Step 5: The Result is stored at the top of the Stack, return it
         * Step 6: End
         */
        Stack<Integer> stack = new Stack<Integer>();
        while(!stack_operator.isEmpty()){
            String pop = stack_operator.pop();
            if(pop != "+" && pop != "-" ){
                stack.push(Integer.parseInt(pop));
            }else if(pop == "+"){// +/-
                int num_1 = stack.pop();
                int num_2 = stack.pop();
                stack.push(num_1 + num_2);
            }else if(pop == "-"){
                int num_1 = stack.pop();
                int num_2 = stack.pop();
                stack.push(num_1 - num_2);
            }
        }

        return stack.pop();

    }
}