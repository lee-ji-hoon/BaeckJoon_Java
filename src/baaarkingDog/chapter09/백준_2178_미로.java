package baaarkingDog.chapter09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2178_미로 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        백준_2178_미로 T = new 백준_2178_미로();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] miro = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++){
            String str = sc.nextLine();
            for (int j = 0; j < M; j++)
                miro[i][j] = str.charAt(j) - '0';
        }

        T.dfs(N, M, miro, dist);
        System.out.println(dist[N-1][M-1]);
    }

    private void dfs(int N, int M, int[][] miro, int[][] dist) {
        Queue<Node> q = new LinkedList<>();

        // 1. 시작 지점은 1으로 초기화하고 다음 Node들은 현재 Node의 dist[x][y] + 1 값으로 저장
        q.offer(new Node(0, 0));
        dist[0][0] = 1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int dir = 0; dir < 4; dir ++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || dist[nx][ny] != 0 || miro[nx][ny] != 1)
                    continue;

                // 2. 현재 칸에서 이동할 수 있는 칸의 값은 = 현재 dist[Node]의 값에 + 1
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }
}
