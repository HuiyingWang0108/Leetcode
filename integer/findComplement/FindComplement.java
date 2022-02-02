public class FindComplement {
    public static void main(String[] args) {
        FindComplement obj = new FindComplement();
        int num = 5;
        obj.findComplement(num);


    }

    public int findComplement(int num) {
        /**
         * way 1: 101 -> 010 -> 0 * 1 << 2 + 1 * 1 << 1  + 0 * 1 << 0
         * n & 1 == n % 1
         * n >> 1 == n / 2
         */
        // List<Integer> list = new ArrayList<Integer>();
        // while (num > 0) {
        //     int val = ((num & 1) == 1) ? 0 : 1;
        //     list.add(val);
        //     num = num >> 1;
        // }
        // int res = 0;
        // for (int i = list.size() - 1; i >= 0; i--) {
        //     res += list.get(i) * 1 << i;
        // }
        // return res;
        /**
         * way2: 101 ^ 111 = 010
         * time complexity O(n), space O(1)
         */
        // int count = 0;
        // int n = 0;
        // int original = num;
        // while(num > 0){
        //     n += 1 << count;
        //     count++;
        //     num = num >> 1;
        // }
        // return n ^ original;
        /**
         * way3
         */
        // long n = 1;
        // while(n <= num){
        //     n = n << 1;
        // }
        // n--;
        // return (int)n ^ num;
        int n = 1;
        while(n <= num - n){
            n = n << 1;
        }
        n += n - 1;
        return n ^ num;
    }
}