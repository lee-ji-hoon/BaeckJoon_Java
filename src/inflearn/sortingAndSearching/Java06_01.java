package inflearn.sortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N과 N개의 배열로 이루어진 숫자 입력
 * 2. 선택 정렬을 위해서 2중 for문 arr[i] 들어갈 값을 arr[i+1] ~ arr[N] 비교
 * 3. 임시 저장 장소로 index = i
 * 4. arr[index] > arr[j]
 *  4-1. true -> index = j;
 * 5. swap 호출 (arr, index, j)
 * 6. arr[i] 의 값을 바꿔야 하므로 arr[i] 값을 temp에 임시 저장
 * 7. arr[i] = arr[index], arr[index] = arr[temp] 서로 교환
 * 8. return arr
 */

public class Java06_01 {

    public int[] solution(int N, int[] arr){
        for (int i = 0; i < N - 1; i++) {

            int index = i;

            for (int j = i + 1; j < N; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            swap(arr, index, i);
        }
        return arr;
    }

    public void swap(int[] arr, int index, int i) { // i번째 값과 찾은 최솟값을 서로 교환
        int tmp = arr[i];
        arr[i] = arr[index];
        arr[index] = tmp;

    }
    public static void main(String[] args) throws IOException {

        Java06_01 T = new Java06_01();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : T.solution(N, arr)) {
            System.out.print(i + " ");
        }
    }
}
