class Business implements Cloneable {
    private String company;
    private String work;
    public Business(String company, String work) {
        this.company = company;
        this.work = work;
    }
    public void showBusinessInfo() {
        System.out.println("company: " + company);
        System.out.println("work: " + work);
    }

    public void changeBusiness(String company, String work) {
        this.company = company;
        this.work = work;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class PersonalInfo implements Cloneable {
    private String name;
    private int age;
    private Business bz;
    public PersonalInfo(String name, int age, String company, String work) {
        this.name = name;
        this.age = age;
        bz = new Business(company, work);
    }

    public void ChangePersonalInfo(String name, int age, String company, String work) {
        this.name = name;
        this.age = age;
        bz.changeBusiness(company,work);
    }

    public void showPersonalInfo() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        bz.showBusinessInfo();
    }

    @Override
    public PersonalInfo clone() throws CloneNotSupportedException {
        PersonalInfo p = (PersonalInfo)super.clone();

        p.bz = (Business)bz.clone();

        return p;
    }
}

public class CloneExample {
    public static void main(String[] args) {
        PersonalInfo org = new PersonalInfo("이상혁", 25,"Naver","Developer");
        PersonalInfo cpy;

        try {
            cpy = org.clone();
            org.ChangePersonalInfo("김순미", 23, "FoodFactory", "CEO");
            org.showPersonalInfo();
            System.out.println();
            cpy.showPersonalInfo();

        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

/*
문제 풀기 전 의문점 : Business class 내 멤버변수들이 둘 다 String이다. String은 문자열의 수정이 불가능하므로, 깊은 복사의 대상에서 제외해도 된다고 알고있다.
그렇기에 깊은 복사 작업 없이 그냥 clone해도 되지 않을까?

만약 위처럼 한다면 org를 Chagne메소드를 통하여 변경하였을 때 참조변수 cpy의 name과 age는 바뀌지 않을지언정 같은 참조값을 가리키는 참조변수로 인하여 company와
work는 바뀌지 않는 exception이 생긴다. 따라서 설령 Business 내 멤버변수들이 모두 String이더라도 깊은 복사 과정이 필요하다.
 */