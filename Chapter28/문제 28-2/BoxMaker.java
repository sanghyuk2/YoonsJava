import java.util.function.BiConsumer;
import java.util.function.BiFunction;

class Box<T, U> {
    private T id;
    private U con;
    public Box(T i, U c) {
        id = i;
        con = c;
    }

    public void showIt() {
        System.out.println("ID: " + id + ", " + "Contents: " + con);
    }
}

public class BoxMaker {

    public static void main(String[] args) {
        //인자 두 개로 반환
        //28-2 문제1
        //BiFunction<Integer,String,Box<Integer,String>> bf = (i, s) -> new Box(i, s);

        //처음에 생성자를 통하여 인스턴스 변수 초기화 하는 것 보고, Consumer쓰면 안되나 싶었지만
        //Consumer의 accept 메소드는 반환형이 없기에 아래 코드처럼 참조변수를 사용할 수 없다.
        //28-2 문제2
        BiFunction<Integer, String, Box<Integer, String>> bf = Box::new;

        Box<Integer, String> b1 = bf.apply(1, "Toy");
        Box<Integer, String> b2 = bf.apply(2, "Robot");
        b1.showIt();
        b2.showIt();
    }
}
