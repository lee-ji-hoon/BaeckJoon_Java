package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java01_10 {

   public String solution(String s, char t) {

       /*
        int[] answer = new int[s.length()];
        int p = 1000;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = 0;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) p = 0;
                else {
                    p++;
                    answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;*/


        String[] answer = new String[s.length()]; // 빈 배열 등록
        int cnt = 100; // 문자열의 길이 제한 생각하면서 넣기

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) { // i번째 문자열이 입력한 문자 t와 같은지 확인
                answer[i] = String.valueOf(0); // 같으면 0 입력 후 0으로 초기화
                cnt = 0;
            } else {
                cnt ++;
                answer[i] = String.valueOf(cnt);
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            cnt++;

            if (s.charAt(i) == t) {
                cnt = 0;
            } else {
                if (Integer.parseInt(answer[i]) > cnt) { // 앞에 입력 된 배열의 i 번째 값과 현재 입력할려는 cnt 값 비교 후 더 작은 수 입력
                    answer[i] = String.valueOf(cnt);
                }
            }
        }

        String answerToString = String.join(" ", answer); // 출력 형태를 배열 형태가 아닌 칸마다 공백으로 구분한다.

        return answerToString;
    }

    public static void main(String[] args) throws IOException {

        Java01_10 T = new Java01_10();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String s = st.nextToken();
        char t = st.nextToken().charAt(0);

        System.out.println(T.solution(s,t));
    }
}