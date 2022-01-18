package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01_07 {

    public String solution(String str) {
        str = str.toLowerCase(); // 대소문자 통일을 위해서 소문자 or 대문자로 변환
        String answer = ""; // YES NO 저장
        String backWord = ""; // reverse 글자 저장
        int j = 0;

        for (int i = str.length() - 1; i >= 0; i--) { // 뒤에서부터 저장하기
            backWord = backWord + str.charAt(i);

            if (backWord.charAt(j) == str.charAt(j)) answer = "YES";
            else answer = "NO";

            j++;
        }
        return answer;
    }

/*    public String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len -i - 1)) answer = "NO"; // gooG을 예시로 0번째로 3번째를 비교하는 것 이기 때문에 len-i-1로 비교한다.
        }

        return answer;
    }

    public String solution(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) answer = "YES"; // 단순 equals 하면 대소문자 구분때문에 오류가 난다 -> equalsIgnoreCase 사용하기

        return answer;
    }*/



    public static void main(String[] args) throws IOException {
        Java01_07 T  = new Java01_07();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.print(T.solution(str));

    }
}
