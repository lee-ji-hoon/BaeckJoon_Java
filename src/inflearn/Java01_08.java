package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01_08 {

    public String solution(String str) {
        String answer = "NO";

        StringBuilder sb = new StringBuilder();

        str = str.toUpperCase().replaceAll("[^A-Z]",""); // A-Z가 아니면
        String tmp = new StringBuilder(str).reverse().toString();

        if(str.equalsIgnoreCase(tmp)) {
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
