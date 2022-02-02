public class CheckIfExist {
    public static void main(String[] args) {

    }

    public boolean checkIfExist(int[] arr) {
        /**
         * leetcode 1346
         * 数组中一个数是另一个数的2倍
         * ---------Time: O(n)--Space: O(n)-------------------------------------------------
         * step1, save each array to bitset
         *        for i=[0, arr.length) do
         *            bitset.set(arr[i] * 2 + 2000)//-1000 <= arr[i] <= 1000 
         * step2, loop arr, if (exist in bs and a !=0) then return true, elseif (a = 0) count the number of 0
         *        for i=[0, arr.length) do
         *           if (arr[i] != 0 && bitset.get(arr[i] + 2000))
         *              then return true
         *           elseif (arr[i] == 0)
         *              then count0++
         * step3, if (count0 >= 2)
         *           then return true
         * step4, quit
         *                  
         */
        BitSet bs = new BitSet();
        for (int a : arr) {
            bs.set(a * 2 + 2000);
        }
        int count = 0;
        for (int a : arr) {
            if (bs.get(a + 2000) && a != 0) {
                return true;
            } else if (a == 0) {
                count++;
            }
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }
}