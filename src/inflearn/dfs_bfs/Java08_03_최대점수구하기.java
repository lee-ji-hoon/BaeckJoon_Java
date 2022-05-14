package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java08_03_최대점수구하기 {
    static int max = Integer.MIN_VALUE;

    void solution(int L, int sum, int count, int N, int M, int[][] arr) {
        // count(시간) 이 M(주어진 최대시간) 보다 크다면 return
        // L == N 인 경우도 체크해야 한다.
        if (count > M) return;

        if (L == N){
            max = Math.max(max, sum);
            return;
        }
        // 더할 경우
        solution(L + 1, sum + arr[L][0], count + arr[L][1], N, M, arr);
        // 안 더할 경우
        solution(L + 1, sum, count, N, M, arr);
    }

    public static void main(String[] args) throws IOException {
        Java08_03_최대점수구하기 main = new Java08_03_최대점수구하기();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer forToken = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(forToken.nextToken());
            arr[i][1] = Integer.parseInt(forToken.nextToken());
        }

        main.solution(0, 0, 0, N, M, arr);

        System.out.println(max);
    }
}
