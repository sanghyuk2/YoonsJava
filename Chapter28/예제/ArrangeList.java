//static메소드의 참조

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ArrangeList {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,3,5,7,9);
        ls = new ArrayList<>(ls);

        //Consumer<List<Integer>> c = l -
        Consumer<List<Integer>> c = Collections::reverse;
        //accept 메소드 호출 시 전달되는 인자를 reverse 메소드를 호출하면서 그대로 전달된다.
        //accept 메소드가 호출 되면서 인자 'e'를 전달.
        //accept 내에서의 로직 처리가 끝난 후, js.sort 메소드 호출.
        //이때!! 전달된 'e'를 인자로 다시 한번 전달 해준다.
        //이것은 위에서 말했다시피 Java 진영에서의 약속.
        c.accept(ls);
        System.out.println(ls);
    }
}

//Reference) https://velog.io/@ym1085/Chapter24