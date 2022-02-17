package inflearn.recursive_tree_graph;

import java.util.Scanner;

/**
 * 1. N과 M, M개 만큼의 연결 정보 입력
 * 1-1. 체킁요 배열 ch, 탐색용 graph 생성
 * 2. DFS(1) 호출
 * 3. v == N -> answer 증가
 * 4. else
 *  4-1. for(i = 1 ~ N)
 *   4-1-1. graph[v][i] == 1 && ch[i] == 0
 *   4-1-2. 현재 체크 배열 1 입력
 *   4-1-3. DFS(i) 호출
 *   4-1-4. 현재 체크 배열 0 초기화
 */
public class Java07_12 {

    static int N, M, answer =0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if(v == N) answer++;
        else{
            for (int i = 1; i <= N; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) { // 방문 한 지점까지 확인
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Java07_12 T = new Java07_12();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        ch = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
