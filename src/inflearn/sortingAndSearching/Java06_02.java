package inflearn.sortingAndSearching;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N과 N개로 이루어진 배열 arr 입력
 * 2. 버블 정렬이므로 이중 for문 -> j ? j + 1 비교
 *  2-1. j > j + 1 -> swap
 *  2-2. arr[j] <-> arr[j+1]
 * 3. return arr
 */

public class Java06_02 {

    public int[] solution(int N, int[] arr) {

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if(arr[j] > arr[j+1]) swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) throws IOException {

        Java06_02 T = new Java06_02();

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
