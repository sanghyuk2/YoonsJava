//문제 29-2) p.745의 ToyStream.java의 ToyPriceInfo 클래스에 getModel()메소드를 추가하자.
//필터링 조건 : model이 참조하는 문자열의 길이가 10을 넘으면 해당 인스턴스 통과.
//맵핑 방법 : ToyPriceInfo 인스턴스 -> String 인스턴스(모델명)

import java.util.ArrayList;
import java.util.List;

class ToyPriceInfo {
    private String model;
    private int price;

    public ToyPriceInfo(String m, int p) {
        model = m;
        price = p;
    }
    public int getPrice() {
        return price;
    }
    //추가된 메소드
    public String getModel() { return model; }
}

public class ToyStream {
    public static void main(String[] args) {
        List<ToyPriceInfo> ls = new ArrayList<>();
        ls.add(new ToyPriceInfo("GUN_LR_45", 200));
        ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
        ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));

        //filter 메소드의 매개변수는 Predicate 형이다. boolean test(T t) 즉, 반환형이 true or false이다.
        //map 메소드의 매개변수는 Function 형이다. R apply(T t) 즉, 반환형은 메소드 호출 시 결정된다.
        ls.stream()
                //메소드 참조방식으로 (ClassName::InstanceMethodName) 람다식을 줄였다.
                .map(ToyPriceInfo::getModel)
                //model명의 길이가 10을 넘을 시 반환한다.
                .filter(model -> model.length() > 10)
                .forEach(System.out::println);
    }
}
