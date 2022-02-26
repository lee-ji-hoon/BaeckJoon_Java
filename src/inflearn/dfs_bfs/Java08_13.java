package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 이전에 풀었던 DFS 문제와 비슷한 방법
 * 대각선도 체크해야 하므로 4방향이 아닌 8방향 체크
 * 1이 혼자 있어도 섬이므로 1확인하는 순간 출력값 누적
 *
 * 1. 이동 할 방향 배열 2개 생성 (8 방향)
 * 2. 입력값들 정의
 * 3. 배열 돌면서 1인 경우 answer 누적 후 DFS 호출해서 8방향 1값 확인
 * 4. 지나간 곳은 0으로 초기화
 * 5. answer 출력
 */
public class Java08_13 {
    static int answer = 0, N;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int x, int y, int[][] board) {
        board[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1){
                    answer++;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Java08_13 T = new Java08_13();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) arr[i][j] = sc.nextInt();
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
