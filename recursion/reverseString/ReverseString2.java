public class ReverseString{
    public static void main(String[] args) {
        
    }
    public void reverseString(char[] s) {
        recuFun(s, 0, s.length - 1); 
    }
    /**
     * recursive 
     */
    public void recuFun(char[] s,int left, int right) {
        if(left >= right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        recuFun(s, left + 1, right - 1);
        
    }
}