package baekjoon.dp;

import java.util.Scanner;

/**
 * 1. 이전에 문 계단수와 비슷한 유형의 문제
 * 2. 반복문 스타일
 * 3. 0~9까지의 숫자에서 만들 수 있는 오르막수는 이전 자릿수 N-1 에서의 j부터 마지막 9까지의 합을 구해야 함
 */

public class DP_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp;
        dp = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j ; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 10007);
    }
}
