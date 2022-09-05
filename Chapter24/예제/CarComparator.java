import java.util.*;

class Car {
    protected int disp;
    public Car(int d) {disp = d;}

    @Override
    public String toString() {
        return "cc: " + disp;
    }
}

//Compare 기준을 담당하는 클래스
class CarComp implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) { return c1.disp - c2.disp;}
}

class ECar extends Car {
    private int battery;

    public ECar(int d, int b) {
        super(d);
        battery = b;
    }

    @Override
    public String toString() {
        return "cc: " + disp + ", ba: " + battery;
    }
}

public class CarComparator {
    public static void main(String[] args) {
        List<Car> clist = new ArrayList<>();
        clist.add(new Car(1800));
        clist.add(new Car(1200));
        clist.add(new Car(3000));

        List<ECar> elist = new ArrayList<>();
        elist.add(new ECar(3000, 55));
        elist.add(new ECar(1800, 87));
        elist.add(new ECar(1200, 99));

        CarComp comp = new CarComp();

        //public static <T> void sort(List<T> list, Comparator<? super T> c) 사용
        //Comparator<Car>에서 Car는 ECar의 부모클래스이다.
        Collections.sort(clist, comp);
        Collections.sort(elist, comp);

        for(Iterator<Car> itr = clist.iterator(); itr.hasNext();) {
            System.out.println(itr.next().toString() + "\t");
        }
        System.out.println();

        for(Iterator<ECar> itr = elist.iterator(); itr.hasNext();) {
            System.out.println(itr.next().toString() + "\t");
        }


    }
}
