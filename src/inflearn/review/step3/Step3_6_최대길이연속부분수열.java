package inflearn.review.step3;

import java.util.Scanner;

public class Step3_6_최대길이연속부분수열 {
    public int solution(int[] arr, int count){
        int answer = 0;

        int idx = 0; // 다음 이동
        int convert = 0; // 0을 1로 바꾼 카운트
        int length = 0; // 길이

        int zeroTemp = 0;
        while(arr.length > idx){
            if(arr[idx] == 0) {
                if(convert == count){
                    idx = zeroTemp;
                    length = 0;
                    convert = 0;
                    continue;
                }
                else {
                    convert++;
                    if(convert == 1)
                        zeroTemp = idx + 1;
                }
            }
            length++;
            idx++;
            answer = Math.max(length, answer);
        }
        return answer;
    }

    public static void main(String[] args){
        Step3_6_최대길이연속부분수열 T = new Step3_6_최대길이연속부분수열();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 길이
        int M = sc.nextInt(); // 변경 최대 횟수
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.println(T.solution(arr, M));
    }
}
