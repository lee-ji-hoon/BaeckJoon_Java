package inflearn.review.step6;

import java.util.Scanner;

public class Step6_4_캐시 {
    static int[] solution(int S, int N, int[] arr) {
        int[] answer = new int[S];
        for (int x : arr) {
            int index = -1;
            for (int i = 0; i < S; i++) {
                if(x == answer[i]) index = i;
            }
            if (index == -1) {
                if (S - 1 >= 0) System.arraycopy(answer, 0, answer, 1, S - 1);
            }else{
                System.arraycopy(answer, 0, answer, 1, index);
            }
            answer[0] = x;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 캐시의 크기
        int N = sc.nextInt(); // 작업 번호
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] answer = solution(S, N, arr);
        for(int num : answer)
            System.out.print(num + " ");
    }
}
