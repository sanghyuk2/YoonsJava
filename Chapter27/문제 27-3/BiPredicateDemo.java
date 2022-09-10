import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        //interface BiPredicate<T t, U u>의 test 함수 몸체 구현.
        BiPredicate<String, Integer> conv = (s, n) -> s.length() > n.intValue();

        //conv는 interface BiPredicate<T t, U u>의 참조변수이기에 함수 내 포함 된 추상 메소드인(정확히는 이를 구현하는 인스턴스의) test 호출 가능.
        //p.363) 인터페이스의 형을 대상으로 참조변수의 선언이 가능하다. 인터페이스의 추상 메소드와 이를 구현하는 메소드 사이에 오버라이딩 관계가 성립한다.
        if(conv.test("Robot", 3))
            System.out.println("문자열 길이 3 초과");
        else
            System.out.println("문자열 길이 3 이하");
        
        if(conv.test("Box", 5))
            System.out.println("문자열 길이 5 초과");
        else
            System.out.println("문자열 길이 5 이하");
    }
}
