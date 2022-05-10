package baekjoon.dp;

import java.util.Scanner;

public class DP_2255 {
    private static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[201][201]; // N과 K 둘 다 최대 200까지

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1; // 기본 값들

            for (int j = 1; j <= N; j++) {
                // 1000000000 으로 미리 나눠서 dp에 저장해야지 overflow 방지 가능하다.
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println(dp[K][N]);
    }
}
