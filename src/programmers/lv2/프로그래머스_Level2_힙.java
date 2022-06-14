package programmers.lv2;

import java.util.PriorityQueue;

class 프로그래머스_Level2_힙 {
    /* 효율성 테스트 실패...
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Arrays.sort(scoville);

        int count = 0;
        for (int j : scoville) {
            if (j < K) count++;
        }

        int idx = 0;
        while(count > 0){
            // 가장 낮은 스코빌지수 + 다음 스코빌지수 * 2
            int scov = scoville[idx] + scoville[idx + 1] * 2;
            answer++;
            count--;
            scoville[idx] = 0;
            scoville[idx + 1] = scov;

            // swap
            for(int i = idx; i < scoville.length - 1; i++){
                if(scoville[i] > scoville[i + 1]) {
                    int temp = scoville[i];
                    scoville[i] = scoville[i+1];
                    scoville[i+1] = temp;
                }
            }
            idx += 1;
            if(scov >= K) count--;

            if(count == 0) break;
            if(idx >= scoville.length - 1) return -1;
        }

        return answer;
    }*/
    // 효율성 테스트 성공 코드
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int temp : scoville) pq.offer(temp);

        while(!pq.isEmpty()){
            int current = pq.poll();
            if(current < K){
                if(pq.size() == 0) return -1;
                int next = pq.poll();
                int sum = current + next * 2;
                pq.offer(sum);

                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_힙 solution = new 프로그래머스_Level2_힙();

        int[] socv = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int answer = solution.solution(socv, k);
        System.out.println("solution1 = " + answer);
    }
}
