import java.util.function.ToIntBiFunction;

class IBox {
    private int n;
    public IBox(int i) { n = i;}
    public int larger(IBox b) {
        if(n > b.n)
            return n;
        else
            return b.n;
    }
}

public class NoObjectMethodRef {
    public static void main(String[] args) {
        IBox ib1 = new IBox(5);
        IBox ib2 = new IBox(7);

        //larger 메소드는 첫 번째 인자로 전달된 인스턴스의 메소드이다.
        //ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);

        //ClassName::InstanceMethodName;
        //위와 같이 선언이 되었을때는 첫번째 인자로 들어오는 인스턴스의 메소드를 호출하고 두번째 인자를
        //첫번째 메소드의 매개변수 인자로 전달하겠다는 약속이 내포되어 있다.
        ToIntBiFunction<IBox, IBox> bf = IBox::larger;

        //bf.applyAsInt(ib1, ib2) {ib1.larger(ib2);} 처럼 실행된다.
        //모든 생략은 약속에 근거한다!!
        int bigNum = bf.applyAsInt(ib1, ib2);
        System.out.println(bigNum);
    }
}
