//문제 29-1) 스트림 생성 후, 문자열 스트림을 생성하는 맵핑 연산을 진행해보자. 그리고 결과를 forEach 연산을 통해 출력해보자.
import java.util.Arrays;
import java.util.List;

class Box<T> {
    private T ob;
    public Box(T o) { ob = o; }
    public T get() { return ob; }
}

public class BoxToString {
    public static void main(String[] args) {
        List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
        //ClassName::InstanceMethodName
        //p.701) "첫 번째 인자를 대상으로 이 메소드를 호출하기로 약속"
        //p.742) map은 내부적으로 스트림의 데이터를 "하나씩" 인자로 전달하며 apply메소드를 호출. 그리고 그 결과로 반환되는 값을 모아 새로운 스트림 생성.
        ls.stream().map(Box::get).forEach(n -> System.out.print(n + "\t"));
    }
}
