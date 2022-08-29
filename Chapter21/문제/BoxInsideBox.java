/* 문제 21-1
* 수납공간이 둘로 나눠져 있는 상자를 표현한 클래스를 DDBox<U, D>라는 이름으로 하나 더 정의하여 DBox<L,R> 인스턴스 둘을 이 상자에 저장하려한다.
* 다음 main메소드를 기반으로 컴파일 및 실행이 가능하도록 DDBox<U, D> 제네릭 클래스를 정의해보자.
* */
class DBox<L, R> {
    private L left;
    private R right;
    public void set(L o, R r) {
        left = o;
        right = r;
    }
    public String toString() { return left + " & " + right;}
}

class DDBox<U, D> {
    private U up; //DBox<String, Integer> up;
    private D down; //DBox<String, Integer> down;
    public void set(U u, D d) {
        up = u; //up = box1, 즉, 매개변수화 타입이 DBox<String, Integer>인 참조변수 up이 참조하는것은 매개변수로 받아들여진 box1이다.
        down = d;
    }

    public String toString() { return up + "\n" + down; }
}

public class BoxInsideBox {
    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);
        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange", 33);
        DDBox<DBox<String,Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
        ddbox.set(box1, box2);
        System.out.println(ddbox);
    }
}
