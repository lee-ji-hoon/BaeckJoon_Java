package inflearn.recursive_tree_graph;

import java.util.Scanner;

/**
 * 1. DFS로 문제 풀어보기
 * 2. N == 0 일때 return
 * 3. DFS(N/2)
 * 4. N % 2 출력
 * DFS 호출 후 sout으로 출력하는 방법으로 해야 함
 */
public class Java07_03 {
    public void DFS(int N) {

        if (N == 0) return;
        else{
            DFS(N / 2);
            System.out.print(N % 2);
        }
    }

    public static void main(String[] args) {
        Java07_03 T = new Java07_03();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        T.DFS(N);

    }
}
