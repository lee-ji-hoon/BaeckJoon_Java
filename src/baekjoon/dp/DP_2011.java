package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_2011 {

    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        if (str.charAt(0) < '1' || str.charAt(0) > '9') { // 1 ~ 9 사이의 숫자가 아닌 경우 0출력
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= str.length(); i++) { // dp[2] 부터 탐색
            int one = str.charAt(i - 1) - '0'; // 현재 숫자
            if (one >= 1 && one <= 9) dp[i] += dp[i - 1] % MOD;

            int two = str.charAt(i - 2) - '0'; //

            int sum = one + two * 10;
            if (sum >= 10 && sum <= 26) dp[i] += dp[i - 2] % MOD;
        }
        System.out.println(dp[str.length()] % MOD);
    }
}
