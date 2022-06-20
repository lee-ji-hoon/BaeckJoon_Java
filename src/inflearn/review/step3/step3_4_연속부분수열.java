package inflearn.review.step3;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class step3_4_연속부분수열 {
    public int solution(int[] arr, int M){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        for (int j : arr) {
            if (sum + j <= M) {
                queue.offer(j);
                sum+=j;

                if(sum == M){
                    answer++;
                    int remove = queue.remove();
                    sum-=remove;
                }
            } else if(sum + j > M){
                while(true){
                    int remove = queue.remove();
                    sum-=remove;
                    if(sum + j <= M)
                        break;
                }
                sum+=j;
                queue.offer(j);
                if(sum == M){
                    answer++;
                    sum -= queue.remove();
                }
            }

        }

        return answer;
    }
    public static void main(String[] args){
        step3_4_연속부분수열 T = new step3_4_연속부분수열();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.print(T.solution(arr, M));
    }
}
