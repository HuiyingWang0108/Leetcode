import java.util.Arrays;

public class MaximumUnits {
    public static void main(String[] args) {
        int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
        int truckSize = 4;
        maximumUnits(boxTypes, truckSize);

    }

    static int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        // sort the second column by descending order
        Arrays.sort(boxTypes, (int[] e1, int[] e2) -> {
            return Integer.compare(e2[1], e1[1]);
        });

        int i = 0;
        while (i < boxTypes.length && truckSize > 0) {
            if (truckSize >= boxTypes[i][0]) {
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                ans += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            i++;
        }
        return ans;
    }
}
