package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. 주어진 입력 받기
 * 2. 8_7 이용해서 메모이제이션 저장
 * 3. line = n일 때 저장해둔 배열 출력
 * 4. for 1~N까지 반복
 *  4-1. check[i] == 0 -> 없는 숫자
 *  4-2. 출력 배열 = i
 *  4-3. DFS(line + 1, sum + 출력배열[L] * 메모배열[L]
 *  4-4. check[i] = 0;
 */
public class Java08_08 {

    static int n, f;
    static int[] b, p, check;
    // b = combination 저장
    // p = 출력을 위한 배열
    boolean flag = false;
    int[][] memo = new int[35][35];

    public int memoization(int n, int r) {
        if (memo[n][r] > 0) {
            return memo[n][r];
        }

        if (n == r || r == 0) return 1;
        else {
            return memo[n][r] = memoization(n - 1, r - 1) + memoization(n - 1, r);
        }
    }

    public void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int i : p) System.out.print(i + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) { // i가 index 번호가 아닌 대입될 숫자
                if(check[i] == 0){
                    check[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Java08_08 T = new Java08_08();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt(); // 마지막 숫자

        b = new int[n];
        p = new int[n];
        check = new int[n + 1]; // 숫자의 시작이 1부터 돌기 때문

        for (int i = 0; i < n; i++){
            b[i] = T.memoization(n - 1, i);
        }

        T.DFS(0, 0);
    }
}
