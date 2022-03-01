package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n = 1 ? |
 * n = 2 ? ||,=
 * n = 3 ? |||, |=, =|
 * n = 4 ? ||||, ||=, |=|, =||, ==
 *
 * 위와 같이 만들어지는데 1, 2, 3, 5
 * 3부터는 (n-2) + (n-1)이게 된다.
 * 그러면 피보나치떄 풀었던 것 처럼 풀 수 있는데
 *
 * n = 1 answer[1] = 1
 * n = 2 answer[2] = 2
 * n = 3 answer[3] = answer[1] + answer[2]
 * n = 4 answer[4] = answer[2] + answer[3]
 */
public class DP_11726 {
    static int[] answer;

    public int solution(int n) {

        if(answer[n] > 0) return answer[n];
        else if(n == 1) return answer[n] = 1;
        else if(n == 2) return answer[n] = 2;
        else {
            return answer[n] = (solution(n - 2) + solution(n - 1)) % 10007;
            // 마지막 값만 10007로 나눈게 아닌 값을 넣을때마다 나눈 이유는
            // 10007로 나눈 나머지를 저장하지 않으면 자료형의 크기를 넘을 수도 있다 -> 백준 런타임 에러
        }
    }

    public static void main(String[] args) throws IOException {
        DP_11726 T = new DP_11726();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        answer = new int[n + 1];

        T.solution(n);

        System.out.println(answer[n]); // 마지막 값만 출력
    }
}
