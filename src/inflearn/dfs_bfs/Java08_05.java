package inflearn.dfs_bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1. 주어진 입력 받기 -> answer = Integer.MAX_VALUE
 * 2. 합이 금액보다 높거나 line이 최솟값보다 큰 경우 return
 * 3. sum == M 인경우 Math.min(answer, line)
 * 4. 중복이 가능하므로 i=0 ~ i<N 반복
 *  4-1. line + 1, sum + arr[i], arr 호출
 * 5. answer 출력
 * TODO
 * 1. 시간 초과 발생
 * 2. 배열을 Integer형으로 바꾼 뒤 Arrays.sort(arr, Collections.reverseOrder()); -> 내림차순 정렬
 */

public class Java08_05 {

    static int N, M, answer = Integer.MAX_VALUE;
    static Integer[] arr;
    public void DFS(int L, int sum, Integer[] arr) {

        if (sum > M || L >= answer) return;

        if (sum == M) answer = Math.min(answer, L);
            else {
            for (int i = 0; i < N; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {

        Java08_05 T = new Java08_05();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new Integer[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());

        M = sc.nextInt();

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
