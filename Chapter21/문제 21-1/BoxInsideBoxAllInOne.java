/* 문제2) 별도의 클래스 정의 없이 DBox 하나만 이용하여 DDBox의 역할까지 수행하라
*
*/

class DBox<L, R> {
    private L left; //DBox<String, Integer> left;
    private R right; //DBox<String, Integer> right;
    public void set(L o, R r) { //DBox<String, Integer> box1, DBox<String, Integer> box2;
        left = o; //left = box1
        right = r;
    }

    @Override
    public String toString() { return left + " & " + right ;} //return box1 + " & " + box2;
}

public class BoxInsideBoxAllInOne {
    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple",25);
        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange",33);

        DBox<DBox<String, Integer>, DBox<String, Integer>> box3 = new DBox<>();
        box3.set(box1, box2);
        System.out.println(box3); //box1.toString(Apple & 25) & box2.toString(Orange & 33) -> Apple & 25 & Orange & 33

    }
}


