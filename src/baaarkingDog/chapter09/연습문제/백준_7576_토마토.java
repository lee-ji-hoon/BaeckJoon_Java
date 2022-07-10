package baaarkingDog.chapter09.연습문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_7576_토마토 {
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
        백준_7576_토마토 T = new 백준_7576_토마토();
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] tomato = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                tomato[i][j] = sc.nextInt();
                dist[i][j] = -1; // 익었을 경우 0으로 초기화 해주기 위해 기본 초기화 상태 바꾸기
            }

        // 1. 익은 토마토 전부 Queue에 담아주기
        Queue<Node> q = T.findTomato(N, M, tomato, dist);
        T.solution(N, M, tomato, dist, q);
    }

    private Queue<Node> findTomato(int N, int M, int[][] tomato, int[][] dist) {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                // 2. 익은 토마토 담고 dist[i][j] 배열은 0으로 초기화
                if (tomato[i][j] == 1) {
                    q.offer(new Node(i, j));
                    dist[i][j] = 0;
                }
        return q;
    }

    private void solution(int N, int M, int[][] tomato, int[][] dist, Queue<Node> q) {
        int max = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 배열을 초과 했을 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                // 익지 않은 토마토를 찾아야 하므로 tomato 배열의 값이 0이 아니거나 dist 배열의 값이 -1(익지 않은 토마토)이 아닌 경우 패스
                if(dist[nx][ny] != -1 || tomato[nx][ny] != 0)
                    continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));

                max = Math.max(max, dist[nx][ny]);
            }
        }
        // 3. 익지 않은 토마토가 있는지 확인
        if(!isCheckedTomato(N, M, dist, tomato))
            System.out.println(-1);
        else
            System.out.println(max);
    }

    private boolean isCheckedTomato(int N, int M, int[][] dist, int[][] tomato) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                // dist 배열(익는데 걸리는 시간 값이 -1(초기화 상태) 면서
                // tomato 배열에서 == 0(익지 않은) 경우 익지 않은 토마토 존재
                if(dist[i][j] == -1 && tomato[i][j] == 0)
                    return false;
        return true;
    }
}
