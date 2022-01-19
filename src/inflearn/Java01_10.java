package inflearn;

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


        String[] answer = new String[s.length()];
        int cnt = 100;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                answer[i] = String.valueOf(0);
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
                if (Integer.parseInt(answer[i]) > cnt) {
                    answer[i] = String.valueOf(cnt);
                }
            }
        }

        String answerToString = String.join(" ", answer);

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