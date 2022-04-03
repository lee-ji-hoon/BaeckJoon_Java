package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 1 : 1개 [1]
 * 2 : 1개 [10]
 * 3 : 2개 [101, 100]
 * 4 : 3개 [1010, 1001, 1000]
 * 5 : 5개 [10101, 10100, 10010, 10001, 10000]
 * 피보나치 규칙 이용
 * dp[n] = dp[n-2] + dp[n-1]
 */
public class DP_2193 {

    static long[] dp;
    public static long solution(int N) {

        if (N == 1 || N ==2) return 1;
        if (dp[N] > 0) return dp[N];

        dp[N] = solution(N - 1) + solution(N - 2);
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        System.out.println(solution(N));
    }
}
