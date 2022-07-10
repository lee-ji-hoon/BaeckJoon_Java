package baaarkingDog.chapter09.기본문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_10026_적록색약 {
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
        백준_10026_적록색약 T = new 백준_10026_적록색약();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] human = new String[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++)
                human[i][j] = String.valueOf(str.charAt(j));
        }

        // 1. 적록색약이 아닌 사람이 봤을 때 조합(R, G, B)
        T.findColor(N, human);
        // 2. 적록색약인 사람이 봤을 때 조합 (RG, B) 이므로 R을 G로 치환
        T.setColorWeakness(N, human);
        // 3. 적록색약인 경우 DFS구하기
        T.findColor(N, human);
    }

    // 적록색약이 아닌 사람이 봤을 때
    private void findColor(int n, String[][] human) {
        // R G B 따로따로 체크
        boolean[][] visited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(!visited[i][j]) {
                    dfs(n, i, j, human, visited);
                    count++;
                }
        System.out.print(count + " ");
    }

    // 적록색약인 사람인 경우 확인하기 위해서
    private void setColorWeakness(int n, String[][] human) {
        //RG B 체크
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                // 적록색약인 경우 R == G이므로 R -> G로 바꿔주기
                if(human[i][j].equals("R"))
                    human[i][j] = "G";

    }

    // R G B 따로따로 체크하는 dfs
    private void dfs(int n, int i, int j, String[][] human, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new Node(i, j));
        String color = human[i][j];

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if(visited[nx][ny] || !human[nx][ny].equals(color))
                    continue;

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

}
