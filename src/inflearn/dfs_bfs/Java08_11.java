package inflearn.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 08_10과 비슷한 개념으로 풀이
 * 2. 위치 정보를 위한 pointer 만들기
 * 3. 이동 될 때 현재 있는 곳이 1이라고 치면 1+1 = 2 이런 식으로 이전 값 + 1 해준게 다음 위치 값
 * 4. 이동 한 곳은 1로 초기화 -> 다시 돌아가지 못하게하기
 * 5. 모든 값들이 도착 못하는 경우 -1 출력 -> [7][7] == 0 -> sout(-1)
 */
class MiroPointer{
    public int x, y;

    MiroPointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Java08_11 {

    static int[][] miro, dis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public void BFS(int x, int y) {
        Queue<MiroPointer> queue = new LinkedList<>();
        queue.offer(new MiroPointer(x, y));

        miro[x][y] = 1;
        while (!queue.isEmpty()) {
            MiroPointer temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && miro[nx][ny] == 0) {
                    miro[nx][ny] = 1;
                    queue.offer(new MiroPointer(nx, ny));
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Java08_11 T = new Java08_11();
        Scanner sc = new Scanner(System.in);

        miro = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                miro[i][j] = sc.nextInt();
            }
        }
        T.BFS(1,1);
        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
