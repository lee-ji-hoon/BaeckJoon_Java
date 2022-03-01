package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ====================================
 * DFS 풀이
 * 11726 버전에서 2x2 도형이 추가 됨
 *
 * 2칸을 쓰는 2x2 도형
 * 2칸을 쓰는 1x2 도형
 * 1칸을 쓰는 2x1 도형
 *
 * 이 3가지의 경우가 있다는 것을 생각하고 문제를 풀기
 * ====================================
 * DP 풀이
 * 점화식 만들어서 풀기
 * 전체적인 느낌은 DFS랑 다를게 없음
 * ====================================
 */

public class DP_11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;

        System.out.println(dp[n]);
    }
}
