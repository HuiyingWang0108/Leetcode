import java.util.ArrayList;
import java.util.List;

public class PascalTriangle{
    public static void main(String[] args){
        PascalTriangle obj = new PascalTriangle();
        int numRows = 5;
        obj.generate(numRows);

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(0, 1);
        res.add(0, list1);
        if(numRows == 1){
            return res;
        }
        list2.add(0, 1);
        list2.add(1, 1);
        res.add(1, list2);
        if(numRows == 2){
            return res;
        }
        if(numRows > 2){
             // begin the thrid row
            for(int i = 2; i < numRows; i++){
                List<Integer> list_i = new ArrayList<Integer>();
                list_i.add(0, 1);
                List<Integer> upList = res.get(i - 1);
                for(int j = 1; j < i; j++){
                    int val = upList.get(j - 1) + upList.get(j);
                    list_i.add(j, val);
                }
                list_i.add(i, 1);
                res.add(list_i);
            }
        }
       
        return res;
    }
}