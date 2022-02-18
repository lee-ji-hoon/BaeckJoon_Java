package inflearn.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. N개 배열 입력
 * 2. 원소의 합이 서로 같은 경우 이므로 원소의 합은 배열의 합의 / 2
 * 3. 배열의 모든 값 비교 후 2번의 조건과 동일하면 answer = "YES" 변경 후 return
 */

public class Java08_01 {

    static int[] arr;
    static String answer;
    static int total , N;
    boolean check = false;

    public void DFS(int L, int sum, int[] arr) {
        if (check) return;
        if (sum > total / 2) return;

        if (L == N) {
            if (total == sum * 2) {
                answer = "YES";
                check = true;
            }
        }else{
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {

        Java08_01 T = new Java08_01();
        Scanner sc = new Scanner(System.in);

        answer = "NO";
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        total = Arrays.stream(arr).sum();

        T.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
