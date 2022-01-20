package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01_08 {

    public String solution(String str) {
        String answer = "NO";

        StringBuilder sb = new StringBuilder();

        str = str.toUpperCase().replaceAll("[^A-Z]",""); // A-Z가 아니면 빈 공간으로 만들어준다.
        String tmp = new StringBuilder(str).reverse().toString(); // 반대에서부터 확인 하기 위한 str의 reverse 된 값 생성

        if(str.equals(tmp)) { // str을 거꾸로 뒤집은 tmp와 같은지 확인
            answer = "YES";
            sb.append(answer);
        }

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {

        Java01_08 T = new Java01_08();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
