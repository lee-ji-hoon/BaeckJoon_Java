package programmers.lv1;

import java.util.Set;
import java.util.TreeSet;

class 프로그래머스_Level1_두개뽑아더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> number = new TreeSet<>();
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                int tempNumber = numbers[i] + numbers[j];
                number.add(tempNumber);
            }
        }
        return number.stream().mapToInt(Integer::intValue).toArray();
    }
}
