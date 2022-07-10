package baaarkingDog.chapter09.기본문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 백준_5427_불 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            boolean flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 1. 새로운 빌딩 만들기
            String[][] building = new String[h][w];
            int[][] fire_dist = new int[h][w];
            int[][] dog_dist = new int[h][w];
            Queue<Node> fire = new LinkedList<>();
            Queue<Node> dog = new LinkedList<>();
            for (int j = 0; j < h; j++) {
                String floor = br.readLine();
                for (int k = 0; k < w; k++) {
                    String type = String.valueOf(floor.charAt(k));
                    building[j][k] = type;
                    if(type.equals("*")) {
                        fire.offer(new Node(j, k));
                        fire_dist[j][k] = 1;
                    }
                    if (type.equals("@")) {
                        dog.offer(new Node(j, k));
                        dog_dist[j][k] = 1;
                    }
                }
            }
            // 2. 불이 퍼지는 시간 구하기
            fireDFS(building, fire_dist, fire, h, w);
            // 3. 상근이가 탈출하는 시간 구하기
            int answer = dogDFS(building, dog_dist, fire_dist, dog, h, w);
            if(answer == Integer.MAX_VALUE)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(answer);
        }
    }
    private static void fireDFS(String[][] building, int[][] dist, Queue<Node> q, int h, int w) {
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue;
                if(building[nx][ny].equals("#") || dist[nx][ny] != 0)
                    continue;

                q.offer(new Node(nx, ny));
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
    private static int dogDFS(String[][] building, int[][] dog_dist, int[][] fire_dist, Queue<Node> q, int h, int w) {
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            // 만약 벽에 닿았을 경우 탈출
            if (checkFire(x, y, w, h)) {
                answer = Math.min(answer, dog_dist[x][y]);
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue;
                if(building[nx][ny].equals("#") || dog_dist[nx][ny] != 0)
                    continue;
                if (fire_dist[nx][ny] != 0 && dog_dist[x][y] + 1 >= fire_dist[nx][ny])
                    continue;
                dog_dist[nx][ny] = dog_dist[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        return answer;
    }

    private static boolean checkFire(int x, int y, int w, int h) {
        return x + 1 == h || y + 1 == w || x  == 0 || y  == 0;
    }
}
