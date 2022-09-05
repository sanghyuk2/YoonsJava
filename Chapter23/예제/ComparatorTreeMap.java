import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class AgeComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i2.intValue() - i1.intValue();
    }
}

public class ComparatorTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>(new AgeComparator()); //생성자로 Comparator interface를 상속하는 AgeComparator을 인자로 넘겨 새로운 정렬 기준을 세운다.
        map.put(45, "Brown");
        map.put(37, "James");
        map.put(23, "Martin");

        Set<Integer> ks = map.keySet(); //Key 정보를 담은 Set<E> 인스턴스를 생성하여 반환

        for(Integer n : ks)
            System.out.print(n.toString() + "\t");
        System.out.println();

        for(Integer n : ks)
            System.out.print(map.get(n).toString() + "\t");
        System.out.println();

        for(Iterator<Integer> itr = ks.iterator(); itr.hasNext();)
            System.out.print(map.get(itr.next()).toString() + "\t");
        System.out.println();
    }

}
