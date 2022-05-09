package baekjoon.dp;

import java.util.Scanner;

public class DP_9461 {

    public static Long[] dp = new Long[101]; // Long 타입이 아닌 경우 int형 값을 넘어간다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        while (N-- > 0){
            int T = sc.nextInt();
            System.out.println(solution(T));
        }
    }

    public static Long solution(int N) {
        if (dp[N] == null) {
            dp[N] = solution(N - 2) + solution(N - 3);
        }
        return dp[N];
    }
}
