//p.712 예제를 Optional 클래스 기반으로 개선해보자

import java.util.Optional;

class ContInfo {
    private String phone;
    private String adrs;

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }
    public String getPhone() {return phone;}
    public String getAdrs() {return adrs;}
}

public class MapElseOptional {
    public static void main(String[] args) {

        Optional<ContInfo> oc1 = Optional.of(new ContInfo(null,"Republic of Korea"));
        String phone = oc1.map(c -> c.getPhone()).orElse("Empty");
        String address = oc1.map(c -> c.getAdrs()).orElse("Empty");

        System.out.println(phone);
        System.out.println(address);


    }
}
