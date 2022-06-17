package programmers.lv2;

import java.util.Arrays;

public class 프로그래머스_Level2_카펫 {
    public int[] solution(int brown, int yellow){
        int[] answer = new int[2];

        int maxLen = (int) Math.sqrt(yellow);
        int col = 0;
        int sum = brown + yellow;
        for (int row = 3; row <= maxLen; row++) {
            if(yellow % row == 0) {
                col = sum / row;
                if((row - 2) * (col - 2) == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_카펫 solution = new 프로그래머스_Level2_카펫();
        int brown = 24;
        int yellow = 24;
        solution.solution(24, 24);
    }
}
