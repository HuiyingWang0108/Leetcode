import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest{
    public static void main(String[] args){
        TreeMapTest obj = new TreeMapTest();
        obj.treeMapTest();
    }

    /**
     * 测试key为数组是如何排序
     */
    public void treeMapTest(){
        // TreeMap<List<Integer>, Integer> testMap = new TreeMap<List<Integer>, Integer>();
        TreeMap<int[], Integer> testMap = new TreeMap<>(Arrays::compare);
        int[] arry1 = {10, 83};
        int[] arry2 = {63, 87};
        int[] arry3 = {97, 100};
        int[] arry4 = {51, 61};
        testMap.put(arry1, 53);
        testMap.put(arry2, 45);
        testMap.put(arry3, 32);
        testMap.put(arry4, 16);
        for(Map.Entry<int[], Integer> entry: testMap.entrySet()){
            entry.getKey();
            System.out.println(Arrays.toString(entry.getKey()));
        }
       
    }
}