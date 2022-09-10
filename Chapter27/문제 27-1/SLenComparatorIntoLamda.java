import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SLenComparatorIntoLamda {
    public static void main(String[] args) {
        //list 정의
        List<String> list = new ArrayList<>();
        list.add("Robot");
        list.add("Lambda");
        list.add("Box");

        //public static <T> void sort(List<T> list, Comparator<? extends T> c)
        Collections.sort(list, (s1, s2)->s1.length() - s2.length());

        for(String s : list)
            System.out.println(s);
    }
}
