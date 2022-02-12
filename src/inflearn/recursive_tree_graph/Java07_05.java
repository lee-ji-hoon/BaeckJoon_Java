package inflearn.recursive_tree_graph;

import java.util.Scanner;

/**
 * 1. N 입력
 * 2. DFS에 N값 넘김
 * 3. 1이나 2일때는 1 값 리턴
 * 4. 그 외에는 N-2 + N-1 즉 N의 왼쪽 값 2개 더하기
 *  4-1. 위에 내용으로 끝내도 코드는 돌아가지만 숫자가 커질 수록 너무 많은 양의 수를 재귀
 *  4-2. N 번째 값이 이미 0보다 크다면 더 이상 볼 필요 없이 N 번째 값 리턴
 * 5. 스택프레임 구조이므로 이전에 풀었던 for문과 속도차이가 많이 남
 */
public class Java07_05 {

    static int[] answer;

    public int DFS(int N) {
        // 없어도 돌아가지만 속도에서 차이가 엄청나게 남
        // 이미 구한 값이 존재하면 그 값을 가져오는거 이므로 "메모이제이션"이라고 불림
        if (answer[N] > 0) return answer[N];

        if (N == 1 || N == 2) return answer[N] = 1;
        else return answer[N] = DFS(N - 2) + DFS(N - 1);
    }


    public static void main(String[] args) {
        Java07_05 T = new Java07_05();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        answer = new int[N + 1];

        T.DFS(N);

        for (int i = 1; i <= N; i++) System.out.print(answer[i]  + " ");
    }
}
