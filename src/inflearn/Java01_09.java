package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01_09 {

    public String solution(String str){

        StringBuilder sb = new StringBuilder();
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            //if(str.charAt(i) >= 48 && str.charAt(i) <= 57) answer = answer + str.charAt(i); // sb.append(str.charAt(i));
            if(Character.isDigit(str.charAt(i))) answer = answer + str.charAt(i); // isDigit() 괄호 안의 문자가 숫자인지 판별
        }
        sb.append(Integer.parseInt(answer));

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        Java01_09 T = new Java01_09();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
