package programmers.sort;

import java.util.ArrayList;
import java.util.Collections;

public class Lv1_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> answerArray = new ArrayList<>();
            int start = commands[i][0];
            int end = commands[i][1];
            int find = commands[i][2];
            for (int j = start-1; j <= end-1; j++) {
                answerArray.add(array[j]);
            }
            Collections.sort(answerArray);
            answer[i] = answerArray.get(find - 1);
        }
        return answer;
    }
}
