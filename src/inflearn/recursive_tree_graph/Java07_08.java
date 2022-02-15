package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 출발 지점인 s, 도착 지점 e 입력2
 * 2. 1~10000 이므로 ch는 int[100001], 1,-1,5칸 배열 및 체킁요 배열 입력
 * 3. Queue를 사용해서 s를 queue 추가
 * 4. queue가 빈 공간이 될 때까지 반복
 *  4-1. 길이를 queue.size()
 *  4-2. 0 ~ len 까지 반복
 *   4-2-1. x = queue.poll();
 *   4-2-2. 0 ~ 3번 반복 (자식의 숫자가 3개까지 나오기 때문)
 *    4-2-2-1. nx = x + dis[0~3]
 *    4-2-2-2. nx == e -> return line + 1;
 *    4-2-2-3. nx가 1보다 크거나 10000보다 작고 ch[nx] == 0 -> ch[nx] = 1, queue.offer(nx)
 *  4-3. line++;
 */

public class Java07_08 {
    int[] dis = {1, -1, 5};
    int[] ch; // 체크용 배열
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[100001];

        queue.offer(s);
        int line = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int x = queue.poll();

                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j]; // 자식 숫자들 +1 -1 +5
                    if (nx == e) return line + 1;

                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            line++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Java07_08 T = new Java07_08();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // 출발
        int e = sc.nextInt(); // 도착
        System.out.println(T.BFS(s, e));
    }
}
