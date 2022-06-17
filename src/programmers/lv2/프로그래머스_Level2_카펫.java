package programmers.lv2;

import java.util.Arrays;

public class 프로그래머스_Level2_카펫 {
    public int[] solution(int brown, int yellow){
        int[] answer = new int[2];

        int maxLen = (int) Math.sqrt(yellow);
        int col = 0;
        for (int row = 1; row <= maxLen; row++) {
            if(yellow % row != 0) continue;
            col = yellow / row;

            if(((row+col) * 2 + 4) == brown){
                answer[0] = Math.max(col, row) + 2;
                answer[1] = Math.min(col, row) + 2;
                break;
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_카펫 solution = new 프로그래머스_Level2_카펫();
        int brown = 24;
        int yellow = 24;
        solution.solution(24, 24);
    }
}
