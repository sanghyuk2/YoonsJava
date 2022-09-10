import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateShow {
    public static <T> void show(Predicate<T> p, List<T> list) {
        for(T n : list)
            if(p.test(n))
                System.out.print(n +"\t");


        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> lst1 = Arrays.asList(1,3,8,10,11);
        //Predicate<Integer> p = n -> n%2 != 0 (test 메소드를 구현 중), List<Integer> list = lst1
        //컴파일러는 타겟 타입을 보고 n의 형을 예상한다.
        //p.656, 660 참고
        show(n -> n%2 != 0, lst1);

        List<Double> lst2 = Arrays.asList(-1.2,3.5,-2.4,9.5);
        show(n -> n > 0.0, lst2);
    }
}


/**
 * Interface Predicate<T> {
 *     boolean test(T t);
 * }
 *
 * Predicate<Integer> p = return new Predicate() {
 *     public boolean test(Integer t) {
 *         return n -> n%2 != 0;
 *     }
 * }
 */