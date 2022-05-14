package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java08_07_조합의경우의수_메모이제이션 {
    static int N, R;
    static int[][] answer;

    static int solution(int N, int R) {

        // 만약 내가 찾는 값이 존재한다면 return해준다.
        if(answer[N][R] != 0) return answer[N][R];
        // 역으로 아래로 찾아 내려가는 방법이다.
        return answer[N][R] = solution(N - 1, R - 1) + solution(N - 1, R);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        answer = new int[N + 1][R + 1];

        // nCr 에서 n과 r이 같을 때 경우의 수는 1이다.
        // nCr 에서 r이 0이면 경우의 수는 1이다
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= R; j++) {
                if (i == j || j == 0) {
                    answer[i][j] = 1;
                }
            }
        }
        System.out.println(solution(N, R));
    }
}
