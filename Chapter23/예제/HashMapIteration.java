import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(45, "Brown"); //오토박싱이 이루어진다(new Integer(45)).
        map.put(37, "James");
        map.put(23, "Martin");

        Set<Integer> ks = map.keySet(); //Set<E>를 구성하는 인스턴스 생성 및 모든 Key를 담아서 반환한다.

        //Key 출력
        for(Integer n : ks){
            System.out.print(n.toString() + "\t");
        }
        System.out.println();


        //Value출력(for-each문)
        for(Integer n : ks) {
            System.out.print(map.get(n).toString() + "\t");
        }
        System.out.println();


        //Value출력(반복자 기반)
        for(Iterator<Integer> itr = ks.iterator(); itr.hasNext();) {
            System.out.print(map.get(itr.next()) + "\t");
        }

    }
}
