package baaarkingDog.chapter09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1926_그림 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        백준_1926_그림 T = new 백준_1926_그림();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로 크기
        int m = sc.nextInt(); // 가로 크기

        int[][] board = new int[n][m];
        boolean[][] checked = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = sc.nextInt();

        T.solution(n, m, board, checked);
    }

    private void solution(int n, int m, int[][] board, boolean[][] checked) {
        int max = 0;
        int count = 0;
        // 1. 시작 지점 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 2. 시작지점 찾았으면 그림의 크기 찾기 (dfs)
                if(board[i][j] == 1 && !checked[i][j]){
                    count++;
                    // 3. 찾은 크기 중에서 가장 큰 것으로 저장
                    max = Math.max(max, bfs(board, checked, i, j, n, m));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    private int bfs(int[][] board, boolean[][] checked, int i, int j, int n, int m) {
        int size = 0;
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(i, j));
        checked[i][j] = true;

        // 4. dfs시작
        while(!q.isEmpty()){
            size++;
            Node cur = q.poll();

            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(checked[nx][ny] || board[nx][ny] != 1)
                    continue;

                checked[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
        return size;
    }
}
