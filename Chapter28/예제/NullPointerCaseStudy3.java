import javax.swing.text.html.Option;
import java.util.Optional;

class Friend {
    String name;
    Optional<Company> cmp;

    public Friend(String n, Optional<Company> c) {
        name = n;
        cmp = c;
    }
    public String getName() { return name; }
    public Optional<Company> getCmp() { return cmp; }
}

class Company {
    String cName;
    Optional<ContInfo> cInfo;

    public Company(String cn, Optional<ContInfo> ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() { return cName; }
    public Optional<ContInfo> getCInfo() { return cInfo; }
}

class ContInfo {
    Optional<String> phone;
    Optional<String> adrs;

    public ContInfo(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }
    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }
}

public class NullPointerCaseStudy3 {
    public static void showCompAddr(Optional<Friend> f) {
        //map 대신 flatMap을 사용하는 이유
        //map은 람다식이 반환하는 내용물을 Optional 인스턴스로 감싸는 일을 알아서 해주지만, flatMap은 알아서 해 주지 않기 때문에 직접 감싸주어야한다.
        //ex) .map(s -> s.toUpperCase()) == .flatMap(s -> Optional.of(s.toUpperCase()))
        //String phone = .flatMap(c -> c.getPhone()).orElse("There's no phone number") == .map(c -> c.getPhone()).get().orElse("There's no phone number")
        //즉, 클래스의 인스턴스 멤버가 Optional<T>일 때 위의 특성에 의거하여 flatMap 메소드를 사용한다.
        String address = f.flatMap(Friend::getCmp)
                .flatMap(Company::getCInfo)
                .flatMap(ContInfo::getAdrs)
                .orElse("There's no address");

        System.out.println(address);

    }
    public static void main(String[] args) {
        //Optional<T>형 인스턴스 초기화 과정
        Optional<ContInfo> ci =Optional.of(new ContInfo(Optional.ofNullable(null), Optional.of("Republic of Korea")));
        Optional<Company> cp = Optional.of(new Company("YaHo Co,. Ltd.", ci));
        Optional<Friend> frn = Optional.of(new Friend("LEE SU", cp));
        showCompAddr(frn);

    }
}
