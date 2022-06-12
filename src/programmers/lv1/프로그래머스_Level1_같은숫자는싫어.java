package programmers.lv1;

public class 프로그래머스_Level1_같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] temp = new int[arr.length];

        temp[0] = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(temp[count-1] == arr[i]) continue;
            else {
                temp[count] = arr[i];
                count++;
            }
        }

        int[] answer = new int[count];
        for(int i = 0; i < answer.length; i++) answer[i] = temp[i];
        return answer;
    }
}
