package inflearn.review.step4;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Step4_1_학습회장 {
    public String solution(String str){
        String answer = "";
        Map<Character, Integer> maps = new HashMap<>();

        for(int i = 0; i < str.length(); i++)
            maps.put(str.charAt(i), maps.getOrDefault(str.charAt(i), 0) + 1);

        int max = 0;
        for (Map.Entry<Character, Integer> map : maps.entrySet()) {
            if(map.getValue() > max) {
                answer = String.valueOf(map.getKey());
                max = map.getValue();
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Step4_1_학습회장 T = new Step4_1_학습회장();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String str = sc.next();

        System.out.print(T.solution(str));
    }
}
