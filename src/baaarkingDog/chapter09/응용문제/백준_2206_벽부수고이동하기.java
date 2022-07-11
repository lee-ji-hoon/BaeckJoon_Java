package baaarkingDog.chapter09.응용문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2206_벽부수고이동하기 {
    static class Node{
        int x;
        int y;
        int cnt;
        int wall;

        public Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        백준_2206_벽부수고이동하기 T = new 백준_2206_벽부수고이동하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] wall = new char[N][M];
        for (int i = 0; i < N; i++) {
            String wallFloor = br.readLine();
            for (int j = 0; j < M; j++)
                wall[i][j] = wallFloor.charAt(j);
        }
        int answer = T.shortest_Distance(N, M, wall);
        if(answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

    private int shortest_Distance(int n, int m, char[][] wall) {
        boolean[][][] visited = new boolean[2][n][m];
        // 1. 벽 뚫기 0,0 부터 시작
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));

        // 2. visited[0][][] -> 벽을 부수지 않았을 경우
        // 2. visited[1][][] -> 벽을 부쉈을 경우
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int z = cur.wall;
            int count = cur.cnt;
            if(x == n - 1 && y == m -1)
                return count;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[z][nx][ny])
                    continue;

                // 3. 벽을 만났을 경우와 벽이 아닌 경우 따로 구분
                if(wall[nx][ny] == '0'){
                    visited[z][nx][ny] = true;
                    q.add(new Node(nx, ny, count + 1, z));
                } else if (wall[nx][ny] == '1' && z == 0) {
                    visited[z][nx][ny] = true;
                    q.add(new Node(nx, ny, count + 1, z + 1));
                }

            }
        }
        return 0;
    }
}
