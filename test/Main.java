import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // Initialization of an ArrayList in one line
        List<String> list = new ArrayList<String>(Arrays.asList("apple", "orange", "banana"));
        // way1: sort alphabetically
        Collections.sort(list);
        // way2: sort alphabetically
        list.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        // way3: sort alphabetically
        list.sort(Comparator.comparing(String::toString));

        for(int i = 0; i < 10; i=i++){
            i += 1;
            System.out.print(i);
        }


        List<Boolean> l = new ArrayList<>();
        l.add(true);
        l.add(Boolean.parseBoolean("FalSe"));
        l.add(Boolean.TRUE);
        System.out.print(l.size());
        System.out.print(l.get(1) instanceof Boolean);

    }
}