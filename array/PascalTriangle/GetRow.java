import java.util.ArrayList;
import java.util.List;

public class GetRow{
    public static void main(String[] args) {
        
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        List<List<Integer>> listSet = new ArrayList<List<Integer>>();

        if(rowIndex == 0){
            res.add(1);
            return res;
        }
        if(rowIndex == 1){
           res.add(0, 1);
           res.add(1, 1);
           return res;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(0, 1);
        list2.add(0, 1);
        list2.add(1, 1);
        listSet.add(0, list1);
        listSet.add(1, list2);
        for(int i = 2; i <= rowIndex; i++){
            List<Integer> list_i = new ArrayList<Integer>();
                list_i.add(0, 1);
                List<Integer> upList = listSet.get(i - 1);
                for(int j = 1; j <= i; j++){
                    int val = upList.get(j - 1) + upList.get(j);
                    list_i.add(j, val);
                }
        }
        return listSet.get(rowIndex);

    }   
}