package inflearn.sortingAndSearching;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. N명 입력 및 N명으로 이루어진 숫자 입력
 * 2. 1 ~ N , 2 ~ N 개 이런 식으로 N까지 비교하는건 비효율적
 * 3. Arrays.sort()로 정렬, answer = "U" 초기화
 * 4. for(0 ~ N-1)
 *  4-1. if(arr[i] == arr[i+1]) -> answer = "D" break; 같은 것을 발견했으므로 더 볼 필요 없음
 * 5. return answer
 */

public class Java06_05 {

    public String solution(int N, int[] arr) {

        String answer = "U";
        Arrays.sort(arr);

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i+1]) {
                answer = "D";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java06_05 T = new Java06_05();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, arr));
    }
}
