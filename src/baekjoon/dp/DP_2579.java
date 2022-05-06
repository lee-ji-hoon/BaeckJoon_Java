package baekjoon.dp;

import java.io.IOException;
import java.util.Scanner;

/**
 * 세칸 연속으로 갈 수 없다는 점 생각하면서 점화식 짜보기
 *
 * 2칸 전의 dp값 || 3칸 전의 dp + 한 칸 전의 값(3칸 전의 dp값이므로 2번째 값을 안사용 했다는 의미 -> 바로 전 값을 사용할 수 있다.)
 * 위 내용을 점화식으로 쓰면 아래와 같다.
 * Math.Max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i] (더 큰 값에 현재 값 더하기)
 *
 * 표로 그리자면 아래와 같다.
 *
 *  10 20 15 25 10 20
 *  N   0  1  2  3  4  5  6
 *  dp  0  10 30 35 50 65 65
 *  dp  0  0  20 25 55 45 75
 */

public class DP_2579 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N + 1]; // 0번째 칸은 0으로 초기화 하기 위해서 N+1
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();

        dp[0] = 0; // 시작 계단
        dp[1] = arr[1];
        if (N >= 2) { // 2인 경우에만 적용시켜야 한다. 안그러면 ArrayIndexOutBounds 오류 발생
            dp[2] = dp[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) { // 2 미만인경우 for문 시작조차 하지 않기에 따로 예외처리가 필요 없다..
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}
