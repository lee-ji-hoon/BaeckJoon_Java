package inflearn.review.step5;

import java.util.Scanner;
import java.util.Stack;

public class Step5_3_크레인카카오인형뽑기_카카오 {
    public int solution(int[][] game, int[] check) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < check.length; i++) {
            // 몇 번째 열을 해야 할지 찾기
            int find = check[i] - 1;
            // 게임판에서 0이 아닌 숫자 찾아 0으로 만들기
            for (int j = 0; j < game.length; j++) {
                if (game[j][find] != 0) {
                    // 찾은 숫자가 stack왜 맨위랑 같으면
                    // stack에 추가 안하고 pop해버린다.
                    if (!stack.isEmpty() && stack.peek() == game[j][find]) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(game[j][find]);
                    }
                    // 사라진 인형은 0으로 초기화
                    game[j][find] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Step5_3_크레인카카오인형뽑기_카카오 T = new Step5_3_크레인카카오인형뽑기_카카오();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] game = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                game[i][j] = sc.nextInt();

        int M = sc.nextInt();
        int[] check = new int[M];
        for (int i = 0; i < M; i++)
            check[i] = sc.nextInt();

        System.out.print(T.solution(game, check));
    }
}
