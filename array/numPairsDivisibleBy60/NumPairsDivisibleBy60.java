public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        NumPairsDivisibleBy60 obj = new NumPairsDivisibleBy60();
        int[] time = { 30, 20, 150, 100, 40 };
        obj.numPairsDivisibleBy60(time);
    }

    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, res = 0;
        // loop time and save counts in occurs
        int[] occurs = new int[60];
        for (int i = 0; i < n; i++) {
            // simplize input
            time[i] = time[i] % 60;
            occurs[time[i]] += 1;
        }
        // loop occurs
        res = occurs[0] > 1 ? occurs[0] * (occurs[0] - 1) / 2 : 0;
        for (int i = 1; i < 30; i++) {
            res += occurs[i] * occurs[60 - i];
        }
        res += occurs[30] > 1 ? occurs[30] * (occurs[30] - 1) / 2 : 0;
        return res;
    }
}