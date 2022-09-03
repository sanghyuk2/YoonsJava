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

class Car extends Toy {
    @Override
    public String toString() {
        return "I am a Car";
    }
}

class BoxHandler {
    public static void outBox(Box<? extends Toy> box) { //box매개변수가 받는 참조변수의 매개변수화 타입은 Box<Toy>이다.
        Toy t = (Toy)box.get(); //Toy 객체를 반환하는 get메소드를 이용하여 참조변수 t로 하여금 참조값을 가리키게하였다. Toy형 참조변수가 반환됨.
        //box.set(new Toy()); //set 메소드를 outBox내부에 넣으려 하니 set메소드의 parameter 자료형을 Toy로 바꾸라고 한다.
        System.out.println(t); //println이 toString을 호출하며 "I am a Toy"를 부른다.

        //매개변수 box는 매개변수화 타입이 Box<T>가 아닌 Box<? extends Toy>이다. 즉, Box<Toy>도 아니고, Box<Car>도 아니다.
        //이러한 매개변수를 통하여 set메소드를 호출하여 new Toy() 인스턴스를 집어넣으려 하면 다음과 같이 된다.
        //set 메소드 내부
        //? extends Toy o = new Toy();
        //즉 자료형의 일치가 이루어지지않는다.
        //그렇기에 컴파일러는 프로그래머에게 set 메소드 매개변수의 o의 자료형을 Toy로 변경하라 하는것이다.
    }
    public static void inBox(Box<? super Toy> box, Toy n) { //Toy n = new Toy();
        box.set(n);
    }
}


public class Test {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>(); //T는 인스턴스 생성 시 결정됨. 즉 이 때 T는 Toy로 결정이 되었다.
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box);

        //Box<Car> cBox = new Box<>(); //Box<Car>은 Box<Toy>와 상속면에서 전혀 관계없다.
        //BoxHandler.inBox(cBox, new Car()); //따라서 Box<Toy> 매개변수화 타입을 요구하는 inBox메소드에 Box<Car> 매개변수화타입 참조변수를 인자로 보낼 수 없다.
        //BoxHandler.outBox(cBox);
    }
}
