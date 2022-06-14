package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

class 프로그래머스_Level2_위장_해쉬 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        for (Integer integer : map.values()) answer *= integer + 1;

        return answer - 1;
    }
}
