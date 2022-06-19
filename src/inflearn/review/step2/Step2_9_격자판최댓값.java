package inflearn.review.step2;

import java.util.Scanner;

public class Step2_9_격자판최댓값 {

    public int solution(int[][] arr, int N){
        // 가로 최댓값
        int max = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum = 0;
            for(int j = 0; j < N; j++){
                sum += arr[i][j];
            }
            max = Math.max(max, sum);
        }
        // 세로 최댓값
        for(int i = 0; i < N; i++){
            sum = 0;
            for(int j = 0; j < N; j++){
                sum += arr[j][i];
            }
            max = Math.max(max, sum);
        }
        // 대각선 최댓값
        sum = 0;
        for(int i = 0; i < N; i++){
            sum+=arr[i][i];
        }
        max = Math.max(max, sum);
        int lt = N-1;
        sum = 0;
        for(int i = 0; i < N; i++){
            sum+=arr[i][lt];
            lt--;
        }
        max = Math.max(max, sum);
        return max;
    }

    public static void main(String[] args){
        Step2_9_격자판최댓값 T = new Step2_9_격자판최댓값();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();

        System.out.println(T.solution(arr, N));

    }
}
