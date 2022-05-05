package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. dp 식 찾기
 *  dp[i] = Math.max(dp[i-1] + arr[i], arr[i])
 * 2. 즉 이전까지의 합 + 현재 arr을 더한것과 / 현재 arr만 비교 해서 더 높은 것을 dp에 저장
 * 3. max에 현재 dp값과 max값 비교
 */

public class DP_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = arr[1];
        int max = arr[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);

            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
