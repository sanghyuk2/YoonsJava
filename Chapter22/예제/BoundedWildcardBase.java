class Box<T> {
    private T ob; //Toy ob
    public void set(T o) {ob = o;} //Toy o = n == new Toy(); , ob = new Toy();
    public T get() {return ob;}

}

class Toy {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler {
    public static void outBox(Box<Toy> box) {
        Toy t = box.get(); //Toy 객체를 반환하는 get메소드를 이용하여 참조변수 t로 하여금 참조값을 가리키게하였다.
        System.out.println(t); //println이 toString을 호출하며 "I am a Toy"를 부른다.
    }
    public static void inBox(Box<Toy> box, Toy n) { //Toy n = new Toy();
        box.set(n);
    }
}

public class BoundedWildcardBase {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box);
    }
}

/*
* 잘 정의된 메소드는 필요한 만큼만 기능을 허용하여, 코드의 오류가 컴파일 과정에서 최대한 발견되도록 한다.
* 위의 예제 outBox는 상자를 꺼내는 용도로만 사용되어야 하는데, set메소드를 넣어도 오류가 컴파일 과정 내 발생하지 않는다.
* 따라서 set은 불가능하도록 아래 코드와 같이 제한을 거는 것이 좋다.
*
* public static void outBox(Box<? extends Toy> box) { //Toy이거나 Toy를 직.간접적으로 상속하는 클래스들을 인자로 전달가능.
*   box.get();
*   box.set(new Toy()); //에러발생!!!
*
* }
*
* 예를 들어 위에 코드에 Toy를 상속하는 클래스, Car이 존재한다고 가정하자. class Car extends Toy {...}
* Box<Car> box = new Box<>();
* BoxHandler.inBox(box, new Car()); //box에 Car 객체를 넣는다.
* BoxHandler.outBox(box); //box에서 Car 객체를 꺼낸다.
*
* outBox메소드에서는 아래와 같이 작동한다.
* Box<Car> box = box
* box.get(); //자료형이 Car인 참조변수 ob 반환
* box.set(new Toy()); -> Car o = new Toy();
* 즉, Car이 Toy를 상속하기에 Car 참조변수가 부모클래스의 인스턴스를 참조할 수 없다. 따라서 outBox에 set메소드를 넣을 수 없다.
* 정리하자면, 위 메소드의 매개변수로 Toy 인스턴스를 저장할 수 있는 상자만(Box<T> 인스턴스만) 전달된다는 사실을 보장하 수 없기 때문이다.
* */