import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileCopierVerNIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("대상 파일: ");
        Path src = Paths.get(sc.nextLine());

        System.out.print("사본 이름: ");
        Path dst = Paths.get(sc.nextLine());

        //1024 바이트 버퍼 생성
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //ifc는 'src가 지시하는 파일'의 내용을 읽기 위한 입력용 채널 생성
        //ofc는 'dst가 지시하는 파일'에 내용을 쓰기 위한 출력용 채널 생성
        //IOStream과 차이점 : NIO에서는 버퍼와 채널의 연결 과정을 거치지 않으며, 이 둘은 각각 독립적으로 존재한다.
        try(FileChannel ifc = FileChannel.open(src, StandardOpenOption.READ);
            FileChannel ofc = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            int num;
            while(true) {
                //채널 ifc로부터 데이터를 버퍼 buf로 읽어 들임.
                num = ifc.read(buf);
                //모든 데이터를 복사할 때까지 이 과정을 반복한다.
                if(num == -1)
                    break;
                //버퍼에 저장된 데이터를 읽을 수 있는 상태로 변경
                buf.flip();
                //버퍼에 저장된 데이터를 채널 ofc로 전송
                ofc.write(buf);
                //버퍼에 저장된 데이터를 읽어 들였다고 해서 버퍼가 비워지는것이 아니기에 .clear() 메소드를 이용하여 버퍼를 완전히 비운다.
                buf.clear();
                //혹은 buf.compact(); : 버퍼에 저장된 내용 중에서 읽은 데이터만 지운다,를 이용한다.
                //버퍼를 비우는 과정을 생략해도 컴파일과 실행은 되지만, 버퍼에 데이터가 누적이 되어 정상적인 복사의 결과를 확인할 수 없게 된다.
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//성능향상 포인트
/*
* 1. 효율적인 버퍼링
* - 기존 IO 모델을 기반으로 파일 복사 프로그램을 작성하려면 입력 스트림과 출력 스트림 각각에 버퍼 스트림을 연결해야만 했다. 즉 두 개의 버퍼가 필요했다.
* 2. 버퍼 사이의 데이터 이동 과정
* - 기존 IO 모델은 입력 버퍼에 저장된 데이터를 출력 버퍼로 이동과정이 필요했다.
* 3. Direct 버퍼 생성가능
* - allocate와 같은 Non-direct 버퍼로 분류할 수 있는 버퍼는 가상머신이 생성하고 유지하는 버퍼이다.
* 따라서 파일에 저장된 데이터를 읽어 들일 때 '파일 -> 운영체제 버퍼 -> 가상머신 버퍼 -> 실행중인 자바프로그램' 과정을 거치게된다.
* 반면 Direct 버퍼는 '파일 -> 운영체제 버퍼 -> 실행중인 자바프로그램' 과정이다.
* 하지만 Direct 버퍼의 할당과 해제에 드는 시간적 비용이 Non-direct 버퍼에 비해 다소 높기 때문에 입출력할 파일의 크기가 크지 않거나
* 버퍼를 빈번히 할당하고 해제애햐 하는 상황이라면, 오히려 Non-direct 버퍼를 이용해서 입출력을 진행하는 것이 빠를 수 있다.
* */
