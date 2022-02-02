import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        // int[][] intervals = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 1, 10 } };
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        obj.merge(intervals);

    }

    public int[][] merge(int[][] intervals) {
        /**
         * same to maxTwoevents
         * 1, get a two dimentional array from original intervals if there exist intervals then merge intervals
         * 2, sort intervals according to the first column
         * 3, let list = ArrayList<int[]>(), to save the intervals without interval's rows
         * 4, for (int i = 0; i < intervals.length; i++) do
         *        if (i + 1 < n && intervals[i][1] >= intervals[i + 1][0]) 
         *           then intervals[i + 1][0] = min(intervals[i][0], intervals[i + 1][0])
         *           and  intervals[i + 1][1] = max(intervals[i][1], intervals[i + 1][1])
         *        else
         *           then list.add(intervals[i])
         *    end
         * 5, change list to res[list.size][2]
         * 6, return res
         * 7, quit
         * 
         */
        int n = intervals.length;
        Arrays.sort(intervals, (int[] a1, int[] a2)->{
            return Integer.compare(a1[0], a2[0]);
        });
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && intervals[i][1] >= intervals[i + 1][0]) {//need to merge
                intervals[i + 1][0] = intervals[i][0];
                if(intervals[i][1] > intervals[i + 1][1]){
                    intervals[i + 1][1] = intervals[i][1];
                }
            }else{
                list.add(intervals[i]);
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < 2; j++){
                res[i][j] = list.get(i)[j];
            }
        }
        return res;
    }
}