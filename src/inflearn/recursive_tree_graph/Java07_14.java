package inflearn.recursive_tree_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 07_13과 같은 방법으로 queue 생성, 체크를 위한 배열 말고도 최단거리 배열 추가
 * 2. Queue 현재 값 추가
 * 3. Queue 빈 값이 될 때까지 반복
 *  3-1. Queue 현재 지점 빼와서 그 지점의 list를 체크배열에서 확인 (for-each 사용)
 */
public class Java07_14 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis; // 체크, 최소거리 배열

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;

        queue.offer(v);
        while (!queue.isEmpty()) {
            int currentNum = queue.poll(); // 현재 지점
            for (int nv : graph.get(currentNum)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[currentNum] + 1;

                }
            }
        }
    }

    public static void main(String[] args) {
        Java07_14 T = new Java07_14();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());

        ch = new int[N + 1];
        dis = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
        }

        T.BFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
