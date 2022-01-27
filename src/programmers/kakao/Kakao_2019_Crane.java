package programmers.kakao;

import java.util.Stack;

/*
https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class Kakao_2019_Crane { // class 명 solution 변경
    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 인형이 저장 될 스택

        int column = 0; // moves에 있는 배열 값 입력을 위한 함수

        for (int i = 0; i < moves.length; i++) { // moves 배열 수 만큼 반복
            // moves[i] = 1 ~ 5 우리가 비교할 값은 0 ~ 4 이므로 -1 해줘야한다.
            column = moves[i] - 1;

            for (int j = 0; j < board.length; j++) { // 지정된 열의 행들을 비교
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
}
