package programmers.lv1;

import java.util.Arrays;

public class 프로그래머스_Level1_평균구하기 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
