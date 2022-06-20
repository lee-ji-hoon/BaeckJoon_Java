package inflearn.review.step3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Step3_5_연속된자연수의합 {
    public int solution(int N){
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        int sum = 0;

        int size = N / 2 + 1;
        for(int i = 1; i <= size; i++){
            if(sum + i <= N){
                queue.offer(i);
                sum+=i;
                if(sum == N){
                    answer++;
                }
            } else if(sum + i > N){
                while(true){
                    if(queue.isEmpty()){
                        queue.offer(i);
                        break;
                    }
                    sum -= queue.remove();
                    if(sum + i <= N){
                        queue.offer(i);
                        sum+=i;
                        break;
                    }
                }
                if(sum == N){
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Step3_5_연속된자연수의합 T = new Step3_5_연속된자연수의합();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.print(T.solution(N));
    }
}
