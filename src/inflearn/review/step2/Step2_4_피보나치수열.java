package inflearn.review.step2;

import java.util.Scanner;

public class Step2_4_피보나치수열 {
    static int[] answer;
    public int[] solution(int N){
        answer = new int[N];
        answer[0] = 1;
        answer[1] = 1;
        answer[2] = 2;

        pibo(N - 1);

        return answer;
    }

    static int pibo(int N){
        if(answer[N] != 0)
            return answer[N];
        else{
            answer[N] = pibo(N-1) + pibo(N-2);
        }
        return answer[N];
    }

    public static void main(String[] args){
        Step2_4_피보나치수열 T = new Step2_4_피보나치수열();
        Scanner sc=new Scanner(System.in);

        int N = sc.nextInt();
        int[] answer = T.solution(N);
        for(int num : answer)
            System.out.print(num + " ");
    }
}
