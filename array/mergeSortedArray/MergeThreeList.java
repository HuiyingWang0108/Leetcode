import java.util.ArrayList;
import java.util.List;

public class MergeThreeList {
    public static void main(String[] args) {
        MergeThreeList obj = new MergeThreeList();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(3);
        l2.add(7);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(2);
        l3.add(4);
        l3.add(6);
        List<Integer> l = obj.mergeThreeList(l1, l2, l3);
        System.out.println(l);
    }

    public List<Integer> mergeThreeList(List<Integer> l1, List<Integer> l2, List<Integer> l3) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;
        int first_l = l1.size(), second_l = l2.size(), third_l = l3.size();
        /**
         * l1, l2 , l3 are not null
         */
        while (i < first_l && j < second_l && k < third_l) {
            // avoid memory aliasing
            int a = l1.get(i), b = l2.get(j), c = l3.get(k);
            //a is the min(a ,b c)
            if (a <= b && a <= c) {
                i++;
                if (!res.contains(a)) {
                    res.add(a);
                }
            }else if(b <= a && b <=c){//b is the min(a ,b c)
                j++;
                if (!res.contains(b)) {
                    res.add(b);
                }
            }else{//c is the min(a ,b c)
                k++;
                if (!res.contains(c)) {
                    res.add(c);
                }
            }
        }
        /**
         * sort two of arrays if one of the three gets exhausted
         */
        while(i < first_l && j < second_l){
            int a = l1.get(i), b = l2.get(j);
            if(a < b){
                i++;
                if(!res.contains(a)){
                    res.add(a);
                }
            }else{
                j++;
                if(!res.contains(b)){
                    res.add(b);
                }
            }
        }
        while(i < first_l && k < third_l){
            int a = l1.get(i), c = l3.get(k); 
            if(a < c){
                i++;
                if(!res.contains(a)){
                    res.add(a);
                }
            }else{
                k++;
                if(!res.contains(c)){
                    res.add(c);
                }
            }
        }
        while(j < second_l && k < third_l){
            int b = l2.get(j), c = l3.get(k); 
            if(b < c){
                j++;
                if(!res.contains(b)){
                    res.add(b);
                }
            }else{
                k++;
                if(!res.contains(c)){
                    res.add(c);
                }
            }
        }
        /**
         * sort last one if two of the three get exhausted
         */
        while(i < first_l){
            int a = l1.get(i);
            i++;
            if(!res.contains(a)){
                res.add(a);
            }
        }
        while(j < second_l){
            int b = l2.get(j);
            j++;
            if(!res.contains(b)){
                res.add(b);
            }
        }
        while(k < third_l){
            int c = l3.get(k);
            k++;
            if(!res.contains(c)){
                res.add(c);
            }
        }
        return res;
    }
}