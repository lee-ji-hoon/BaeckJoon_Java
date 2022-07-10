package baaarkingDog.chapter09.기본문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_7562_나이트의이동 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static final int[] dx = {-1, 1, -1, 1, -2, 2, 2, -2};
    private static final int[] dy = {-2, -2, 2, 2, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        백준_7562_나이트의이동 T = new 백준_7562_나이트의이동();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            int[][] chess = new int[l][l];

            // 1. 시작 지점 과 도착지점 찾기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            chess[x][y] = 1;
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(x, y));

            st = new StringTokenizer(br.readLine(), " ");
            Node endNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 2. dfs 시작
            System.out.println(T.dfs(l, chess, endNode, q) - 1);
        }
    }

    private int dfs(int l, int[][] chess, Node endNode, Queue<Node> q) {
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == endNode.x && cur.y == endNode.y)
                return chess[cur.x][cur.y];

            int x = cur.x;
            int y = cur.y;
            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= l || ny < 0 || ny >= l)
                    continue;
                if(chess[nx][ny] != 0)
                    continue;

                q.offer(new Node(nx, ny));
                chess[nx][ny] = chess[x][y] + 1;
            }
        }
        return 1;
    }
}
