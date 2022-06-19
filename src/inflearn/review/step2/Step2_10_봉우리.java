package inflearn.review.step2;
import java.util.Scanner;

public class Step2_10_봉우리 {
    static int[][] arr;
    public int solution(int N){
        int answer = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int find = arr[i][j];
                if(check(find, i, j)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    static boolean check(int find, int i, int j){
        if(find > arr[i][j-1] && find > arr[i][j+1] && find > arr[i+1][j] && find > arr[i-1][j])
            return true;
        return false;
    }

    public static void main(String[] args){
        Step2_10_봉우리 T = new Step2_10_봉우리();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N+2][N+2];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                arr[i][j] = sc.nextInt();

        System.out.print(T.solution(N));
    }
}