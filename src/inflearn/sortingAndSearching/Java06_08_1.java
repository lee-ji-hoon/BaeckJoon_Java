package inflearn.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

/** 이분검색
 * 1. N과 M 입력 후 N개의 배열 입력
 * 2. 배열 정렬
 * 3. 이분검색이므로 lt = 0 rt = N - 1 지정
 * 4. while(lt <= rt)
 *  4-1. 중간값인 mid는 (lt+rt) / 2
 *  4-2. if 배열의 중간값이 정답인 M과 같다면 answer에 mid + 1 -> 배열은 0부터 시작이므로 + 1
 *  4-3. if 배열의 중간값이 M보다 크다면 rt를 mid - 1 방향으로 이동
 *  4-4. else lt를 mid + 1
 * 5. return answer
 */

public class Java06_08_1 {

    public int solution(int N, int M, int[] arr) {

        // 이분 검색
        int answer = 1;
        Arrays.sort(arr);
        int lt = 0, rt = N - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == M) {
                answer = mid;
                break;
            }

            if (arr[mid] > M) rt = mid - 1;
            else lt = mid + 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        Java06_08_1 T = new Java06_08_1();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, M, arr));
    }
}
