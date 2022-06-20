package inflearn.review.step2;
import java.util.Arrays;
import java.util.Scanner;

public class Step2_11_임시반장정하기 {
    public int solution(int[][] arr, int N){
        int answer = 1;
        // 1. 각 세로로 반복 하면서 배열 한 곳에 같은 반이였던 학생 번호에 +1
        int idx = 0;
        int max = 0;
        while(idx < N){
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < 5; j++){
                    if(idx == i) break;
                    System.out.println("기준이 되는 학생의 반 : " + arr[idx][j]);
                    System.out.println("비교 되는 학생의 반 : " + arr[i][j]);
                    if(arr[idx][j] == arr[i][j]){
                        count++;
                        break;
                    }
                }
            }
//            System.out.println("count = " + count +  "// N번째 학생 = " + (idx+1));
            if(count > max){
                answer = idx + 1;
                max = count;
            }
            idx++;
        }
        return answer;
    }
    public static void main(String[] args){
        Step2_11_임시반장정하기 T = new Step2_11_임시반장정하기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][5];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < 5; j++)
                arr[i][j] = sc.nextInt();

        System.out.println(Arrays.deepToString(arr));

        System.out.println(T.solution(arr, N));
    }
}