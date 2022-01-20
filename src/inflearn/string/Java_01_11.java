package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_01_11 {

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        str = str + " ";
        int cnt = 1;

        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) != str.charAt(i+1)) {
                sb.append(str.charAt(i));
                if (cnt > 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
            }
            else cnt ++;
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {

        Java_01_11 T = new Java_01_11();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
