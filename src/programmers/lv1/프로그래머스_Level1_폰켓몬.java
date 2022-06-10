package programmers.lv1;

import java.util.HashSet;

public class 프로그래머스_Level1_폰켓몬 {
    // N / 2마리 가져갈 수 있음
    // 같은 종류 == 같은 번호
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> removeDuplicate = new HashSet<>();
        for(int num : nums) removeDuplicate.add(num);

        int size = removeDuplicate.size();

        // 둘 중에 최소값이 정답임
        if(nums.length/2 < size) answer = (int) nums.length/2;
        else answer = size;


        return answer;
    }
}
