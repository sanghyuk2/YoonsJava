import java.io.*;

public class fileInputOutput {
    public static void main(String[] args) {
        try(OutputStream out = new FileOutputStream("data.dat")) {
            //실험 : out.write(7)을 넣을 시, in.read()메소드는 7을 가져오고 7을 출력한다.
            //Question : 필터스트림의 사용 이유가 기본 자료형(Primitive type)을 코드에 활용하기 위해 이용되는데 7을 넣으면 7이 나오면 필터스트림 없이도 잘 활용된 것이 아닌가요?
            //Answer : 370을 넣을 시 114라는 원하는 값이 아닌 엉뚱한 값이 나온다. 따라서 필터스트림을 이용하여 원하는 값을 뽑아내자.
            out.write(370);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try(InputStream in = new FileInputStream("data.dat")) {
            int dat = in.read();
            System.out.println(dat);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
