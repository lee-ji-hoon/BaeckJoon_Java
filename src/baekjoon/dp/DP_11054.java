package baekjoon.dp;

import java.util.Scanner;

/**
 * 1. LIS(Longes Increasing Subsequence) 알고리즘 이용
 * 2. 증가하는 경우 / 감소하는 경우 즉 -> <- 이렇게 2개 경우 다 체크해야 한다.
 * 3. dp에 길이 저장 후 2개의 dp의 각 위치의 값을 더하고 그 중에서 max 값을 구한다.
 *
 * [앞에서부터 증가]
 * [arr]   1 5 2 1 4 3 4 5 2 1
 * [r_dp]  1 2 2 1 3 3 4 5 2 1
 *
 * [뒤에서부터 증가]
 * [arr]   1 5 2 1 4 3 4 5 2 1
 * [l_dp]  1 5 2 1 4 3 3 3 2 1
 *
 * [max]
 * [arr]   1 5 2 1 4 3 4 5 2 1
 * [sum]   1 7 4 2 7 5 7 8 4 2
 *
 * 즉 5를 기준으로 최댓값이 생기게 된다.
 * 왼쪽->오른쪽 : 1, 2, 4, 5
 * 오른쪽->왼쪽 : 5, 2, 1
 * 즉 5가 겹치게 되기에 이때문에 1을 빼줘야 한다.
 */
public class DP_11054 {

    static int N;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N + 1];
        int[] r_dp = new int[N + 1];
        int[] l_dp = new int[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            r_dp[i] = 1;
            for (int j = 1; j < i; j++) {
                dp(r_dp, i, j);
            }
        }

        for (int i = N; i > 0; i--) {
            l_dp[i] = 1;
            for (int j = N; j > i; j--) {
                dp(l_dp, i, j);
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) max = Math.max(max, l_dp[i] + r_dp[i]);

        System.out.println(max - 1);
    }

    static void dp(int[] dp, int i, int j) {
        if (arr[i] > arr[j]) {
            dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
    }
}
