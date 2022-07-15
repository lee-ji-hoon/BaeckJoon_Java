package baaarkingDog.chapter09.응용문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2146_다리만들기 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] isLand = new int[n][n];
        int[][] dist = new int[n][n]; // 거리 계산
        int[][] group = new int[n][n]; // 그룹화

        Queue<Node> land = new LinkedList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int isLandOrSea = Integer.parseInt(st.nextToken());
                //  1. 섬이 아닌 곳은 -1로 초기화 (계산의 간편을 위해서)
                if(isLandOrSea == 0)
                    dist[i][j] = -1;
                    // 1-1. 섬이 아닌 곳을 미리 Queue에 담아준다. 나중에 거리 계산을 위해서
                else
                    land.add(new Node(i, j));

                isLand[i][j] = isLandOrSea;
            }
        }
        // 2. 각 섬마다 그룹화를 한다.
        setGrouping(isLand, group, n);
        // 3. BFS를 통해 바다(-1)인 점들 섬에서부터 거리가 얼마나 되는지 계산하기
        setLength(land, dist, group, n);
        // 4. 최단 거리 구하기
        solution(group, dist, n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }
    }

    private static void setGrouping(int[][] isLand, int[][] grouping , int n) {
        //  2-1) 첫 dfs에 해당하는 섬 그룹은 1 다음은 2  ~ N
        int groupNumber = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isLand[i][j] != 1 || grouping[i][j] != 0)
                    continue;

                Queue<Node> q = new LinkedList<>();
                q.offer(new Node(i, j));
                grouping[i][j] = ++groupNumber;
                while(!q.isEmpty()) {
                    Node cur = q.poll();
                    int x = cur.x;
                    int y = cur.y;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                            continue;
                        if(isLand[nx][ny] != 1 || grouping[nx][ny] != 0)
                            continue;

                        q.offer(new Node(nx, ny));
                        grouping[nx][ny] = groupNumber;
                    }
                }
            }
        }
    }

    private static void setLength(Queue<Node> land, int[][] dist, int[][] group, int n) {
        // 섬에서부터 다음 섬까지의 거리 1씩 증가하면서 구하기
        while (!land.isEmpty()) {
            Node cur = land.poll();
            int x = cur.x;
            int y = cur.y;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (dist[nx][ny] != -1)
                    continue;
                dist[nx][ny] = dist[x][y] + 1;
                group[nx][ny] = group[x][y];
                land.add(new Node(nx, ny));
            }
        }
    }

    private static void solution(int[][] group, int[][] dist, int n) {
        int answer = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {

                // 4-1. 임의의 한 점과 그 인점한 점의 합이 최소가 되는 경우 구하기
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;

                    if (group[x][y] != group[nx][ny])
                        answer = Math.min(answer, dist[x][y] + dist[nx][ny]);
                }
            }
        }
        System.out.println(answer);
    }
}