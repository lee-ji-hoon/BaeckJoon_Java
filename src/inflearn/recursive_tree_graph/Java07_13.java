package inflearn.recursive_tree_graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. Java07_12과 기본적인 개념은 똑같지만 N이 20이 아닌 10,000개 100,000개 등 늘어나게 될 경우 인접리스트 방식이 더 효율적임
 * 2. 5개라고 쳤을 때 1,2,3,4,5라는 리스트가 먼저 생성 돼야함
 * 3. 위의 리스트에 추가로 값이 들어가는것이므로 graph.get(앞 입력 값).add(뒤 입력 값
 * 4. for문이 아닌 for each 사용
 */

public class Java07_13 {

    static int N, M, answer = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public void DFS(int V) {

        if (V == N) answer++;
        else {
            for (int i : graph.get(V)) { // ArrayList에는 for-each가 제일 나음
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {

        Java07_13 T = new Java07_13();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        ch = new int[N + 1];
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) { // 객체 생성
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            graph.get(A).add(B); // A번 리스트에 접근 후 A리스트에 B값 추가
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
