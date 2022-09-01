/* 문제21-2) swapBox메소드를 구현하라
 *
 */
class Box<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }
}

public class SwapBox {


        public static <T extends Number> void swapBox(Box<T> b1, Box<T> b2) {
            T temp = b1.get();
            //T 대신 Box<T>를 사용하게 되면 아래 메소드호출 시 temp는 b1을 참조하고 있는 상황에서 호출하게된다.
            //아래에서 b1이 b2의 값을 세팅하여 55라는 값을 가지게되므로 temp도 55 라는 값을 지니게 된다.
            //따라서 이를 방지하게 위해서 temp에 값을 넣는다.
            b1.set(b2.get()); //b1에 55
            b2.set(temp);


        }


        public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(99);
        Box<Integer> box2 = new Box<>();
        box2.set(55);
        System.out.println(box1.get() + " & " + box2.get());
        swapBox(box1, box2);
        System.out.println(box1.get() + " & " + box2.get());
    }
}
