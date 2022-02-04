package inflearn.sortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N과 N개의 숫자로 이루어진 배열 arr 입력
 * 2. 삽입 정렬이므로 temp에 arr[i] 저장
 * 3. 이중 for문에서 2번째 for문은 오른쪽에서 왼쪽으로 오게 해야 함
 *  3-1. arr[j] > temp -> arr[j+1] = arr[j] 한 칸씩 이동
 *  3-2. else break
 * 4. arr[j+1] = temp
 * 5. return arr;
 */

public class Java06_03 {

    public int[] solution(int N, int[] arr){
        for (int i = 1; i < N; i++) {
            int temp = arr[i], j;
            // j가 두 번째 for문 밖에 있기 떄문에 선언을 해줘야 한다.

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) arr[j + 1] = arr[j]; // 한 칸씩 왼쪽으로 이동
                else break; // 더 이상 비교 할 필요가 없음
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        Java06_03 T = new Java06_03();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : T.solution(N, arr)) System.out.print(i + " ");
    }
}
