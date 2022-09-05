import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Car implements Comparable<Car> {
    protected int disp;

    //public Car() {};

    public Car(int d) {disp = d;}

    @Override
    public String toString() {
        return "cc: " + disp;
    }
    @Override
    public int compareTo(Car c) { return disp - c.disp;}
}

//ECar 클래스는 Car 클래스를 간접구현한다. 즉 Comparable<Car>을 간접구현한다.
class ECar extends Car {
    private int battery;
    //하위 클래스의 인스턴스 생성 시 상위 클래스, 하위 클래스의 생성자 모두 호출된다.
    public ECar(int d, int b) {
        //하위 클래스 생성 시 상위 클래스의 생성자가 먼저 호출된다.
        super(d);
        /* 궁금한 점) 하위 클래스의 constructor에서 상위 클래스의 constructor 호출을 명시적으로 하지 않을 시 자동으로 상위 클래스의
        * Default constructor 가 삽입되는 줄 알았는데 왜 "There is no default constructor in "Car""이라는 에러가 발생하나요?
        * 답변) Default constructor는 매개변수를 가지는 생성자를 하나라도 정의했을 시, 자동으로 생성되지 않는다.
        * Car 클래스의 경우 매개변수가 있는 생성자를 가지고 있으므로, default constructor가 없다.
        * reference)
        * https://miyakita.tistory.com/202
        * */
        battery = b;
    }

    @Override
    public String toString() {
        return "cc: " + disp + ", ba: " + battery;
    }



}

public class ECarSortCollections {
    public static void main(String[] args) {
        List<ECar> list = new ArrayList<>();
        list.add(new ECar(1200, 99));
        list.add(new ECar(3000, 55));
        list.add(new ECar(1800, 87));
        //Comparabla<Car>을 간접 구현하는 ECar 클래스이기에 public static <T extends <Comparable<? super T>> sort(List<T> list)를 사용가능.
        Collections.sort(list);

        for(Iterator<ECar> itr = list.iterator(); itr.hasNext();) {
            System.out.println(itr.next().toString() + "\t");
        }
    }
}
