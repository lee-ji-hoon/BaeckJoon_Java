package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 인접한 모든 자릿수가 1씩 차이나지만 0은 1로 9은 8로 하나씩만 파생이된다.
 * 2. 단 0으로 시작하는 경우는 없기에 처음에 선언 할 때 0은 제외 할 것
 * 3. 점화식 : dp[n][i] = dp [n-1][i-1] + dp [n-1][i+1]
 * 4. 재귀 방식으로 풀이
 * 5. 메모이제이션 사용
 */
public class DP_10844 {

    static int N;
    static Long[][] arr;

    public static void main(String[] args) throws IOException {
        DP_10844 T = new DP_10844();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            arr[0][i] = 1L;
        }

        long answer = 0;
        for (int i = 1; i <= 9; i++) {
            answer += T.solution(N, i);
        }
        System.out.println(answer % 1000000000);
    }

    public long solution(int L, int temp) {
        if (L == 1) {
            return arr[L][temp];
        }
        if (arr[L][temp] == null) {

            if (temp == 0) {
                arr[L][temp] = solution(L - 1, 1);
            } else if (temp == 9) {
                arr[L][temp] = solution(L - 1, 8);
            } else {
                arr[L][temp] = solution(L - 1, temp + 1) + solution(L - 1, temp - 1);
            }
        }
        return arr[L][temp] % 1000000000;
    }
}
