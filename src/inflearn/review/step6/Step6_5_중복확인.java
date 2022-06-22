package inflearn.review.step6;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Step6_5_중복확인 {
    static String solution(int N, int[] arr){
        String answer = "U";
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr)
            map.put(num, map.getOrDefault(num, 0)+1);

        for(int num : map.keySet())
            if(map.get(num) >= 2)
                return "D";

        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        System.out.print(solution(N, arr));
    }
}