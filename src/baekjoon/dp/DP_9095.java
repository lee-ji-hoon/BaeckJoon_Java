package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4를 예시로 들면 1+2+1, 2+1+1, 1+1+2 이런 식으로 순서만 달라도 다른 경우의 수로 생각
 * 합이 입력한 값이 될 때까지 1,2,3 각각 더하고 만약 누적된 값이 입력값 보다 높으면 answer 누적 안하고 return 해서 스택 pop하기
 */

public class DP_9095 {

    static int answer = 0;
    static int temp;
    public void solution(int sum) {
        if (sum > temp) {
            return;
        }
        if (sum == temp) {
            answer++;
        } else {
            solution(sum + 1);
            solution(sum + 2);
            solution(sum + 3);
        }
    }
    public static void main(String[] args) throws IOException {
        DP_9095 T = new DP_9095();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            T.solution(0);
            arr[i] = answer;
            answer = 0;
        }
        for (int i : arr) System.out.println(i);
    }
}
