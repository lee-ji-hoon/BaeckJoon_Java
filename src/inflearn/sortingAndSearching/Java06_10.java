package inflearn.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. N 과 C 입력, N개로 이루어진 배열 arr
 * 2. 이분검색 하던대로 while문까지 생성
 *  2-1. arr을 sort해주고 lt는 1부터 시작
 * 3. cnt = 1 초기화후 arr의 크기 만큼 반복, temp = arr[0]; 말 배치
 *  3-1. 말이 배치 될 수 있는 곳인지 확인 할 것
 *  3-2. arr[i] - temp >= mid -> cnt증가, temp를 arr[i]로 초기화
 *  3-3. return cnt;
 * 4. if cnt 값이 말의 수 보다 크거나 같으면 cnt 증가, mid 기준 왼쪽 값 볼 필요 없어짐 -> lt = mid + 1;
 * 5. else -> 오른쪽 값 볼 필요 없으므로 rt = mid - 1;
 * 6. return answer;
 */

public class Java06_10 {

    public int count(int[] arr, int mid) {
        int cnt = 1;
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if(arr[i] - temp >= mid ) {
                cnt++;
                temp = arr[i];
            }
        }
        return cnt;
    }

    public int solution(int N, int C, int[] arr) {

        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            }else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {

        Java06_10 T = new Java06_10();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, C, arr));

    }
}
