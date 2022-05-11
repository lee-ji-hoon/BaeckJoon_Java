package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 설명
 *
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
 * 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
 *
 * 길이가 5인 최대 부분 증가수열을 만들 수 있다.
 * 
 * 2 2
 * 7 2 7
 * 5 2 5 
 * 8 2 5 8, 7 8
 * 6 2 5 6
 * 4 2 4
 * 7 2 5 6 7
 * 12 2 5 6 7 12
 * 3
 *
 * arr[i] > arr[j]
 * dp[i] = Math.max(dp[i], dp[j] + 1)
 * max = Math.max(max, dp[i]
 */

public class Java10_3_최대부분증가수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int max = dp[1];

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
