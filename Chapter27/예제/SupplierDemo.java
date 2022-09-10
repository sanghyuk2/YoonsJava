import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {
    public static List<Integer> makeIntList(Supplier<Integer> s, int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
            //interface Supplier<Integer>의 추상메소드인 public T get() 메소드 사용.
            list.add(s.get());

        return list;
    }

    public static void main(String[] args) {
        //interface Supplier<Integer>의 get() 메소드 구현.
        Supplier<Integer> spr = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };

        //5개의 50미만 정수를 get해라
        List<Integer> list = makeIntList(spr, 5);
        System.out.println(list);

        list = makeIntList(spr, 10);
        System.out.println(list);
    }
}
