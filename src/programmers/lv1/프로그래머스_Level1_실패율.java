package programmers.lv1;

import java.util.Arrays;
import java.util.ArrayList;

class Rate{
    int index;
    double rate;

    public Rate(int index, double rate){
        this.index = index;
        this.rate = rate;
    }
}

public class 프로그래머스_Level1_실패율 {
    // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

    // 전체 스테이지 수 : N
    // 스테이지 길이   : stages  (1 <= stages[i] <= N + 1)
    // N + 1 -> N
    // 실패율이 같은 경우 작은 벊의 스테이지가 먼저 오도록 한다.
    // 스테이지의 기본 값은 0 이다.
    public int[] solution(int N, int[] stages) {
        // 스테이지 번호와 index 값 저장
        ArrayList<Rate> arr = new ArrayList<>();

        Arrays.sort(stages);
        // 현재 스테이지 진행중인 인원들 + 스테이지를 클리어한 인원
        int stagePeople = stages.length;
        int count = 0; // 스테이지에 머물러있는 유저
        for(int i = 1; i <= N; i++){
            int currentCount = 0;
            for(int j = count; j < stages.length; j++){
                if(i == stages[j]) {
                    currentCount++;
                    count++;
                }
                else break;
            }

            double rate = 0;
            if(currentCount != 0) {
                rate = (double) currentCount / (double) stagePeople;
            }
            arr.add(new Rate(i, rate));
            // 아직 클리어 못한 유저의 수를 빼줘야지 다음 스테이지에서 계산하기 편하다.
            stagePeople -= currentCount;
        }
        arr.sort(((o1, o2) -> Double.compare(o2.rate, o1.rate)));
        int[] answer = new int[N];
        for(int i = 0; i < arr.size(); i++) answer[i] = arr.get(i).index;

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
