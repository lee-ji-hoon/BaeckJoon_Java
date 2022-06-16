package programmers.lv2;

import java.util.Queue;
import java.util.LinkedList;

class 프로그래머스_Level2_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 마지막 트럭을 위해서 미리 추가
        int answer = bridge_length;
        int sum = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int truck : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(truck);
                    answer++;
                    sum += truck;
                    break;
                } else {
                    if(q.size() == bridge_length){
                        sum -= q.poll();
                        // 들어올 truck이 다리 위에 못 올라올 경우
                    } else if(sum + truck > weight){
                        q.offer(0);
                        answer++;
                        // 들어올 truck이 다리 위에 올라갈 수 있을 경우
                    } else {
                        q.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
