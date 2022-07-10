package baaarkingDog.chapter09.연습문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1679_숨바꼭질 {
    public static void main(String[] args) {
        백준_1679_숨바꼭질 T = new 백준_1679_숨바꼭질();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈
        int K = sc.nextInt(); // 동생

        int[] dist = new int[100_001];
        T.solution(N, K, dist);
        System.out.println(dist[K]);
    }

    private void solution(int n, int k, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        // 1. 3가지 방향 확인 [-1, +1, *2]
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 2. 만약 이동한 방향의 값이 동생 위치와 동일하다면 answer = arr[nx];
            if(cur == k)
                break;

            int max = dist.length;
            if(cur + 1 < max && dist[cur+1] == 0) {
                dist[cur + 1] = dist[cur] + 1;
                q.offer(cur + 1);
            }
            if(cur - 1 >= 0 && dist[cur-1] == 0) {
                dist[cur - 1] = dist[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur * 2 < max && dist[cur * 2] == 0) {
                dist[cur * 2] = dist[cur] + 1;
                q.offer(cur * 2);
            }
        }
    }
}
