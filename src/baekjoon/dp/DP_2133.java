package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP_2133 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 0;

        if (N > 1) {
            dp[2] = 3;
        }
        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }
        System.out.println(dp[N]);

    }
}
