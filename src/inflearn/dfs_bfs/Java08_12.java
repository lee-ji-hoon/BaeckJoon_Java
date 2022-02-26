package inflearn.dfs_bfs;

import java.util.*;

/**
 * 08_11과 BFS 자체는 다를게 없음 거리 = 숙성기간
 *
 * 1. 시작지점을 찾기 위해서 배열에 토마토 담으면서 1인 값을 queue 저장
 * 2. BFS 돌면서 answer = Math.max(현재값, 이후값)비교
 * 3. BFS 호출 끝나면 boolean flag 생성 후 배열에 아직 0이 남아있는지 확인
 *  3-1 배열 값 == 0 flag = false
 *  3-2 배열 값 != 0 flag = true
 * 4. if flag 값이 false면 -1 출력
 * 5. else answer 출력
 */

class Point{
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Java08_12 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m, answer = Integer.MIN_VALUE;
    static Queue<Point> queue = new LinkedList<>();

    public void BFS(){
        while(!queue.isEmpty()){
            Point tmp= queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;

                    answer = Math.max(dis[nx][ny], answer);
                }
            }
        }
    }

    public static void main(String[] args){
        Java08_12 T = new Java08_12();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();

                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        T.BFS();

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        if(!flag) System.out.println(-1);
        else System.out.println(answer);
    }
}
