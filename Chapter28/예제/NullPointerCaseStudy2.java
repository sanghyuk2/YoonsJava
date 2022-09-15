import java.util.Optional;

class Friend {
    String name;
    Company cmp;

    public Friend(String n, Company c) {
        name = n;
        cmp = c;
    }
    public String getName() {return name;}
    public Company getCmp() {return cmp;}
}

class Company {
    String cName;
    ContInfo cInfo;

    public Company(String cn, ContInfo ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() {return cName;}
    public ContInfo getCInfo() {return cInfo;}
}

class ContInfo {
    String phone;
    String adrs;

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }

    public String getPhone() {return phone;}
    public String getAdrs() {return adrs;}

}

public class NullPointerCaseStudy2 {
    public static void showCompAddr(Optional<Friend> f) {
        String address = f.map(Friend::getCmp).map(Company::getCInfo).map(ContInfo::getAdrs).orElse("There's no address information");
        System.out.println(address);
    }

    public static void main(String[] args) {
        ContInfo ci = new ContInfo("321-444-577", "Republic of Korea");
        Company cp = new Company("YaHo Co., Ltd", ci);
        Friend frn = new Friend("LEE SU", cp);

        showCompAddr(Optional.of(frn));
        
        //어차피 showCompArrd 메소드에 Optional<Friend> 형 인스턴스 복사할 것인데 한 번에 끝내면 안되는가? 라는 생각
        //Optional<Friend> opfrn = Optional.of(new Friend("Lee SU", new Company("YaHo Co., Ltd", new ContInfo("321-444-577", "Republic of Korea"))));
        //showCompAddr(opfrn);
    }
}
