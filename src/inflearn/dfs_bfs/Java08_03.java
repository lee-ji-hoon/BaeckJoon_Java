package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. 주어진 입력들 입력 -> 점수와 시간은 각각 1차원 배열로 입력
 * 2. 푼 문제들의 합이 주어진 시간보다 크면 return
 * 3. 끝까지 돌았을 경우 현재 갖고 있는 값보다 문제 푼 점수가 높으면 값 대입
 * 4. 풀었을 경우, 못풀었을 경우 2가지의 경우의 수 반복
 */

public class Java08_03 {

    static int N, M, answer;

    public void DFS(int L, int sum, int time, int[] A, int[] B) {
        if (time > M) return;

        if(L == N){
            answer = Math.max(answer, sum);
        }else{
            DFS(L + 1, sum + A[L], time + B[L], A, B);
            DFS(L + 1, sum, time , A, B);
        }
    }

    public static void main(String[] args) {
        Java08_03 T = new Java08_03();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); // 점수
            B[i] = sc.nextInt(); // 시간
        }

        T.DFS(0, 0, 0, A, B);

        System.out.println(answer);
    }
}
