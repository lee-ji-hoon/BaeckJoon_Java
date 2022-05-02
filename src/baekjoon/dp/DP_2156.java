package baekjoon.dp;

import java.util.Scanner;

/**
 * 점화식 만들기 전 주의 사항
 * - 4개의 포도주가 있다고 쳤을 때 1,2,3을 더한 것 보다 2,4를 더한게 더 높을수도 있다
 * - 즉 무조건 많이 더한다고 좋은게 아니므로 경우의 수를 한 개 더 생각해야 한다.
 *
 * 점화식 만들기 (i가 3부터 시작한다는 가정하에 시작)
 * dp[i] = dp[i-2] + list[i], dp[i-3] + list[i-1] + list[i], dp[i-1] 3개 비교하기
 */

public class DP_2156 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] graphList = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i < n + 1; i++) {
            graphList[i] = sc.nextInt();
        }

        dp[1] = graphList[1]; // 1잔이면 무조건 1번이 답
        dp[2] = dp[1] + graphList[2]; // 2잔까지는 1~2번까지의 합

        for (int i = 3; i <= n; i++) {
            // 3가지를 비교
            dp[i] = Math.max(Math.max(dp[i - 2] + graphList[i], dp[i - 3] + graphList[i - 1] + graphList[i]), dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
