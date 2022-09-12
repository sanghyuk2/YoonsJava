import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class JustSort {
    public void sort(List<?> lst) {
        Collections.reverse(lst);
    }
}

public class ArrangeList2 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,3,5,7,9);
        ls = new ArrayList<>(ls);

        JustSort js = new JustSort();

        //람다식에서 접근 가능한 참조변수는 final로 선언되었거나 effectively final 이어야 한다. 논리적 혼란을 일으키거나 예측 불가능한 상황으로 이어질 수 있다.
        //예제에서 js는 참조하는 인스턴스에 변화가 없기에 effectively final이다.
        //e -> js.sort(e)는 accept의 몸체 구현이라 생각하자.
        //Consumer<List<Integer>> c = e -> js.sort(e);
        //ReferenceName::InstanceMethodName
        Consumer<List<Integer>> c = js::sort;
        c.accept(ls);
        System.out.println(ls);

    }

}
