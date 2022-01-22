package inflearn.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 정수 N 만큼의 배열 생성 15면 1 ~ 14까지의 배열 arr 생성
 * 2. pointer) left, right = 0
 * 3. right 값이 N - 2 될 때 까지 반복
 *  3-1. sum < N -> sum += arr[++right]
 *  3-2. sum > N -> sum -= arr[left++]
 *  3-3. sum = N -> sum -= arr[left++], answer ++;
 * 4. sum == N -> answer ++
 */
public class Java03_05 {

    public int solution(int N, int[] arr) {

        int answer = 0;
        int left = 0, right = 0;
        int sum = arr[left];

        while (right < N - 2) {

            if (sum < N) {
                sum += arr[++right];
            } else if (sum > N) {
                sum -= arr[left++];
            }else{
                sum -= arr[left++];
                answer++;
            }
        }
        if (sum == N) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_05 T = new Java03_05();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] temp = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {

            temp[i] = i + 1;
        }
        System.out.println(T.solution(N,temp));
    }
}
