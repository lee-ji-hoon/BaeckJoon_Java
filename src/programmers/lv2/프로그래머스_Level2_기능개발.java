package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class 프로그래머스_Level2_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int progress : progresses)
            queue.add(progress);

        int day = 0;
        int count = 0;
        int idx = 0;
        while(!queue.isEmpty()){
            if(queue.peek() + (day * speeds[idx]) >= 100){
                count++;
                idx++;
                queue.remove();
                while(true){
                    if(!queue.isEmpty() && queue.peek() + (day * speeds[idx]) >= 100){
                        count++;
                        idx++;
                        queue.remove();
                    } else break;
                }
                arrayList.add(count);
                count = 0;
            }
            day++;
        }
        int[] answer = new int[arrayList.size()];
        int i = 0;
        for (Integer integer : arrayList) {
            answer[i] = integer;
            i++;
        }

        return answer;
    }
}
