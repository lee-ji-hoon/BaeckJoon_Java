package programmers.lv1;

import java.util.Arrays;

class 프로그래머스_Level1_나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] temp = new int[arr.length];
        int count = 0;
        for(int arrNumber : arr) if(arrNumber % divisor == 0) temp[count++] = arrNumber;

        int[] answer;
        if(count == 0) {
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[count];
            for(int i = 0; i < count; i++){
                answer[i] = temp[i];
            }
            Arrays.sort(answer);
        }


        return answer;
    }
}
