package inflearn.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. N과 M입력, N개로 이루어진 배열 arr
 * 2. 이분 검색을 위한 lt = 가장 큰 값 rt = 배열의 합
 * 3. lt <= rt 일 떄까지 반복
 *  3-1. mid 는 lt + rt 의 / 2
 *  3-2. arr를 for each 반복
 *   3-2-1. sum + i > mid 값이면 cnt++, sum은 i로 초기화 ! sum에 i값 누적
 *  3-3. cnt가 M보다 작거나 같은 경우 -> answer를 mid 값으로, 오른쪽은 더 볼 필요 없으므로 rt = mid - 1;
 *  3-4. else 왼쪽 값을 볼 필요 없고 answer 누적 필요 없음 -> lt = mid + 1;
 * 4. return answer;
 */

public class Java06_09 {

    public int count(int[] arr, int mid) {
        int cnt = 1;
        int sum = 0;

        for (int i : arr) {
            if(sum + i > mid){
                cnt ++;
                sum = i;
            }else{
                sum += i;
            }
        }
        return cnt;
    }

    public int solution(int N, int M, int[] arr) {
        int lt = arr[N - 1];
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2 ;

            if (count(arr, mid) <= M) {
                answer = mid;
                rt = mid -1;
            }else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Java06_09 T = new Java06_09();

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
