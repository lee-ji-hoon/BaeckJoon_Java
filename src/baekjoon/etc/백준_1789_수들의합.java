package baekjoon.etc;

import java.util.Scanner;

public class 백준_1789_수들의합 {

    public int solution(long S){
        int answer = 0;
        long temp = 0;

        for(int i = 1; i <= S; i++){
            if(S - (temp + i) > i || S - (temp + i) == 0) {
                answer++;
                temp+=i;
                if(temp == S) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        백준_1789_수들의합 t = new 백준_1789_수들의합();

        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        int answer = t.solution(S);
        System.out.println(answer);
    }
}
