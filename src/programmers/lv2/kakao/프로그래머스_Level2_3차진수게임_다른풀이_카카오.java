package programmers.lv2.kakao;

import java.util.Locale;

class 프로그래머스_Level2_3차진수게임_다른풀이_카카오 {

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        int length = m * t;
        while (sb.length() < length)
            sb.append(Integer.toString(num++, n));

        for (int i = p - 1; i < length; i += m)
            answer.append(sb.charAt(i));

        return answer.toString().toUpperCase();
    }


    public static void main(String[] args) {
        int n = 16; // 진법 n
        int t = 16; // 구할 숫자의 갯수 t
        int m = 2; // 게임에 참가하는 인원 m
        int p = 1; // 튜브의 순서 p

        String answer = solution(n, t, m, p);
        System.out.println(answer);
    }
}
