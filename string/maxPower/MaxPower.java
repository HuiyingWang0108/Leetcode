public class MaxPower{
    public static void main(String[] args) {
        MaxPower obj = new MaxPower();
        String s = "ccbccbb";
        int res = obj.maxPower(s);
        System.out.println(res);
        
    }
    public int maxPower(String s) {
        int n = s.length();
        int max = 1;
        int i = 0;
        while(i < n - 1){
            int max_i = 1;
            while(s.charAt(i) == s.charAt(i + 1)){
                max_i += 1;
                max = Integer.max(max, max_i);
                i++;
                if(i + 1 == n){//i is the last one
                    break;
                }
            }
            i++;
        }
        return max;
        
    }
}