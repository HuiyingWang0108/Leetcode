import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
        Partition obj = new Partition();
        String s = "aab";
        obj.partition(s);

    }

    public List<List<String>> partition(String s) {
        /**
         * leetcode131
         */
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        res.add(list);
        System.out.println("list: " + list);
        int n = s.length();

        

    }
}