package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01_02 {
    /*
    설명
    대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

    입력
    첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
    문자열은 영어 알파벳으로만 구성되어 있습니다.

    출력
    첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
    */
    public String solution(String str) {

        StringBuilder sb = new StringBuilder();

        for (char x : str.toCharArray()) { // 대소문자 아스키코드 값은 32가 차이난다
            if (x >= 97 && x <= 122) sb.append(Character.toUpperCase(x));
            else sb.append(Character.toLowerCase(x));

            /*if (Character.isLowerCase(x)){
                sb.append(Character.toUpperCase(x));
            }else{
                sb.append(Character.toLowerCase(x));
            }*/
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Java01_02 T = new Java01_02();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(T.solution(str));
    }
}
