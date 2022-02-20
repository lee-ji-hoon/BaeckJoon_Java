package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 1. 조합수를 구하는 공식
 * 2. 입력 값 받아오기
 * 3. 2차원 배열에 공식의 값 저장하기
 * 4. DFS 반복 중 배열의 값이 0보다 크면 return 배열
 * 5. N과 R이 같거나 R이 0이면 return 1;
 */

public class Java08_07 {

    static int N, R;
    static int[][] answer = new int[40][40];

    public int DFS(int N, int R) {

        if(answer[N][R] > 0) return answer[N][R];
        if(N == R || R == 0) return 1;
        else return answer[N][R] = DFS(N - 1, R - 1) + DFS(N - 1, R);

    }

    public static void main(String[] args) {

        Java08_07 T = new Java08_07();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        System.out.println(T.DFS(N, R));
    }
}
