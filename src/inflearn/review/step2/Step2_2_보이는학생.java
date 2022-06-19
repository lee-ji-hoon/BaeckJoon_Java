package inflearn.review.step2;

import java.util.Scanner;

public class Step2_2_보이는학생 {
    public int solution(int[] arr){
        // 1. 첫 사람은 무조건 보이고 max값으로 초기화
        int max = arr[0];
        int answer = 1;
        // 2. 1~N까지 max값보다 큰 사람 있으면 누적 + max값 초기화
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                answer++;
            }
        }
        // 3. answer 리턴
        return answer;
    }

    public static void main(String[] args){
        Step2_2_보이는학생 T = new Step2_2_보이는학생();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.print(T.solution(arr));
    }
}
