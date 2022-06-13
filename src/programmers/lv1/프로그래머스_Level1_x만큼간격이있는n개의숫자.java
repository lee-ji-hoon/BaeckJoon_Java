package programmers.lv1;

public class 프로그래머스_Level1_x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {

        long index = 0;
        long[] answer = new long[n];
        while(index < n) {
            index++;
            answer[(int) index] = x * index;
        }

        // 10,000,000,000 -> int 초과

        return answer;
    }
}
