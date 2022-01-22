package inflearn.twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1. N개의 배열 M이 되는 경우
 * 2. 투 포인터 방식으로 left, right 변수 선언
 *  2-1. sum = left ~ right 사이 배열 합
 *  2-2. M > sum -> sum += N[++right]
 *  2-3. M < sum -> sum -= N[left++]
 *  2-4. M == sum -> answer ++,  sum -= N[left++]
 * 3. N == sum -> answer++ 마지막 값까지 확인해주기.
 * 4. retrun answer;
 */


public class Java03_04 {

    public int solution(int N, int M, int[] arr) {

        int answer = 0, sum = 0;
        int left = 0, right = 0;

        sum = arr[left];
        while (right < N - 1) {

            if (M > sum) sum += arr[++right]; // right를 오른쪽으로 한 칸 옮기고 그 값을 sum에 누적
            else if (M < sum) sum -= arr[left++]; // 왼쪽 한 칸을 sum 값에서 빼고 left를 오른쪽으로 한 칸 이동
            else { // M = sum
                sum -= arr[left++]; // 같은 값의 경우에도 왼쪽 한 칸을 sum 값에서 빼고 left를 이동
                answer++; // answer 값 누적
            }
        }

        if (M == sum) answer ++; // 마지막 값 확인

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java03_04 T = new Java03_04();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, M, arr));
    }
}
