package inflearn.review.step5;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Step5_6_공주구하기 {
    public int solution(int N, int K){

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            queue.add(i);

        int count = 0;
        while(queue.size() != 1){
            Integer remove = queue.remove();
            count++;
            if (count == K) {
                count = 0;
            } else {
                queue.add(remove);
            }
        }
        return queue.poll();
    }
    public static void main(String[] args){
        Step5_6_공주구하기 T = new Step5_6_공주구하기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.print(T.solution(N, K));
    }
}
