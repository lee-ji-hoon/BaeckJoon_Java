package inflearn.review.step2;

import java.util.Scanner;

public class Step2_7_점수계산 {
    public int solution(int N, int[] arr){
        int answer = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] == 1){
                count++;
                answer += count;
            } else
                count = 0;
        }
        return answer;
    }

    public static void main(String[] args){
        Step2_7_점수계산 T = new Step2_7_점수계산();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.print(T.solution(N, arr));
    }
}