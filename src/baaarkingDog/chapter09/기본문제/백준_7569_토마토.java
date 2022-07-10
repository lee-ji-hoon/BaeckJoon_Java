package baaarkingDog.chapter09.기본문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_7569_토마토 {
    static class Node{
        int h;
        int x;
        int y;

        public Node(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dh = {1, -1};

    public static void main(String[] args) throws IOException {
        백준_7569_토마토 T = new 백준_7569_토마토();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸
        int N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸
        int H = Integer.parseInt(st.nextToken()); // H번 반복

        int[][][] box = new int[H][N][M];
        int[][][] visited = new int[H][N][M];
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[i][j][k] = num;
                    // 1. 토마토 시작 지점들 미리 큐에 넣기
                    if (num == 1) {
                        q.offer(new Node(i, j, k));
                        visited[i][j][k] = 1;
                    } else if (num == 0) {
                        count++;
                    }
                }
            }
        // 2. 토마토가 이미 다 익어있는 경우
        if(count == 0){
            System.out.println("0");
            return;
        }
        // 3. 토마토들 익는 경우 확인
        T.dfs(M, N, H, q, visited, box, count);

    }

    private void dfs(int m, int n, int h, Queue<Node> q, int[][][] visited, int[][][] box, int count) {
        int answer = 0;
        int tomato = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            // 상하좌우 확인
            for (int dis = 0; dis < 4; dis++) {
                int nx = cur.x + dx[dis];
                int ny = cur.y + dy[dis];
                int nh = cur.h;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (visited[nh][nx][ny] != 0 || box[nh][nx][ny] != 0)
                    continue;

                q.offer(new Node(nh, nx, ny));
                visited[nh][nx][ny] = visited[nh][cur.x][cur.y] + 1;
                answer = visited[nh][nx][ny];
                tomato++;
            }
            // 위아래 확인
            for (int dis = 0; dis < 2; dis++) {
                int nh = cur.h + dh[dis];
                int x = cur.x;
                int y = cur.y;

                if(nh < 0 || nh >= h)
                    continue;
                if(visited[nh][x][y] != 0 || box[nh][x][y] != 0)
                    continue;

                q.offer(new Node(nh, x, y));
                visited[nh][x][y] = visited[cur.h][x][y] + 1;
                answer = visited[nh][x][y];
                tomato++;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(visited[i][j]));
            }
            System.out.println();
        }
        System.out.println("count = " + count);
        System.out.println("tomato = " + tomato);
        // 4. 토마토들 중에서 안익은게 있는지 확인
        if(count == tomato)
            System.out.println(answer - 1);
        else
            System.out.println(-1);
    }
}
