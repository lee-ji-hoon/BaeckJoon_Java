package inflearn.review.step3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Step3_3_최대매출_성공코드 {
    public int solution(int[] arr, int K){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < K; i++) {
            queue.add(arr[i]);
            answer += arr[i];
        }

        int sum = answer;

        for(int i = K; i < arr.length; i++){
            int remove = queue.remove();
            queue.offer(arr[i]);
            sum = sum - remove + arr[i];

            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public static void main(String[] args){
        Step3_3_최대매출_성공코드 T = new Step3_3_최대매출_성공코드();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.print(T.solution(arr, K));
    }
}
