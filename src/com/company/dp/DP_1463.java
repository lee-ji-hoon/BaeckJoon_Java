package com.company.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1463 {
    static Integer[] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        dp = new Integer[X + 1];
        dp[0] = dp[1] = 0; // 0이나 1의 경우는 이미 완성된 값이므로 0으로 고정

        System.out.println(recur(X));
    }

    static int recur(int N) {
        if (dp[N] == null) {

            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) ;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나눠지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
