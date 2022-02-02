import java.util.Stack;

public class ValidParentheses{

    public static void main(String[] args) {
        
        ValidParentheses obj = new ValidParentheses();

        // String s =  "()";
        // String s =  "([])";
        // String s =  "([{([)}])";
        String s =  "((";
        
        boolean flg = obj.isValid(s);
        System.out.println("----flg-----" + flg);
    }

    public boolean isValid(String s) {
        String sPossible =  "()[]{}";
        String cPossible =  "([{";
        if(s.length() % 2 == 1){
            return false;
        }
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < s.length(); i++){
            // boolean flg = false;
            // if(s.charAt(i) == '(' || s.charAt(i) == '[' ||  s.charAt(i) == '{'){
            if(cPossible.indexOf(String.valueOf(s.charAt(i))) != -1){
                stack.push(String.valueOf(s.charAt(i)));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                String right = stack.pop() + s.charAt(i);
                if(sPossible.indexOf(right) == -1){
                    return false;
                } 
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}