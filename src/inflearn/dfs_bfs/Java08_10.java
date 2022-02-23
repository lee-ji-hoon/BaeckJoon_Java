package inflearn.dfs_bfs;

import java.util.Scanner;

/**
 * 예전에 풀었던 산봉우리 문제 재활용 하기
 * 1. 주어진 입력 작성
 * 2. nullpointer 주의하기 위해 배열을 7이 아닌 8로 입력
 * 3. dx dy -> 이동을 위한 배열 변수 생성
 * 4. x, y = 7 -> answer 누적
 * 5. i=0 ~ 4 반복 -> 4방향 보기 때문
 * 6. 이동한 곳이 바깥으로 나가는지 0인지 확인
 *  6-1. 이동하기 전에 배열위치 값을 1 입력 후 DFS 호출 후 다시 0으로 초기화
 * 7. sout(answer)
 */
public class Java08_10 {

    static int[][] mountain;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int answer;
    public void DFS(int x, int y) {
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && mountain[nx][ny] == 0) {
                    mountain[x][y] = 1;
                    DFS(nx, ny);
                    mountain[x][y] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Java08_10 T = new Java08_10();
        Scanner sc = new Scanner(System.in);

        mountain = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                mountain[i][j] = sc.nextInt();
            }
        }
        mountain[1][1] = 1;
        T.DFS(1, 1);
        System.out.println(answer);
    }
}
