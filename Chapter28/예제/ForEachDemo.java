import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        //람다식 기반
        ls.forEach(s -> System.out.println(s));
        //메소드 참조 기반
        ls.forEach(System.out::println);

        //forEach 메소드를 호출하기 위해서는 forEach 메소드의 인자에 매게변수로 람다식 혹은 메소드 참조를 전달해야한다.
        //또한 "대입 연산자 오른편에 메소드의 정보만 오면 인자로 전달되는 인자를 그대로 전달 하면서 메소드 호출" 이라는 자바의 약속에 근거.
        //interface Consumer<T>의 추상메소드인 void accept(T t)의 반환형과 매개변수 선언이 동일한 메소드인 println이 딱 맞다.
        //System.out은 PrintStream 인스턴스를 참조하는 참조변수이다.
        //따라서 메소드 참조 시 ReferenceName::InstanceMethodName 형태를 따라 System.out::println이 가능하다.
    }
}


/*
* Collection<E> 인터페이스는 Iterable<T>를 상속한다. 따라서 컬렉션 클래스들은 Iterable<T>를 대부분 구현하게 되는데, 이 인터페이스에는 다음 디폴트 메소드가 정의되어있다.
* default void forEach(Consumer<? super T> action) {
*   for(T t : this) //this는 이 메소드가 속한 컬렉션 인스턴스를 의미한다. 예제 코드에서는 ls를 의미한다.
*       action.accept(t);
* }
* */

//Reference) https://velog.io/@ym1085/Chapter24