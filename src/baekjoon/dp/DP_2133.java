package baekjoon.dp;

import java.util.Scanner;

/**
 * 1(1) = 1
 * 2(2) = 1^2 + 1^2
 * 3(3) = 1^2 + 1^2 + 1^2
 * 4(1) = 2^2 ( 1^2 + 1^2 + 1^2 + 1^2)
 * 5(2) = 2^2 + 1^2 ( 1^2 + 1^2 + 1^2 + 1^2 + 1^2)
 * 6(3) = 2^2 + 1^2 + 1^2
 * 7(3) = 2^2 + 1^2 + 1^2 + 1^2
 * 8(2) = 2^2 + 2^2
 * 9(1) = 3^2
 * 10(2) = 3^2 + 1^2
 *
 * dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
 *
 * i=2 j=1 => dp[2], dp[1] + 1
 *
 * i=3 j=1 => dp[3], dp[2] + 1
 */

public class DP_2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = i; // 최대 수 예) 5일 경우 (1^2)*5라는 의미
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
