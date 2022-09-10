import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Double, Double> cti = d -> d * 0.393701;
        Function<Double, Double> itc = d -> d * 2.54;
        System.out.println("1cm = " + cti.apply(1.0) + "inch");
        System.out.println("1inch = " + itc.apply(1.0) + "cm");

        //반환형과 매개변수형이 동일한 인터페이스의 이름은 Operator로 끝나는 규칙이 있다.
        //더불어 매개변수가 하나이면 그 앞에 Unary가 붙는다.
        //위 예제의 코드 매개변수와 반환형이 동일하기에 DoubleUnaryOperator을 사용해보았다.
        DoubleUnaryOperator cti2 = d -> d * 0.393701;
        DoubleUnaryOperator itc2 = d -> d * 2.54;
        System.out.println("1cm = " + cti2.applyAsDouble(1.0) + "inch");
        System.out.println("1inch = " + itc2.applyAsDouble(1.0) + "cm");
    }
}
