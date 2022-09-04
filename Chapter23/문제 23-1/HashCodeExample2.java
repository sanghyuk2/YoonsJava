/* 문제 23-1 2번째문제)
* Object.hash를 사용해보자
* */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name= name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + "(" + age + "세)";
    }

    /*
    @Override
    public int hashCode() {
        return (name.hashCode() + age)/2;
    }

     */

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        String n = ((Person)obj).name;
        int a = ((Person)obj).age;

        if(name.equals(n) && (age == a))
            return true;
        else
            return false;
    }
}

public class HashCodeExample2 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("이상혁",25));
        set.add(new Person("이상혁",25));
        set.add(new Person("김순미",23));
        System.out.println("인스턴수 수: " + set.size());

        for(Iterator<Person> str = set.iterator(); str.hasNext();)
            System.out.print(str.next() + "\t");
    }

}
