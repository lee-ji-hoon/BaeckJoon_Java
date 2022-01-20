package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_01_12 {

    public String solution(int N, String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            /*StringBuilder binary = new StringBuilder();*/

            // 7 개씩 저장 후
            // replace("입력값","변환값") 이용해서 이진수 값으로 변환
            String tmp = str.substring(i * 7, (i + 1) * 7).replace("#", "1").replace("*", "0");
            int answer = Integer.parseInt(tmp, 2);

            /*
            String tmp = str.substring(i * 7, (i + 1) * 7); // 7개씩 끊어서 저장

            for (int j = 0; j < tmp.length(); j++) {
                if (String.valueOf(tmp.charAt(j)).equals("#")) binary.append(1);
                else binary.append(0);
            }

            int answer = Integer.parseInt(String.valueOf(binary), 2); // 2진수 변환 */

            sb.append((char)answer); // 아스키코드 값 문자 변환
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        Java_01_12 T = new Java_01_12();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solution(N,str));
    }
}
