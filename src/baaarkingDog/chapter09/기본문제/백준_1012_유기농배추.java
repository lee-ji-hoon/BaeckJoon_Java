package baaarkingDog.chapter09.기본문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1012_유기농배추 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        백준_1012_유기농배추 T = new 백준_1012_유기농배추();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i = 0; i < t; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // k 배추가 심어져있는 위치의 개수

            // 1. 배추 땅 만들기
            int[][] land = new int[m][n];
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                land[x][y] = 1;
            }

            // 2. 배추가 이어져있는 땅 수 확인
            T.findStart(land, m, n);
        }
    }

    private void findStart(int[][] land, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        // 3. 시작 지점 찾기
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if(land[i][j] == 1 && !visited[i][j]) {
                    // 4. dfs 시작
                    dfs(land, m, n, i, j, visited);
                    count++;
                }
        // 6. 시작지점들 합 출력
        System.out.println(count);
    }

    private static void dfs(int[][] land, int m, int n, int i, int j, boolean[][] visited){
        // 5. 배추 이어져있는 부분 찾기
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                // 4방향 확인
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                // 0인 곳만 찾아야 하고 이미 들린 곳이면 안됨
                if(land[nx][ny] != 1 || visited[nx][ny])
                    continue;

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
