package inflearn.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 순차검색
 * 1. N과 M 입력 후 N개의 배열 입력
 * 2. 배열 정렬
 * 3. 이분검색이므로 lt = 0 rt = N - 1 지정
 * 4. for each 구문으로 arr의 값이 M과 같아질 때 까지 반복
 *  4-1. 같으면 break 다르면 계속 진행하면서 answer ++;
 * 5. return answer;
 */
public class Java06_08 {

    public int solution(int N, int M, ArrayList<Integer> arr) {

        int answer = 1;
        Collections.sort(arr);

        for (int i : arr) {
            if(i == M) break;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

        Java06_08 T = new Java06_08();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(T.solution(N, M, arr));
    }
}
