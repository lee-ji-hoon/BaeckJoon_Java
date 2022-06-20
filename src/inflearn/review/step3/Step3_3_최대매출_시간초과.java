package inflearn.review.step3;

import java.util.Scanner;

public class Step3_3_최대매출_시간초과 {
    public int solution(int[] arr, int K){
        int answer = 0;
        int finalIndex = arr.length - K + 1;

        for(int i = 0; i < finalIndex; i++){
            int sum = 0;
            for(int j = i; j < i+K; j++)
                sum += arr[j];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
    public static void main(String[] args){
        Step3_3_최대매출_시간초과 T = new Step3_3_최대매출_시간초과();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.print(T.solution(arr, K));
    }
}
