import java.util.ArrayDeque;
import java.util.Deque;

interface DIStack<E> { //프로그래머가 만든 인공 인터페이스. stack의 기능을 활용하게 하기 위함.
    public boolean push(E item);
    public E pop();
}

class DCStack<E> implements DIStack<E> {
    private Deque<E> deq;

    public DCStack(Deque<E> d) { //Deque<E> 혹은 이를 상속하는 클래스 ArrayDeque, LinkedList를 인자로 받아들일 수 있게끔 한다.
        deq = d;
    }

    @Override
    public boolean push(E item) {
        return deq.offerFirst(item);
    }

    @Override
    public E pop() {
        return deq.pollFirst();
    }
}

public class DefinedStack {
    public static void main(String[] args) {
        DIStack<String> stk = new DCStack<>(new ArrayDeque<>());
        stk.push("1.Box");
        stk.push("2.Toy");
        stk.push("3.Robot");

        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());


    }
}

//Stack 클래스는 자바 초기에 정의된 클래스로써 지금은 이전 코드와의 호환성 유지를 위해 존재하는 클래스일 뿐 사용하지 않는다(Deque 클래스 사용).
//위 예제는 Deque를 이용한 Stack의 기능을 사용하게끔 코드를 작성하였다.