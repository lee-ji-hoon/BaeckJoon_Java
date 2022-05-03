package baekjoon.dp;

import java.util.Scanner;

/**
 * 1. 가장 긴 증가하는 부분 수열
 * 2. 조건 혹은 점화식 찾기
 * 3. 부분 수열이므로 이전의 값들을 비교하며 dp에 수열 길이 저장
 * 4. 2중 for문 사용 ( i = 2; i <= N // j = 1; j < i;)
 *  4-1. arr[i] > arr[j] && dp[i] == dp[j]
 * 5. max = Math.max(max, arr[i])
 */
public class DP_11053 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        dp[1] = 1;
        int max = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1; // 기본 길이는 1이다.
            for (int j = 1; j < i; j++) { // i가 3이면 j는 1~2까지 탐색
                if (arr[i] > arr[j] && dp[i] == dp[j]) { // 현재 arr[i](현재)이 arr[j](이전) 보다 크고 dp의 값도 동일한 경우만 체크
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]); // max에 저장된 값과 dp[i]값 비교
        }
        System.out.println(max);
    }
}
