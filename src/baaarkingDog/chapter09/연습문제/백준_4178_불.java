package baaarkingDog.chapter09.연습문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_4178_불 {
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
        백준_4178_불 T = new 백준_4178_불();
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        String[][] miro = new String[R][C];
        int[][] jihoon = new int[R][C];
        int[][] fire = new int[R][C];

        Queue<Node> fireQ = new LinkedList<>();
        Queue<Node> jihoonQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                String temp = String.valueOf(str.charAt(j));
                miro[i][j] = temp;
                // 1. 시작 위치가 여러개일 수도 있으니 J위치와 F위치 미리 Queue에 담기
                if (temp.equals("J")) {
                    jihoonQ.add(new Node(i, j));
                    jihoon[i][j] = 1;
                    fire[i][j] = -1;
                }
                else if(temp.equals("F")) {
                    fireQ.add(new Node(i, j));
                    jihoon[i][j] = -1;
                    fire[i][j] = 1;
                }else {
                    jihoon[i][j] = -1;
                    fire[i][j] = -1;
                }
            }
        }
        // 2. 불에 대한 dfs 먼저 구하기 -> 퍼지는 시간
        T.fireDFS(R, C, miro, fire, fireQ);
        // 3. 지훈이에 대한 dfs 구하기 -> 탈출 시간
        System.out.println(T.jihoonDFS(R, C, miro, fire, jihoon, jihoonQ));
    }

    private void fireDFS(int R, int C, String[][] miro, int[][] fire, Queue<Node> q) {
        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C)
                    continue;
                // 미로 벽인지 확인 + 이미 들린 노드인지 확인
                if(miro[nx][ny].equals("#") || fire[nx][ny] != -1)
                    continue;
                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
    }

    private String jihoonDFS(int R, int C, String[][] miro, int[][] fire, int[][] jihoon, Queue<Node> q) {
        while(!q.isEmpty()){
            Node cur = q.poll();
            // 3. 탈출 할 수 있는지 확인
            if(isPassable(cur.x, cur.y, R, C))
                return String.valueOf(jihoon[cur.x][cur.y]);

            // 4. 탈출을 못했으므로 계속 돌기
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C)
                    continue;
                // 미로 벽인지 확인 + 이미 들린 노드인지 확인
                if(miro[nx][ny].equals("#") || jihoon[nx][ny] != -1)
                    continue;
                // 불이 이미 퍼져있으면 안되고 + 아예 안퍼졌을 경우 전부다 -1이므로 -1인 경우도 제외 해야함
                if(fire[nx][ny] != -1 && fire[nx][ny] <= jihoon[cur.x][cur.y] + 1)
                    continue;

                jihoon[nx][ny] = jihoon[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        // 5. 탈출을 하지 못했을 경우
        return "IMPOSSIBLE";
    }

    private boolean isPassable(int nx, int ny, int r, int c) {
        return nx + 1 == r || ny + 1 == c || nx == 0 || ny == 0;
    }
}
