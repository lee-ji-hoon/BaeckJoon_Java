package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1. N * N 배열 입력, M개의 moves 배열 입력
 * 2. 새로운 stack 및 answer, column(moves의 배열 값 입력)
 * 3. moves 배열 수 만큼 반복
 *  3-1. column = moves[i] - 1 -> moves배열은 1 ~ 5 우리가 원하는 값은 배열이므로 0 ~ 4
 *  3-2. 열값은 column 으로 고정했으므로 column 열의 행값 비교 N개 반복
 *   3-2-1. 0이 아닌 경우
 *    3-2-1-1. if stack이 비어있지 않으며, peek == board 값과 같다면 answer += 2(1쌍이 사라짐) pop()
 *    3-2-1-2. else board 값 push
 *   3-2-2. board 값 0으로 초기화 후 break; -> 이미 0이 아닌 값 비교 후 다 처리 했으므로 아래의 값은 볼 필요 없음
 * 4. return answer;
 */

public class Java05_03 {

    public int solution(int N, int[][] board, int M, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 인형이 저장 될 스택

        int column = 0; // moves에 있는 배열 값 입력을 위한 함수

        for (int i = 0; i < M; i++) { // moves 배열 수 만큼 반복
            // moves[i] = 1 ~ 5 우리가 비교할 값은 0 ~ 4 이므로 -1 해줘야한다.
            column = moves[i] - 1;

            for (int j = 0; j < N; j++) { // 지정된 열의 행들을 비교
                if(board[j][column] != 0){ // 고정된 열에서 아래로 내려가다가 0이 아닐 경우
                    /**
                     * 1. stack에 비어있는 경우의 수 생각
                     * 2. peek() 즉 stack에 마지막에 추가한 값이 board의 값과 같다면
                     */
                    if (!stack.empty() && stack.peek() == board[j][column]) {
                        answer += 2; // 터트려서 사라진 인형은 무조건 한쌍이므로 2개 누적
                        stack.pop(); // 삭제해야하므로 pop()으로 가장 마지막 추가한 내역 삭제
                    } else {
                        stack.push(board[j][column]); // 추가 할 값이 마지막으로 누적된 값과 다른경우 이므로 push()
                    }
                    board[j][column] = 0; // 원래 배열에서 stack으로 옮겨간것이므로 원래 자리는 0으로 초기화
                    break; // 그 다음 행은 비교 할 필요가 없으므로 빠져나온다.
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Java05_03 T = new Java05_03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            moves[i] = num;
        }
        System.out.println(T.solution(N, board, M, moves));
    }
}