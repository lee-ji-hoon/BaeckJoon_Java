package inflearn.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우 방식으로 해결
 * 1. N개 만큼의 숫자열 입력, K입력
 * 2. N개 의 배열 중에 K일 동안의 최대 값을 구해야 하므로 0 ~ K 일 동안의 값을 하나 생성
 *  2-1. temp[0] + temp[1] ~ temp[K-1] + temp[K] 합으로 이루어진 변수 sum -> answer 저장
 *  2-2. sum 에서 맨 처음 값 temp[0]을 빼고 temp[K+1] 추가 후 Math.max(answer, sum) -> answer 저장
 * 3. return answer
 */

public class Java03_03 {

    public int solution(int N, int K, int[] temp) {

        int sum = 0, answer = 0;

        for (int i = 0; i < K; i++) {
            sum += temp[i]; // 윈도우 생성
        }
        answer = sum; // 최댓값을 구해야 하므로 우선 answer에 sum값 대입

        for (int i = K; i < N - K; i++) {
            sum += (temp[i] - temp[i - K]);
            // [] -> 윈도우 현재 sum 값
            // [10 7 8] 7 8 2 9 -> 10 [7 8 7] 8 2 9
            // 즉 맨 처음꺼는 빼고 마지막에서 + 1 된 값은 더해주면 된다.

            answer = Math.max(answer, sum); // answer 와 sum 중 큰 값이 -> answer 대입
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_03 T = new Java03_03();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, K, temp));
    }
}
