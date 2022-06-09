package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;

public class 프로그래머스_Level1_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int startLine = commands[i][0];
            int endLine   = commands[i][1];
            int findLine  = commands[i][2];
            ArrayList<Integer> commandList = new ArrayList<>();
            for(int j = startLine - 1; j < endLine; j++) commandList.add(array[j]);

            Collections.sort(commandList);
            answer[i] = commandList.get(findLine-1);
        }
        return answer;
    }
}
