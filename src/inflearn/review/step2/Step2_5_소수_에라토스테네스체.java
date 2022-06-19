package inflearn.review.step2;

import java.util.Scanner;

public class Step2_5_소수_에라토스테네스체 {
    public int solution(int N){
        int answer = 0;

        for(int i = 2; i < N; i++){
            if(isPrime(i))
                answer++;
        }
        return answer;
    }

    public boolean isPrime(int number){
        if(number == 2) return true;

        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        Step2_5_소수_에라토스테네스체 T = new Step2_5_소수_에라토스테네스체();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(T.solution(N));
    }
}