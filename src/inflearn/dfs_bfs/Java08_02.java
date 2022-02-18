package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. 08_01과 흡사한 문제
 * 2. 주어진 입력들 입력 받기
 * 3. 무게의 합이 C 보다 크면 바로 return
 * 4. line = N인 경우 Math.max(이전까지 더해진값, 현재값)
 * 5. DFS(line+1, total+현재값, arr)
 * 6. DFS(line+1, total, arr)
 */


public class Java08_02 {

    static int[] arr;
    static int C, N, answer = 0;

    public void DFS(int L, int total, int[] arr) {
        if(total > C) return;
        else{
            if(L == N) {
                answer = Math.max(answer, total);
            }else {
                DFS(L + 1, total + arr[L], arr);
                DFS(L + 1, total, arr);
            }
        }
    }
    public static void main(String[] args) {
        Java08_02 T = new Java08_02();

        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N];

        int total = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
