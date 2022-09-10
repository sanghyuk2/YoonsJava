import java.util.function.BiConsumer;

class Box<T> {
    private T ob;
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

public class BiConsumerDemo {
    public static void main(String[] args) {
        //interface BiConsumer<T, U>의 추상메소드 public void accept(T t, U u)에 사용하기 위한 Object 타입의 인스턴스 생성.
        Box<Integer> box1 = new Box<>();
        Box<Double> box2 = new Box<>();

        //interface BiConsumer<T, U>를 구현하는 인스턴스의 오버라이딩 된 accept 메소드 구현.
        BiConsumer<Box<Integer>, Integer> bc1 = (b1, i1) -> {
            b1.set(i1);
            System.out.println(b1.get());
        };
        BiConsumer<Box<Double>, Double> bc2 = (b2, i2) -> {
            b2.set(i2);
            System.out.println(b2.get());
        };

        bc1.accept(box1, 10);
        bc2.accept(box2, 1.25);

    }
}
