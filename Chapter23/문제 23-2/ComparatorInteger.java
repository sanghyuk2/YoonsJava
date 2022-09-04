/* 문제 23-2)
* 내림차순으로 treeSet을 정렬하라
* */

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorInteger {
    public static void main(String[] args) {
        TreeSet<Integer> tr = new TreeSet<>(new IntegerComparator());
        tr.add(30);
        tr.add(10);
        tr.add(20);
        System.out.println(tr);
    }

}

class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) { return i2 - i1;}
}
