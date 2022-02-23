package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 고려해야 할 점 : 오름차순, 중복된 조합은 출력x
 * 1. 주어진 입력받기
 * 2. line == M 일때 출력
 * 3. for(i = startNum ~ <=N)
 *  3-1. answer[L] = i
 *  3-2. DFS(line + 1, startNum + 1)
 */

public class Java08_09 {

    static int N, M;
    static int[] answer;
    public void DFS(int L, int S) {

        if (L == M) {
            for (int i : answer) System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = S; i <= N; i++) {
                    answer[L] = i;
                    DFS(L + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) {

        Java08_09 T = new Java08_09();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        answer = new int[M];

        T.DFS(0, 1);
    }
}
