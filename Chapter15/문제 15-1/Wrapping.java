/* 문제 15-1) instanceof 연산자를 사용하지 않고 메소드 오버라이딩 기반으로 예제가 동작하도록 코드를 수정해보자.
* */
class Box {
    public void wrap() {
        System.out.println("Simple Wrapping");
    }
}

class PaperBox extends Box {
    @Override
    public void wrap() {
        System.out.println("Paper Wrapping");
    }
}

class GoldPaperBox extends PaperBox {
    @Override
    public void wrap() {
        System.out.println("Gold Wrapping");
    }
}

public class Wrapping {
    public static void main(String[] args) {
        Box box1 = new Box();
        PaperBox box2 = new PaperBox();
        GoldPaperBox box3 = new GoldPaperBox();

        wrapBox(box1);
        wrapBox(box2);
        wrapBox(box3);

    }

    public static void wrapBox(Box box) {
        box.wrap();
    }
}
