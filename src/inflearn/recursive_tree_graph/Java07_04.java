package inflearn.recursive_tree_graph;

import java.util.Scanner;

/**
 * 1. N 입력
 * 2. N이 1로 입력된 경우는 return 1
 * 3. 1이 아닌경우 return N * DFS(N-1);
 *  3-1 N이 5라고 가정
 *  3-2. 5 * D(4)
 *  3-3. 5 * 4 * D(3)
 *  3-4. 5 * 4 * 3 * D(2)
 *  3-5. 5 * 4 * 3 * 2 * D(1)
 *  3-6. 5 * 4 * 3 * 2 * 1
 */

public class Java07_04 {

    public int DFS(int N) {
        if (N == 1) return 1;
        else return N * DFS(N - 1);
    }

    public static void main(String[] args) {
        Java07_04 T = new Java07_04();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(T.DFS(N));
    }
}
