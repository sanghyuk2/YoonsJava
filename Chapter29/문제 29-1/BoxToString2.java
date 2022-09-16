//문제 29-1 문제2) 스트림 생성 후, 문자열 스트림을 생성하는 맵핑 연산을 진행해보자. 그리고 결과를 forEach 연산을 통해 출력해보자.
// Box<String>을 Integer로 맵핑하도록 수정해보자.
import java.util.Arrays;
import java.util.List;

class Box<T> {
    private T ob;
    public Box(T o) { ob = o; }
    public T get() { return ob; }
}

public class BoxToString2 {
    public static void main(String[] args) {
        List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
        //s.get()을 통하여 String형 인스턴스를 얻어낸 뒤, .length() 메소드를 호출하여 문자열의 길이를 Stream<String>형으로 감싸 반환하였다.
        ls.stream().map(s -> s.get().length()).forEach(n -> System.out.print(n + "\t"));
    }
}
