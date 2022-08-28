/*문제20-2)
 * 1.나이의 역순으로 정렬이 되도록 해보자. 다시 말해서, 많은 나이의 인스턴스일수록 배열의 앞쪽에 위치하도록 예제를 수정해보자.
 *
 * */
import java.util.Arrays;

class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return p.age - this.age; //이는 this.age - p.age에 -1을 곱한 값이다.
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class ArrayObjSortReverse {
    public static void main(String[] args) {
        Person[] ar = new Person[3];
        ar[0] = new Person("Lee", 29);
        ar[1] = new Person("Goo", 15);
        ar[2] = new Person("Soo", 37);

        Arrays.sort(ar);
        for(Person p : ar)
            System.out.println(p);
    }
}
