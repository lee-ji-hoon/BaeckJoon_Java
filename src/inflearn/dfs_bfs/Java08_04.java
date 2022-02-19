package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. 주어진 입력 설정 후 숫자들 저장할 배열 생성
 * 2. 모든 숫자 한 번씩 돌면서 해야하므로 DFS
 * 3. DFS 호출 수가 M개 일때 배열 출력
 * 4. 1~N까지 번호가 적혀 있으므로 1~N번 반복해서 배열에 i저장 후 DFS(L+1) 호출
 */
public class Java08_04 {
    static int N, M;
    static int[] arr;

    void DFS(int L) {

        if (L == M) {
            for (int i : arr) System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Java08_04 T = new Java08_04();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        T.DFS(0);
    }
}
