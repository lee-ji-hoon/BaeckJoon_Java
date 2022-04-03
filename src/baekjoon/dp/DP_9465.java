package baekjoon.dp;

import java.util.Scanner;

/**
 * 완전 검색 방법이지만 시간 초과 오류 남
 * 1. arr[2+2][N+2] -> +2 한 이유 4방향 전부다 0으로 초기화 하기 위해서
 * 2. 입력된 배열의 가장 높은 값 찾기
 * 3. 그 값의 4방향 전부 다 0으로 초기화
 * 4. 다음 최댓값 찾기
 *
 * dp 방법으로 풀어보기
 * 상하좌우는 볼 필요 없으므로 0행일 때 대각선값들을 찾아서 풀어보기
 */
public class DP_9465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // 열
            int[][] arr = new int[2][n+1]; // 배열 생성
            int[][] dp = new int[2][n+1]; // 0행 1행 임시 값 저장

            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = sc.nextInt(); // 배열 객체 추가
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) { // 점화식
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }
    }
}
