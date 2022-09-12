//문제 28-1) 다음 예제를 메소드 참조 방식으로 수정해보자.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrIgnoreCaseComp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("robot");
        list.add("Lambda");
        list.add("box");
        //public static <T> sort(List<T> list, Comparator<? super T> c) (p.608)
        //Collections.sort(list, (s1, s2) -> s1.compareToIgnoreCase(s2));

        //첫 번째 전달인자를 대상으로 메소드를 호출 수 두 번째 인자를 첫 번째 인자의 메소드의 매개변수로 집어넣는 형태이다.
        //즉, ClassName::InstanceMethodName형태 가능!
        Collections.sort(list, String::compareToIgnoreCase);
        System.out.println(list);
    }
}
