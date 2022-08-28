/*문제20-2)
 * 2. 이름의 길이 순으로 정렬이 되도록 수정해보자. 즉 이름이 길이가 짧은 인스턴스일수록 배열의 앞쪽에 위치하도록 예제를 수정해야한다.
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
        return this.name.length() - p.name.length();
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class ArrayObjSortByName {
    public static void main(String[] args) {
        Person[] ar = new Person[3];
        ar[0] = new Person("Lee", 29);
        ar[1] = new Person("Gooo", 15);
        ar[2] = new Person("Sooooo", 37);

        Arrays.sort(ar);
        for(Person p : ar)
            System.out.println(p);
    }
}
