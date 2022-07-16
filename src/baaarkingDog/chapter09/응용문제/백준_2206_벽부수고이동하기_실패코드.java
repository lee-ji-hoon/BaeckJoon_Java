package baaarkingDog.chapter09.응용문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2206_벽부수고이동하기_실패코드 {
    static class Node{
        int x;
        int y;
        boolean flag;

        public Node(int x, int y, boolean flag) {
            this.x = x;
            this.y = y;
            this.flag = flag;
        }
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        백준_2206_벽부수고이동하기_실패코드 T = new 백준_2206_벽부수고이동하기_실패코드();
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
        int[][] dist = new int[n][m];
        // 1. 벽 뚫기 0,0 부터 시작
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                // 2. 벽을 만났을 경우와 벽이 아닌 경우 따로 구분
                if (wall[nx][ny] == '1' && dist[nx][ny] == 0) {
                    // 3. 이전에 벽을 부쉈는지 확인하고 만약 벽을 부쉈다면 queue에 추가하지 않음
                    if(!cur.flag) {
                        q.offer(new Node(nx, ny, true));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                } else if(dist[nx][ny] == 0 || dist[nx][ny] > dist[x][y] + 1){
                    q.offer(new Node(nx, ny, cur.flag));
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(dist[i]));

        return dist[n - 1][m - 1];
    }
}
