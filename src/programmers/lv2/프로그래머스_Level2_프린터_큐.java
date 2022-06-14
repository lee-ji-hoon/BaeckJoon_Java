package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

class Order{
    int priority;
    int idx;

    public Order(int priority, int idx){
        this.priority = priority;
        this.idx = idx;
    }
}
public class 프로그래머스_Level2_프린터_큐 {
    public int solution(int[] priorities, int location){
        int answer = 0;
        Queue<Order> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Order order = new Order(priorities[i], i);
            queue.offer(order);
        }

        int count = 0;
        while (!queue.isEmpty()){
            Order order = queue.remove();
            if(queue.stream().anyMatch(otherJob -> order.priority < otherJob.priority)){
                queue.add(order);
            } else{
                count++;
                if(location==order.idx) break;
            }
        }

        answer = count;
        return answer;
    }
}
