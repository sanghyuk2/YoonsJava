import java.sql.SQLOutput;
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
        if(this.age > p.age)
            return 1;
        else if(this.age < p.age)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class ArrayObjSort {
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

/*
* 의문점1) compareTo method는 언제 호출되는가?
* 의문점2) Debugging 했을 때 왜 첫 번재 this 인스턴스는 Goo인가?
*
* 답) 자바에서 Java에서 Arrays.sort 를 통해 정렬 할 때 primitive 1차원 배열 타입의 경우 Quick Sort의 심화 구현인
* dual-pivot Quick Sort알고리즘으로 정렬이 되고, primitive 타입이 아닌 객체 타입의 배열을 정렬하게 되면 Tim Sort로 정렬된다.
* 내부 구현 시 target(여기서는 Goo)을 정하고 정렬할 때 내부구현에서 compareTo가 overriding 되어 실행된다.
*
* Reference)
* https://st-lab.tistory.com/179
* https://st-lab.tistory.com/276
* https://thebasis.tistory.com/31
 */