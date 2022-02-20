package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. 주어진 입력 값들 입력 + check, answer 용 배열 추가
 * 2. line = M -> for-each( i : answer ) sout(i + " ")
 * 3. for(0 ~ N) if check[i] == 0
 * 4. arr의 현재값을 answer[line] 추가
 * 5. DFS 다음 라인 호출
 * 6. check[i] 0으로 초기화
 */
public class Java08_06 {

    static int N, M;
    static int[] arr, check, answer;

    public void DFS(int L) {

        if(L == M) {
            for (int i : answer) System.out.print(i + " ");
            System.out.println();
        }else{
            for (int i = 0; i < N; i++) {
                if (check[i] == 0) {
                    answer[L] = arr[i];
                    DFS(L + 1);
                    check[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Java08_06 T = new Java08_06();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        check = new int[N];
        answer = new int[M];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        T.DFS(0);
    }
}
