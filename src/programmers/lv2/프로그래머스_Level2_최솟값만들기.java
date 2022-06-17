package programmers.lv2;

import java.util.Arrays;

public class 프로그래머스_Level2_최솟값만들기 {
    public int solution(int[] A, int[] B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length; i++) {
            answer += (A[i] * B[B.length - i - 1]);
            System.out.println("answer = " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_최솟값만들기 s = new 프로그래머스_Level2_최솟값만들기();
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};

        s.solution(a, b);
    }
}
