package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP_11052 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] cardList = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cardList[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], cardList[j] +  dp[i - j]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
