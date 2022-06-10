package programmers.lv1;

import java.util.Arrays;
class 프로그래머스_Level1_체육복 {
    // 전체 학생의 수 n
    // 체육복을 도난당한 학생들의 번호가 담긴 배열 lost
    // 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);


        // 본인 체육복을 잃어버렸는데 여벌이 있다면?
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 슈트 빌려주기
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
