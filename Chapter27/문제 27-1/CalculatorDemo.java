interface Calculate<T> {
    T cal(T a, T b);
}

public class CalculatorDemo {
    public static <T> void calAndShow(Calculate<T> op, T n1, T n2) {
        T r = op.cal(n1, n2);
        System.out.println(r);
    }

    public static void main(String[] args) {
        //인터페이스의 참조변수를 람다식으로 초기화 하듯 메소드의 매개변수를 같은방식으로 초기화한다.
        //매개변수 정보는 컴파일러 입장에서 해당 람다식이 채우게 될 메소드 정보를 통해서 유추가 가능하다.

        //a+b
        calAndShow((a, b) -> a + b, 3, 4);
        calAndShow((a, b) -> a + b, 2.5, 7.1);

        //a-b
        calAndShow((a, b) -> a - b, 4, 2);
        calAndShow((a, b) -> a - b, 4.9, 3.2);

    }
}
