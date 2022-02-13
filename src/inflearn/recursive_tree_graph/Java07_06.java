package inflearn.recursive_tree_graph;

import java.util.Scanner;

/**
 * 1. DFS를 이용해서 풀기 위해 숫자가 주어지면 사용하는 것인지 아닌 것인지 판단
 * 2. 임시배열 temp로 주어진 숫자가 사용하면 1 아니면 0으로 초기화
 * 3. L == N + 1  * +1 인 이유는 3을 입력받았다고 했을 때 4번째까지 가서 확인해야 하기 때문
 *  3-1. answer 초기화
 *  3-2. 1 ~ N 까지 temp[i] == 1 즉 사용하는 칸이면 answeer += i
 *  3-3. 공집합은 출력하지 않으므로 length() > 0 일때면 sout
 */

public class Java07_06 {

    static int N;
    static int[] temp;

    public void DFS(int L) {
        if (L == N + 1) {
            String answer = "";
            for (int i = 1; i <= N; i++) {
                if(temp[i] == 1) answer += i + " ";
            }
            if (answer.length() > 0) System.out.println(answer);
        }else{
            temp[L] = 1;
            DFS(L + 1);
            temp[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        Java07_06 T = new Java07_06();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        temp = new int[N + 1];

        T.DFS(1);
    }
}
