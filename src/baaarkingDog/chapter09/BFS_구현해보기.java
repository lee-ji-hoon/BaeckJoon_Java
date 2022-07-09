package baaarkingDog.chapter09;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 디버깅 편의상 toString 재정의
    @Override
    public String toString() {
        return "x : " + x + " y : " + y;
    }
}

public class BFS_구현해보기 {
    private final static int[][] board = {
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, 1, 0, -1};
    // 해당 칸을 들렸는지 확인하기 위한 배열 생성
    static boolean[][] visited = new boolean[10][7];

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        dfs();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 0, 0은 무조건 1이라는 가정하에 시작
    private static void dfs() {
        Queue<Node> queue = new LinkedList<>();
        // 시작할 Node 선택
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                // 범위를 벗어날 경우
                if(nx < 0 || nx >= 10 || ny < 0 || ny >= 7)
                    continue;
                // 이미 방문한 Node이거나 board의 값이 1이 아닌 경우
                if (visited[nx][ny] || board[nx][ny] != 1)
                    continue;

                // queue에서 빼낼 때 true 체크 하는 것이 아닌 offer와 동시에 체크해주기
                visited[nx][ny] = true;
                // 위의 예외를 다 지났으면 해당 칸은 1이라는 것이므로 queue에 추가해준다.
                queue.offer(new Node(nx, ny));
            }
        } // while문 끝
    }
}
